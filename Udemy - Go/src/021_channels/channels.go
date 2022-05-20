package main

import (
	"context"
	"fmt"
	"math/rand"
	"runtime"
	"sync"
	"time"
)

func main() {

	contextTest()

	//fanOut()

	//fanIn()

	//okIdomSelect()

	//selectTest()

	//rangeTest()

	//usingChannels()

	//directionalChannel()

	//unsuccessfullBuffer() // do not uncomment
	//bufferedChannel2()
	//bufferedChannel()

	//basicChannels()
	//channelsBlock()	// do not uncomment
}

func contextTest() {
	ctx := context.Background()

	fmt.Println("context:\t", ctx)
	fmt.Println("context err:\t", ctx.Err())
	fmt.Printf("context type %T\n", ctx)

	ctx, cancel := context.WithCancel(ctx)
	fmt.Println("context:\t", ctx)
	fmt.Println("context err:\t", ctx.Err())
	fmt.Printf("context type %T\n", ctx)

	cancel()

	ctx, _ = context.WithCancel(ctx)
	fmt.Println("context:\t", ctx)
	fmt.Println("context err:\t", ctx.Err())
	fmt.Printf("context type %T\n", ctx)

	ctx2, cancel2 := context.WithCancel(context.Background())
	fmt.Println("error check 1:", ctx2.Err())
	fmt.Println("num gortns  1:", runtime.NumGoroutine())

	go func() {
		n := 0
		for {
			select {
			case <-ctx.Done():
				return
			default:
				n++
				time.Sleep(time.Microsecond * 200)
				fmt.Println("Working", n)
			}
		}
	}()

	time.Sleep(time.Second * 2)
	fmt.Println("error check 2:", ctx2.Err())
	fmt.Println("num gortns  2:", runtime.NumGoroutine())

	cancel2()

	fmt.Println("error check 3:", ctx2.Err())
	fmt.Println("num gortns  3:", runtime.NumGoroutine())
}

//----------------------------
func fanOut() {
	c1 := make(chan int)
	c2 := make(chan int)

	go populate(c1)
	go fanOutIn(c1, c2)

	for v := range c2 {
		fmt.Println(v)
	}

	fmt.Println("Exiting fanOut")

}

func populate(c chan int) {
	for i := 0; i < 100; i++ {
		c <- i
	}
	close(c)
}

func fanOutIn(c1, c2 chan int) {
	var wg sync.WaitGroup
	for v := range c1 {
		wg.Add(1)
		go func(v2 int) {
			c2 <- timeConsumingWork(v2)
			wg.Done()
		}(v)
	}
	wg.Wait()
	close(c2)
}

func timeConsumingWork(n int) int {
	time.Sleep(time.Millisecond * time.Duration(rand.Intn(500)))
	return n + rand.Intn(1000)
}

//----------------------------
func fanIn() {
	eve := make(chan int)
	odd := make(chan int)
	fanin := make(chan int)

	go sendFanIn(eve, odd)
	go receiveFanIn(eve, odd, fanin)

	for v := range fanin {
		fmt.Println(v)
	}

	fmt.Println("fanIn exit")
}
func sendFanIn(eve, odd chan<- int) {
	for i := 0; i < 100; i++ {
		if i%2 == 0 {
			eve <- i
		} else {
			odd <- i
		}
	}
	close(eve)
	close(odd)
}

func receiveFanIn(eve, odd <-chan int, fanin chan<- int) {
	var wg sync.WaitGroup
	wg.Add(2)
	go func() {
		for v := range eve {
			fanin <- v
		}
		wg.Done()
	}()
	go func() {
		for v := range odd {
			fanin <- v
		}
		wg.Done()
	}()

	wg.Wait()
	close(fanin)
}

//------------------------------
func okIdomSelect() {
	eve := make(chan int)
	odd := make(chan int)
	quit := make(chan bool)
	go send2(eve, odd, quit)
	receive2(eve, odd, quit)

	/*
		// is not gonna work
		eve = make(chan int)
		odd = make(chan int)
		quit = make(chan bool)
		go send3(eve, odd, quit)
		receive3(eve, odd, quit) // this will block
	*/
	c := make(chan int)
	go func() {
		c <- 44
		close(c)
	}()

	i, ok := <-c
	fmt.Println(i, ok)

	i, ok = <-c
	fmt.Println(i, ok)
}

