package main

import "fmt"

func main() {
	fmt.Println("Ninja -7")

	fmt.Println("Exercise #1")
	exercise1()
	fmt.Println("----------")

	fmt.Println("Exercise #2")
	exercise2()
	fmt.Println("----------")
}

func exercise2() {
	p := person{
		name: "Bond",
	}
	fmt.Println(p)
	changeMe(p)
	fmt.Println(p)
	changeMe2(&p)
	fmt.Println(p)
}

type person struct {
	name string
}

func changeMe(p person) {
	p.name = "Mark"
}

func changeMe2(p *person) {
	p.name = "Mark"
	// or
	//(*p).name = "Allan"
}

//--------------------
func exercise1() {
	x := 65.454
	fmt.Println(&x)
}
