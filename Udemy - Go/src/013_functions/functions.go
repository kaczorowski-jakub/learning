package main

import "fmt"

func main() {
	recursion()
	//closure()
	//callback()
	//returningFunction()
	//anonymous()
	//interfaces()
	//methods()
	//deferTets()
	//unfurling()
	//variadic()
	//syntax()
}

func recursion() {
	fmt.Println(fac(3))
	fmt.Println(fac(4))
	fmt.Println(fac(10))
}

func fac(v int) int {
	if v <= 0 {
		return -1
	} else if v == 1 {
		return 1
	} else {
		return v * fac(v-1)
	}
}

//-------------------------------------------------
var xxx int // package scope

func closure() {
	fmt.Println(xxx)
	xxx++
	fmt.Println(xxx)
	myFunc()
	fmt.Println(xxx)

	{
		y := 212
		fmt.Println(y) // block variable
	}
	//fmt.Println(y) //undeclared name: y

	var f func() int
	f = decrementor() // this is where we instantiate x
	fmt.Println(f(), f(), f(), f())
	f = incrementor() // this is where we instantiate x
	fmt.Println(f(), f(), f(), f())
	f = decrementor() // this is where we instantiate x
	fmt.Println(f(), f(), f(), f())
	f = incrementor() // this is where we instantiate x
	fmt.Println(f(), f(), f(), f())
}

func decrementor() func() int {
	var x int
	return func() int {
		x--
		return x
	}
}

func incrementor() func() int {
	var x int
	return func() int {
		x++
		return x
	}
}

func myFunc() {
	fmt.Println("hello")
	xxx++
}

//-------------------------------------------------
func callback() {
	ii := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}
	fmt.Println("Sum all:", sumAll(ii...))
	fmt.Println("Sum even all:", sumEven(sumAll, ii...))
	fmt.Println("Sum odd all:", sumOdd(sumAll, ii...))
}

func sumAll(xi ...int) int {
	fmt.Printf("in sum all %T\n", xi)
	total := 0
	for _, v := range xi {
		total += v
	}
	return total
}

func sumEven(f func(xi ...int) int, vi ...int) int {
	fmt.Printf("in sumEven %T\n", f)
	fmt.Printf("in sumEven %T\n", vi)

	var yi []int
	for _, v := range vi {
		if v%2 == 0 {
			yi = append(yi, v)
		}
	}

	return f(yi...)
}

func sumOdd(f func(xi ...int) int, vi ...int) int {
	fmt.Printf("in sumOdd %T\n", f)
	fmt.Printf("in sumOdd %T\n", vi)

	var yi []int
	for _, v := range vi {
		if v%2 != 0 {
			yi = append(yi, v)
		}
	}

	return f(yi...)
}

//-------------------------------------------------
func returningFunction() {
	s1 := retAString()
	fmt.Println(s1)
	fmt.Println(toBeReturned1()())
	toBeReturned2()(101, "Dalmatians")
	fmt.Printf("%T\n", toBeReturned2())
}

func retAString() string {
	return "Hello"
}

func toBeReturned1() func() int {

	return func() int {
		return 12
	}
}

func toBeReturned2() func(i int, s string) {
	return func(i int, s string) {
		fmt.Println(i, s)
	}
}

//-------------------------------------------------
func anonymous() {

	func() {
		fmt.Println("Anonymous func ran")
	}()

	func(x int) {
		fmt.Println("Anonymous func ran", x)
	}(12)

	x := func() {
		fmt.Println("Anonymous func ran by variable")
	}
	x()
	fmt.Printf("%T\n", x)

}

//-------------------------------------------------
func interfaces() {
	s1 := str1{one: "ala ma kota", two: 16, three: false}
	s2 := str2{
		one: "ten test",
	}
	barH(s1)
	barA(s1)
	//barB(s1) //cannot use str1 (variable of type str1) as another value in argument to barB: missing method goAwaycompilerInvalidIfaceAssign
	barH(s2)

	var x human = s2
	x.yeald()

	//var y str1 = x.(str2) // error
	x.(str2).yeald()
	//x.(str1).yeald() //error

}