func receive3(eve, odd <-chan int, quit <-chan bool) {
	for {
		i, ok := <-quit
		if ok {
			fmt.Println("Bye!")
		} else {
			fmt.Println("Waiting", i)
		}
	}
}

func send3(eve, odd chan<- int, quit chan<- bool) {
	for i := 0; i < 100; i++ {
		if i%2 == 0 {
			eve <- i
		} else {
			odd <- i
		}
	}
	close(eve)
	close(odd)
	close(quit)
}

func receive2(eve, odd <-chan int, quit <-chan bool) {
	for {
		select {
		case v := <-eve:
			fmt.Println("from eve channel:", v)
		case v := <-odd:
			fmt.Println("from odd channel:", v)
		case i, ok := <-quit:
			if !ok {
				fmt.Println("not yet", i, ok)
			} else {
				fmt.Println("Quiting Bye Bye", i)
				return
			}
		}
	}
}

func send2(eve, odd chan<- int, quit chan<- bool) {
	for i := 0; i < 100; i++ {
		if i%2 == 0 {
			eve <- i
		} else {
			odd <- i
		}
	}
	// don't really need to close them
	close(eve)
	close(odd)
	quit <- true
}

//----------------------------------
func selectTest() {
	eve := make(chan int)
	odd := make(chan int)
	quit := make(chan int)

	go send(eve, odd, quit)
	receive(eve, odd, quit)
}

func receive(eve, odd, quit <-chan int) {
	for {
		select {
		case v := <-eve:
			fmt.Println("from eve channel:", v)
		case v := <-odd:
			fmt.Println("from odd channel:", v)
		case v := <-quit:
			fmt.Println("quitting from receive", v)
			return
		}
	}
}

func send(eve, odd, quit chan<- int) {
	for i := 0; i < 100; i++ {
		if i%2 == 0 {
			eve <- i
		} else {
			odd <- i
		}
	}
	// don't really need to close them
	close(eve)
	close(odd)
	quit <- 0
}

//---------------------------
func rangeTest() {
	c := make(chan int)
	go inR(c)
	outR(c)
	fmt.Println("end of rangeTest")
}
func inR(cin chan<- int) {
	for i := 0; i < 100; i++ {
		cin <- rand.Intn(100)
	}
	close(cin) // withour this the program will hang
}

func outR(cout <-chan int) {
	for v := range cout {
		fmt.Println(v)
	}
}

//----------------------
func usingChannels() {
	c := make(chan int)
	go in(c)
	out(c)
	fmt.Println("End of usingChannels()")
}

func in(cin chan<- int) {
	cin <- 101
}

func out(cout <-chan int) {
	fmt.Println(<-cout)
}

//---------------------------
func directionalChannel() {
	c := make(chan int, 2)
	cin := make(chan<- int)
	cout := make(<-chan int)

	//fmt.Println(<-cin)	//cannot receive from send-only channel cin (variable of type chan<-
	//cout <- 12	//annot send to receive-only type <-chan int

	fmt.Printf("%T\n", c)
	fmt.Printf("%T\n", cin)
	fmt.Printf("%T\n", cout)

	//c = cin	//cannot use cin (variable of type chan<- int) as chan int value in assignment
	//c = cout	//cannot use cout (variable of type <-chan int) as chan int value in assignment
	cin = c
}

//---------------------------
func unsuccessfullBuffer() {
	c := make(chan int, 1)

	c <- 43
	c <- 55

	fmt.Println(<-c)
}

func bufferedChannel2() {
	c := make(chan int, 2)

	c <- 43

	fmt.Println(<-c)
}

func bufferedChannel() {
	c := make(chan int, 1)

	c <- 43

	fmt.Println(<-c)
}

func basicChannels() {
	c := make(chan int)

	go func() {
		fmt.Println(<-c)
	}()

	c <- 43
}

func channelsBlock() {
	c := make(chan int)
	c <- 43

	fmt.Println(<-c)
}
