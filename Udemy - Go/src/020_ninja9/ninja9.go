package main

import (
	"fmt"
	"sync"
	"sync/atomic"
	"time"
)

func main() {
	fmt.Println("Ninja - 9")

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
}

var cnt2 int64 = 0

func exercise5() {

	wg2.Add(4)
	cnt = 0
	go incAtomic()
	go incAtomic()
	go decAtomic()
	go decAtomic()

	wg2.Wait()
	fmt.Println("Counter: ", cnt2)
}

func incAtomic() {
	for i := 0; i < 100000; i++ {
		atomic.AddInt64(&cnt2, 1)
	}
	wg2.Done()
}

func decAtomic() {
	for i := 0; i < 100000; i++ {
		atomic.AddInt64(&cnt2, -1)
	}
	wg2.Done()
}

//--------------------------

var mu sync.Mutex

func exercise4() {

	wg2.Add(4)
	cnt = 0
	go incMutex()
	go incMutex()
	go decMutex()
	go decMutex()

	wg2.Wait()
	fmt.Println("Counter: ", cnt)
}

func incMutex() {
	for i := 0; i < 100000; i++ {
		mu.Lock()
		cnt++
		mu.Unlock()
	}
	wg2.Done()
}

func decMutex() {
	for i := 0; i < 100000; i++ {
		mu.Lock()
		cnt--
		mu.Unlock()
	}
	wg2.Done()
}

//-------------------------------
var cnt int = 0
var wg2 sync.WaitGroup

func exercise3() {

	wg2.Add(4)
	cnt = 0
	go inc()
	go inc()
	go dec()
	go dec()

	wg2.Wait()
	fmt.Println("Counter: ", cnt)
}

func inc() {
	for i := 0; i < 100000; i++ {
		cnt++
	}
	wg2.Done()
}

func dec() {
	for i := 0; i < 100000; i++ {
		cnt--
	}
	wg2.Done()
}

//---------------------------
type person struct {
	name string
}

type human interface {
	speak()
}

type human2 interface {
	speak2()
}

func (p person) speak() {
	fmt.Println("Spoken", p.name)
}

func (p *person) speak2() {
	fmt.Println("Spoken2", p.name)
}

func saySomething(h human) {
	h.speak()
}

func saySomething2(h human2) {
	h.speak2()
}

func exercise2() {
	p := person{"Kuba"}
	saySomething(p)
	saySomething(&p)
	//saySomething2(p)
	saySomething2(&p)
}

//---------------------------------
var wg sync.WaitGroup

func exercise1() {

	wg.Add(2)
	go print1()
	go print2()
	wg.Wait()
}

func print1() {
	time.Sleep(time.Millisecond * 1000)
	fmt.Println("This is print1")
	wg.Done()
}

func print2() {
	time.Sleep(time.Millisecond * 1000)
	fmt.Println("This is print2")
	wg.Done()
}
