package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println("Ninja -6")

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

	fmt.Println("Exercise #6 and 7")
	exercise6and7()
	fmt.Println("----------")

	fmt.Println("Exercise #8")
	exercise8()
	fmt.Println("----------")

	fmt.Println("Exercise #9")
	exercise9()
	fmt.Println("----------")

	fmt.Println("Exercise #10")
	exercise10()
	fmt.Println("----------")
}

func exercise10() {
	f := exec()
	f()
	f()
	f()
	f()
}

func exec() func() int {
	x := 0
	return func() int {
		x++
		fmt.Println(x)
		return x
	}
}

//---------------------------------
func exercise9() {
	f := func(y int) string {
		return fmt.Sprint(y) + "val"
	}
	execute(f, 1, 2, 3, 4, 5, 6, 7, 8, 0)
}

func execute(f func(y int) string, x ...int) {
	for i, v := range x {
		fmt.Println("Processing for index="+fmt.Sprint(i), "value is=", f(v))
	}
}

//---------------------------------
func exercise8() {
	f := nice()
	fmt.Println(f(11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
}

func nice() func(x ...int) string {
	y := []int{1, 2, 3, 4, 5, 6, 7, 8, 9}

	return func(x ...int) string {
		return fmt.Sprint(y, fmt.Sprint(x))
	}
}

//---------------------------------
var ff func(x int) string

func exercise6and7() {
	f := func(x int) string {
		return fmt.Sprint(x, " test")
	}

	func(x int) {
		for i := 0; i < x; i++ {
			fmt.Println(i)
		}
	}(101)

	ff = f
	fmt.Println(ff(111))
	fmt.Println(f(101))
}

//---------------------------------
type square struct {
	x int
}

type circle struct {
	r int
}

func (s square) area() float32 {
	return float32(s.x) * float32(s.x)
}

func (c circle) area() float32 {
	return float32(c.r) * math.Pi * math.Pi
}

type shape interface {
	area() float32
}

func printShape(x ...shape) {
	for _, v := range x {
		fmt.Println(v.area())
	}
}

func exercise5() {
	circle := circle{r: 15}
	square := square{x: 7}
	printShape(circle, square)
}

//---------------------------------
type person struct {
	first string
	last  string
	age   int
}

func (p person) speak() {
	fmt.Println("Hello, my name is "+p.first+" "+p.last+" and I'm", p.age)
}

func exercise4() {
	p := person{
		first: "Jan",
		last:  "Kowalski",
		age:   99,
	}
	p.speak()
}

//---------------------------------
func exercise3() {
	defer a()
	defer b()
	c()
}

func a() {
	fmt.Println("A")
}

func b() {
	fmt.Println("B-OUT1")
	defer func() {
		fmt.Println("BB")
	}()
	fmt.Println("B-OUT2")
}

func c() {
	fmt.Println("C")
}

//---------------------------------
func exercise2() {
	fmt.Println(foo2([]int{1, 2, 3, 10, 500, 433}...))
	fmt.Println(bar2([]int{1, 2, 3, 10, 500, 433}))
}

func bar2(arr []int) int {
	sum := 0
	for _, v := range arr {
		sum += v
	}
	return sum
}
func foo2(x ...int) int {
	sum := 0
	for _, v := range x {
		sum += v
	}
	return sum
}

//---------------------------------
func exercise1() {
	fmt.Println(foo())
	fmt.Println(bar())
}

func foo() int {
	return 12
}

func bar() (int, string) {
	return 12, "Ala ma kota"
}
