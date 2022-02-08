package main

import "fmt"

func main() {
	fmt.Println("Ninja - 2")

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
}

//-------------------------------------

const (
	curr = 2022 - iota
	ym1  = 2022 - iota
	ym2  = 2022 - iota
	ym3  = 2022 - iota
	ym4  = 2022 - iota
)

func exercise6() {
	fmt.Println(curr, ym1, ym2, ym3, ym4)
}

//-------------------------------------
func exercise5() {
	a := `this is 
	something
	as
	a 
	raw string
	literal
	"yeah"`
	fmt.Println(a)
}

//-------------------------------------
func exercise4() {
	a := 1065
	printer(a)
	b := a << 1
	printer(b)
}

//-------------------------------------
const a = 12
const b float64 = 567.54

func exercise3() {
	fmt.Println(a, b)
}

//-------------------------------------
func exercise2() {
	x := 1
	y := 2
	a := (x == y)
	b := (x <= y)
	c := (x >= y)
	d := (x != y)
	e := (x < y)
	f := (x > y)

	fmt.Println(a, b, c, d, e, f)
}

//-------------------------------------
func exercise1() {
	printer(100)
	printer(765)
}

func printer(par int) {
	fmt.Printf("%d\t%b\t%#X\n", par, par, par)
}

//-------------------------------------
