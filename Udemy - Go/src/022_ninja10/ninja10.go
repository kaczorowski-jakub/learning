package main

import (
	"fmt"
)

func main() {
	fmt.Println("Ninja - 10")

	fmt.Println("Exercise #1")
	exercise1()
	fmt.Println("----------")

	fmt.Println("Exercise #2")
	exercise2()
	fmt.Println("----------")

	fmt.Println("Exercise #3")
	exercise3()
	fmt.Println("----------")

	fmt.Println("Exercise #4")
	exercise4()
	fmt.Println("----------")

	fmt.Println("Exercise #5")
	exercise5()
	fmt.Println("----------")

	fmt.Println("Exercise #6")
	exercise6()
	fmt.Println("----------")

	fmt.Println("Exercise #7")
	exercise7()
	fmt.Println("----------")
}

func exercise7() {
	c := make(chan int)

	go func() {
		for i := 1; i <= 10; i++ {
			go func(ii int) {
				for x := 0; x < 10; x++ {
					c <- ii + x
				}
			}(i)
		}
		close(c)
	}()

	for x := range c {
		fmt.Println(x)
	}

}

func exercise6() {
	c := make(chan int)

	go func() {
		for i := 0; i < 100; i++ {
			c <- i
		}
		close(c)
	}()

	for v := range c {
		fmt.Println(v)
	}
}

func exercise5() {
	c := make(chan int)
	go func() {
		c <- 42
	}()
	v, ok := <-c
	fmt.Println(v, ok)
	close(c)
	v, ok = <-c
	fmt.Println(v, ok)
}

func exercise4() {
	q := make(chan int)
	c := gen2(q)

	for {
		select {
		case v, ok := <-c:
			if ok {
				fmt.Println(v)
			} else {
				return
			}
		}
	}
}

func gen2(q <-chan int) <-chan int {
	c := make(chan int)

	go func() {
		for i := 0; i < 100; i++ {
			c <- i
		}
		close(c)
	}()
	return c
}

//--------------------
func exercise3() {
	c := gen()
	receive(c)

	fmt.Println("about to exit")
}

func gen() <-chan int {
	c := make(chan int)
	go func() {
		for i := 0; i < 100; i++ {
			c <- i
		}
		close(c)
	}()
	return c
}

func receive(c <-chan int) {
	for v := range c {
		fmt.Println(v)
	}
}

//---------------------------
func exercise2() {
	cs := make(chan int)
	go func() {
		cs <- 42
	}()
	fmt.Println(<-cs)

	fmt.Printf("------\n")
	fmt.Printf("cs\t%T\n", cs)
}

func exercise1() {
	c := make(chan int)

	go func() { c <- 42 }()

	fmt.Println(<-c)
}
