package main

import "fmt"

func main() {
	myOwnType()
	//format()
	//zeroValue()
	//checkingTypes()
	//varKeyWord()
	//semicolonAddedAutomatically()
	//shortDeclarationOperator()
	//cannotHaveVariableAndNotUseIt()
	//printingAndReceivingPrintln()
	//printingWithFunctionCall()
}

// ------------------------------------------------------------------------
func myOwnType() {
	type hotdog int
	var b hotdog = 444
	var c int = 555

	fmt.Println("Normal way: ")
	fmt.Println(b)
	fmt.Printf("%T\n", b)
	fmt.Println(c)
	fmt.Printf("%T\n", c)

	// c = b // compilation error - wrong types
	fmt.Println("c = int(b): ")
	c = int(b)
	fmt.Println(c)
	fmt.Printf("%T\n", c)

	fmt.Println("b = hotdog(c): ")
	c = 555
	b = hotdog(c)
	fmt.Println(b)
	fmt.Printf("%T\n", b)
}

// ------------------------------------------------------------------------
func format() {
	var z = 42
	fmt.Println(z)
	fmt.Printf("%T\n", z)
	fmt.Printf("%b\n", z)
	fmt.Printf("%x\n", z)
	fmt.Printf("%#x\t%b\t%x", z, z, z)

	s := fmt.Sprintf("\n%#x\t%b\t%x", z, z, z)
	fmt.Println(s)
}

// ------------------------------------------------------------------------
var zv string
var zvi int

func zeroValue() {
	fmt.Println(zv)
	fmt.Printf("%T\n", zv)
	zv = `
	this is me
	standing here
	`
	fmt.Println(zv)
	fmt.Println(zvi)
}

// ------------------------------------------------------------------------
func checkingTypes() {
	a := 123                  // type of int
	b := "Something"          // type of string
	c := 1.34                 // type of float
	d := `dsadas "blah blah"` // back quote in a string
	fmt.Printf("%T\n", a)
	fmt.Printf("%T\n", b)
	fmt.Printf("%T\n", c)
	fmt.Printf("%T\n", d)
	fmt.Println(d)
}

// ------------------------------------------------------------------------

/* short declaration cannot be used outside the function body
// abc := 443
   but we can use declarations + assignment
*/
var abc = 123

// or declaration without intialization but with type -> default initialization of type int is 0
var efg int

func varKeyWord() {
	var x = 43
	fmt.Println(x)
	fmt.Println(abc)
	fmt.Println(efg)
}

// ------------------------------------------------------------------------
func semicolonAddedAutomatically() {
	// semicolon is added automatically to each line by the compiler
	x := 101
	fmt.Println(x)
	// but we can do it explicitly
	y := 102
	fmt.Println(y)
	// or we can use it to separate two or more statements in one line - VS will format it on save into two lines
	// z := 103; fmt.Println(z)
	a := 104
	fmt.Println(a)
}

// ------------------------------------------------------------------------
func shortDeclarationOperator() {
	x := 12 // declare and assign
	fmt.Println(x)
	x = 99
	fmt.Println(x) // assignment
	y := 100 + 24
	fmt.Println(y)
}

// ------------------------------------------------------------------------
func cannotHaveVariableAndNotUseIt() {
	// cannot have a variable and not use it in GO, so that's why we use _
	// n, e := fmt.Println("This is test", 44, false)
	n, _ := fmt.Println("This is test", 44, false)
	fmt.Println(n)
}

// ------------------------------------------------------------------------
func printingAndReceivingPrintln() {
	n, err := fmt.Println("This is test", 44, false)
	fmt.Println(n)
	fmt.Println(err)
}

// ------------------------------------------------------------------------
func printingWithFunctionCall() {
	fmt.Println("hello everyone")
	foo()

	for i := 0; i < 100; i++ {
		if i%2 == 0 {
			fmt.Println(i)
		}
	}
}

func foo() {
	fmt.Println("In foo funciton")
}

// ------------------------------------------------------------------------
