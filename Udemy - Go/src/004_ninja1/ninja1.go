package main

import "fmt"

func main() {
	fmt.Println("Ninja - 1")

	fmt.Println("Exercise #1")
	excercise1()
	fmt.Println("----------")

	fmt.Println("Exercise #2")
	excercise2()
	fmt.Println("----------")

	fmt.Println("Exercise #3")
	excercise3()
	fmt.Println("----------")

	fmt.Println("Exercise #4")
	excercise4()
	fmt.Println("----------")

	fmt.Println("Exercise #5")
	excercise5()
	fmt.Println("----------")
}

//--------------------------------------------------------------

type xx int

var yy xx

func excercise5() {
	fmt.Println(yy)
	fmt.Printf("%T\n", yy)
	yy = 42
	fmt.Println(yy)

	var1 := int(yy)
	fmt.Println(var1)
	fmt.Printf("%T\n", var1)
}

//--------------------------------------------------------------
func excercise4() {
	type myType int
	var x myType
	fmt.Println(x)
	fmt.Printf("%T\n", x)
	x = 42
	fmt.Println(x)
}

//--------------------------------------------------------------
var a int = 42
var b string = "James Bond"
var c bool = true

func excercise3() {
	str := fmt.Sprintf("%v %v %v", a, b, c)
	fmt.Println(str)
}

//--------------------------------------------------------------
var x int
var y string
var z bool

func excercise2() {
	fmt.Printf("x is equal to %v and it is type of %T\n", x, x)
	fmt.Printf("y is equal to %v and it is type of %T\n", y, y)
	fmt.Printf("z is equal to %v and it is type of %T\n", z, z)
}

//--------------------------------------------------------------
func excercise1() {
	x := 42
	y := "James Bond"
	z := true

	fmt.Println(x, y, z)
	fmt.Printf("x is equal to %v and it is type of %T\n", x, x)
	fmt.Printf("y is equal to %v and it is type of %T\n", y, y)
	fmt.Printf("z is equal to %v and it is type of %T\n", z, z)
}

//--------------------------------------------------------------
