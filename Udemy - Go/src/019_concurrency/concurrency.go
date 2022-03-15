package main

import (
	"fmt"
	"runtime"
	"sync"
	"sync/atomic"
	"time"
)

func main() {
	atomicTest()
	//readWriteMutex()
	//mutex()
	//raceCondition()
	//basic()
}

func atomicTest() {
	var counter int64

	const gs = 100
	wg.Add(gs)
	for i := 0; i < gs; i++ {
		go func() {
			runtime.Gosched()
			atomic.AddInt64(&counter, 1)
			fmt.Println("Counter\t", atomic.LoadInt64(&counter))
			wg.Done()
		}()
	}
	fmt.Println("Goroutines:", runtime.NumGoroutine())
	wg.Wait()
	fmt.Println("Counter: ", counter)
}

//-----------------------
var cnt = 0
var rwm sync.RWMutex
var wg2 sync.WaitGroup
var end = false

func readWriteMutex() {

	wg2.Add(2)
	go read()
	go write()
	go write()
	wg2.Wait()
	end = true
}

func read() {
	for !end {
		time.Sleep(time.Millisecond * 1000)
		rwm.RLock()
		fmt.Println("I is now ", cnt)
		rwm.RUnlock()
	}
}

func write() {
	for i := 1; i < 1000; i++ {
		rwm.Lock()
		time.Sleep(time.Millisecond * 10)
		cnt++
		rwm.Unlock()
	}
	wg2.Done()
}

//-------------------------
func mutex() {
	counter := 0
	const gs = 100

	var wg sync.WaitGroup
	wg.Add(gs)
	var mu sync.Mutex

	for i := 0; i < gs; i++ {
		go func() {
			mu.Lock()
			v := counter
			//time.Sleep(time.Millisecond * 100)
			runtime.Gosched()
			v++
			counter = v
			mu.Unlock()
			wg.Done()
		}()
	}
	wg.Wait()
	fmt.Println("Counter: ", counter)
}

//----------------------------
func raceCondition() {
	counter := 0
	const gs = 100

	var wg sync.WaitGroup
	wg.Add(gs)

	for i := 0; i < gs; i++ {
		go func() {
			v := counter
			//time.Sleep(time.Millisecond * 100)
			runtime.Gosched()
			v++
			counter = v
			wg.Done()
		}()
	}
	wg.Wait()
	fmt.Println("Counter: ", counter)
}

// -----------------------------
var wg sync.WaitGroup

func basic() {

	fmt.Println("OS\t", runtime.GOOS)
	fmt.Println("ARCH\t", runtime.GOARCH)
	fmt.Println("CPUs\t", runtime.NumCPU())
	fmt.Println("GOroutines\t", runtime.NumGoroutine())

	wg.Add(1)
	go foo()
	bar()
	wg.Wait()
}

func foo() {
	for i := 0; i < 10; i++ {
		fmt.Println("foo", i)
	}
	wg.Done()
}

func bar() {
	for i := 0; i < 10; i++ {
		fmt.Println("boo", i)
	}
}
