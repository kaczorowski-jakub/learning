package main

import (
	"fmt"

	"com.os.golang.testing/inner"
)

func main() {

	packageTest()

	pointerNonPointerReceiver()

	newTest()
	makeTest()

	deferOrder()
	deferTestInline()

	namedParams()
}

func packageTest() {
	fmt.Println("===\nPackage test")
	Visible()
	visibleEvenIfNotInUppercase()
	inner.VisibleObj{}.VisibleFunc()

}

//----------------------------
func pointerNonPointerReceiver() {
	fmt.Println("===\nPointer and non-pointer receiver")
	s := smthg{"start"}
	s.chng1()
	fmt.Println(s)
	s.chng2()
	fmt.Println(s)
}

type smthg struct {
	val string
}

func (s smthg) chng1() {
	s.val += " chng1"
}

func (s *smthg) chng2() {
	s.val += " chng2"
}

//------------------------------------
func newTest() {
	fmt.Println("===\nNew Test")
	key := new(mapKey)
	val := new(mapValue)
	key.no = 100
	key.desc = "ABC"
	val.fname = "Jan"
	val.lname = "Kowalski"
	val.age = 98
	fmt.Println(key, val)

	key2 := &mapKey{50, "xyz"}
	fmt.Println(key2)
	key2.desc = "something new"
	fmt.Println(key2)
	fmt.Printf("%T", key2)

	key3 := mapKey{0, "classic"}
	fmt.Println(key3)
	fmt.Printf("%T\n", key3)

	c := customer{}.New("admin", "admin@wp.pl")
	fmt.Println(c)
}

func makeTest() {
	fmt.Println("===\nMake Test")
	a := make(map[mapKey]mapValue)
	a[mapKey{1, "Fast"}] = mapValue{"Alina", "Banach", 54}
	fmt.Println(a)
}

type mapKey struct {
	no   int
	desc string
}

type mapValue struct {
	fname string
	lname string
	age   int
}

type customer struct {
	uid   string
	email string
}

func (c customer) New(uid string, email string) customer {
	return customer{uid, email}
}

//--------------------------------------
func deferTestInline() {
	fmt.Println("===\nDefer Test Inline")
	a := 101

	defer fmt.Println("Inline:", a) // a is being evaluated at compile time
	defer func() {
		fmt.Println("Inner func:", a) // here it is not because it's a anonymous function
	}()

	a++
	fmt.Println("On exit:", a)

}

func deferOrder() {
	fmt.Println("===\nDefer Order")
	fmt.Println("start")
	for i := 1; i <= 5; i++ {
		defer fmt.Println(i)
	}
	fmt.Println("end")
}

//--------------------------
func namedParams() {
	fmt.Println("===\nNamed Return Parameters")
	fmt.Println(ret1(1, "Ala "))
	fmt.Println(ret2(12, "Ala2 "))
}

func ret1(i int, s string) (a string, b int) {
	a = s + "add"
	b = i + 100

	return a, b
}

func ret2(i int, s string) (a string, b int) {
	a = s + "add"
	b = i + 100

	return
}