package main

import (
	"fmt"
	"runtime"
)

func main() {
	bitShiftingIota()
	//bitShifting()
	//iotaExample()
	//constants()
	//stringPlay()
	//sysConstants()
	//numbers()
	//boolExample()
}

//-----------------------------------
const (
	_ = iota
	//kb = 1024
	kb = 1 << (iota * 10)
	mb = 1 << (iota * 10)
	gb = 1 << (iota * 10)
)

func bitShiftingIota() {
	fmt.Printf("%d\t\t%b\n", kb, kb)
	fmt.Printf("%d\t\t%b\n", mb, mb)
	fmt.Printf("%d\t%b\n", gb, gb)
}

//-----------------------------------

func bitShifting() {
	x := 4
	fmt.Printf("%d\t\t%b\n", x, x)

	y := x << 1
	fmt.Printf("%d\t\t%b\n", y, y)

	z := x >> 1
	fmt.Printf("%d\t\t%b\n", z, z)

	kb := 1024
	mb := 1024 * kb
	gb := 1024 * mb

	fmt.Printf("%d\t\t%b\n", kb, kb)
	fmt.Printf("%d\t\t%b\n", mb, mb)
	fmt.Printf("%d\t%b\n", gb, gb)
}

//-----------------------------------
const (
	aaa = iota
	bbb = iota
	ccc = iota
)

const (
	aaaa = iota
	bbbb
	cccc
)

const (
	aaaaa = iota
	bbbbb
	ccccc
	ddddd = iota
	eeeee
	fffff
)

func iotaExample() {
	fmt.Println(aaa)
	fmt.Println(bbb)
	fmt.Println(ccc)
	fmt.Println("---")
	fmt.Println(aaaa)
	fmt.Println(bbbb)
	fmt.Println(cccc)
	fmt.Println("---")
	fmt.Println(aaaaa)
	fmt.Println(bbbbb)
	fmt.Println(ccccc)
	fmt.Println(ddddd)
	fmt.Println(eeeee)
	fmt.Println(fffff)
	fmt.Println("---")
}

//-----------------------------------
/*const (aa = 42
const bb = 42.78
const cc = "James Bond"
*/
const (
	aa int     = 42
	bb float64 = 42.78
	cc string  = "James Bond"
)

func constants() {
	fmt.Println(aa)
	fmt.Println(bb)
	fmt.Println(cc)
	fmt.Printf("%T\n", aa)
	fmt.Printf("%T\n", bb)
	fmt.Printf("%T\n", cc)
}

//-----------------------------------
func stringPlay() {
	s := "Hello, playground"
	fmt.Println(s)
	fmt.Printf("%T\n", s)
	bs := []byte(s)
	fmt.Println(bs)
	fmt.Printf("%T\n", bs)
	for i := 0; i < len(s); i++ {
		fmt.Printf("%#U ", s[i])
	}
	fmt.Println("")
	for i, v := range s {
		fmt.Printf("at index position %d we have hes %#x\n", i, v)
	}

	s2 := "Róża"
	bs2 := []byte(s2)
	fmt.Println(s2)
	fmt.Println(bs2)
	fmt.Printf("%T\n", bs2)
	for i := 0; i < len(s2); i++ {
		fmt.Printf("%#U ", s2[i])
	}
	fmt.Println("")

	s3 := "世界"
	bs3 := []byte(s3)
	fmt.Println(s3)
	fmt.Println(bs3)
	fmt.Printf("%T\n", bs3)
	for i := 0; i < len(s3); i++ {
		fmt.Printf("%#U ", s3[i])
	}
}

//-----------------------------------
func sysConstants() {
	fmt.Println(runtime.GOOS)
	fmt.Println(runtime.GOARCH)
}

//-----------------------------------
var a uint8 = 255
var b int8 = 127

func numbers() {
	x := 42
	y := 42.34534
	fmt.Println(x)
	fmt.Println(y)
	fmt.Printf("%T\n", x)
	fmt.Printf("%T\n", y)
	fmt.Printf("UINT8: %v\t%T\n", a, a)
	fmt.Printf("INT8: %v\t%T\n", b, b)
}

//-----------------------------------
var x bool

func boolExample() {
	fmt.Println(x)
	x = true
	fmt.Println(x)

	a := 7
	b := 42
	fmt.Println("a == b: ", a == b)
	fmt.Println("a > b: ", a > b)
	fmt.Println("a < b: ", a < b)
	fmt.Println("a >= b: ", a >= b)
	fmt.Println("a <= b: ", a <= b)
	fmt.Println("a != b: ", a != b)
}

//-----------------------------------