type str1 struct {
	one   string
	two   int
	three bool
}

type str2 struct {
	one string
}

func (s str1) yeald() {
	fmt.Println("Yeald: ", s.one, s.two, s.three)
}

func (s str2) yeald() {
	fmt.Println("Yeald: ", s.one)
}

/*
// wrong, h has to be a struct
func (h human) yeald2() {

}
*/

type another interface {
	goAway()
	yeald()
}

type human interface {
	yeald()
}

func barH(h human) {
	fmt.Println("I called human")
	h.yeald()
	fmt.Printf("%T\n", h)

	// assertion
	switch h.(type) {
	case str1:
		fmt.Println("str1 type assertion", h.(str1).three)
	case str2:
		fmt.Println("str2 type assertion", h.(str2).one)
	default:
		fmt.Println("Other")
	}
}

func barA(s str1) {
	fmt.Println("I called str1")
	s.yeald()
	fmt.Printf("%T\n", s)
}

func barB(a another) {
	fmt.Println("I called another")
	a.goAway()
}

//-------------------------------------------------
// this is a method which will go to all secretAgent type
func (s secretAgent) speak() {
	fmt.Println("Spoke: ", s.first, s.last)
}

// the same method but different receiver
func (s person) speak() {
	fmt.Println("Spoke: ", s.first, s.last)
}

type person struct {
	first string
	last  string
}

type secretAgent struct {
	person
	ltk bool
}

func methods() {
	sa1 := secretAgent{
		person: person{
			"James",
			"Bond",
		},
		ltk: true,
	}
	sa2 := secretAgent{
		person: person{
			"Miss",
			"Moneypenny",
		},
		ltk: true,
	}

	fmt.Println(sa1)
	sa1.speak()
	sa2.speak()
}

//-------------------------------------------------
func deferTets() {
	defer foo2()
	bar2()

	//x := defer ret()
	//acc(x)
}

func foo2() {
	fmt.Println("foo")
}

func bar2() {
	fmt.Println("bar")
}

func ret() string {
	fmt.Println("in ret()")
	return "empty"
}

func acc(s string) {
	fmt.Println("in acc()")
	fmt.Println(s)
}

//-------------------------------------------------
func unfurling() {
	xi := []int{1, 2, 3, 4, 5, 6, 7, 8, 9}
	fmt.Println(sum(xi...))
	fmt.Println(sum())
	inspect(xi...)
	inspect()
}

func inspect(x ...int) {
	fmt.Printf("%T\n", x)
	fmt.Println(len(x))
	fmt.Println(cap(x))
	fmt.Println(x)
}

func sum(x ...int) int {
	sum := 0
	for _, v := range x {
		sum += v
	}
	return sum
}

// func sum2(x ...int, v string) int { // vararg has to be at the end - the last parameter
func sum2(v string, x ...int) int {
	sum := 0
	for _, v := range x {
		sum += v
	}
	return sum
}

//-------------------------------------------------
func variadic() {
	vararg(1, 2, 3, 4, 5, 6, 7)
}

func vararg(x ...int) {
	fmt.Println(x)
	fmt.Printf("%T\n", x)
	fmt.Println(x[0:6])
	//fmt.Println(x[7:90]) // error out of bound

	sum := 0
	for _, v := range x {
		sum += v
	}
	fmt.Println(sum)
}

//-------------------------------------------------
func syntax() {
	foo()
	bar("test")
	s := woo("Blah blah")
	fmt.Println(s)
	a, b := mouse("Ian", "Fleming")
	fmt.Println(a, b)
}

func foo() {
	fmt.Println("hello from foo")
}

// everything in GO is pass by value
func bar(s string) {
	fmt.Println("Hello from bar", s)
}

// single return without ()
func woo(s string) string {
	return fmt.Sprint("Hello from woo: ", s)
}

// 2+ returns has to be within ()
func mouse(fn string, ln string) (string, bool) {
	a := fmt.Sprint(fn, ln, ", says Hello")
	b := false
	return a, b
}
