package main

import (
	"fmt"
	"math"
)

func main() {
	methodSet()
	//testingPointer()
	//simplePointer()
}

func methodSet() {
	circle := circle{r: 15}
	printShape(&circle) //	pointer value and pointer receiver
	printShape(&circle)
	//printShape(circle) // value and pointer receiver won't work but when we change (c *circle) to (c circle) all the lines will be fine
}

type circle struct {
	r int
}

func (c *circle) area() float32 {
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

//------------------------
func testingPointer() {
	x := 0
	fmt.Println("before any foo", x, "and the addres", &x)
	foo(x)
	fmt.Println("after foo", x, "and the addres", &x)
	foo2(&x)
	fmt.Println("after foo2", x, "and the addres", &x)
}
func foo(y int) {
	y = 99
	fmt.Println("in foo", y, "and the addres", &y)
}
func foo2(y *int) {
	*y = 99
	fmt.Println("in foo2", *y, "and the addres", y)
}

//------------------------

func simplePointer() {
	a := 42
	fmt.Println(a)
	fmt.Printf("%T\n", a)
	fmt.Println(&a) // & gives the address
	fmt.Printf("%T\n", &a)
	checkAddrPointer(a)
	checkAddrPointer2(&a)
	referenceInUse()
	typeChecking()
}

func checkAddrPointer(x int) {
	fmt.Println("checkAddrByVal")
	fmt.Println("value: ", x)
	fmt.Println("address (copy)", &x)
}

func checkAddrPointer2(x *int) {
	fmt.Println("checkAddrByRef")
	fmt.Println("address: ", x)
	fmt.Println("value: ", *x) // * gives the value under address
}

func referenceInUse() {
	fmt.Println("Changing the value by pointer")
	a := 54
	b := &a
	*b = 55 // assign 55 to value under b address
	fmt.Println(a)
}

func typeChecking() {
	fmt.Println("Checking the type of the pointers")
	a := 54
	c := 43.32
	fmt.Printf("%T %T %T %T", a, &a, c, &c)
}
