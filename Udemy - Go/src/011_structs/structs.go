package main

import "fmt"

func main() {
	//misc1()
	//anonymousStruct()
	//silly()
	//embeddedStructure()
	//simpleStruct()
}

//---------------------
var x int

type hotdog bool
type person3 struct {
	a string
	b string
	c hotdog
}

var y hotdog

func misc1() {
	p3 := person3{"a", `this is
	something`, false}
	fmt.Println(p3)

	var b bool
	b = bool(p3.c)
	fmt.Println(b)
}

//---------------------
type person2 struct {
	first string
	last  string
	age   int
}

func anonymousStruct() {
	// predefined person2 type
	p1 := person2{"Johnny", "Bravo", 24} // hey, I don't have to define the field names but it's not recommended
	fmt.Println(p1)

	// anonymous struct type
	p2 := struct {
		first string
		last  string
		ltk   bool
	}{"Janina", "Novak", false}
	fmt.Println(p2)

	p3 := struct {
		first string
		last  string
		ltk   bool
	}{first: "P3", last: "Kloc", ltk: true} // no trailing comma
	p4 := struct {
		first string
		last  string
		ltk   bool
	}{first: "P4",
		last: "Kloc",
		ltk:  true} // no trailing comma
	p5 := struct {
		first string
		last  string
		ltk   bool
	}{first: "P5",
		last: "Kloc",
		ltk:  true, // trailing comma
	}
	fmt.Println(p3, p4, p5)
}

//---------------------
func silly() {
	x := 42
	y := 43
	z := 44
	fmt.Println(x, y, z)
	x, y, z = z, x, y
	fmt.Println(x, y, z)
}

//---------------------
func embeddedStructure() {
	sa1 := secretAgent{
		smthg: person{
			first: "John",
			last:  "Lennon",
			age:   60,
		},
		ltk: false,
	}
	sa2 := secretAgent{
		smthg: person{
			first: "James",
			last:  "Bond",
			age:   50,
		},
		ltk: true,
	}

	p1 := person{
		first: "Brian",
		last:  "Omaha",
		age:   43,
	}

	sa3 := secretAgent{
		smthg: p1,
		ltk:   false,
	}

	sa4 := secretAgent2{
		person: person{
			first: "Luke",
			last:  "Lucky",
			age:   31,
		},
		ltk: true,
	}

	fmt.Println(sa1.smthg.first+" "+sa1.smthg.last+" is allowed to kill? ", sa1.ltk)
	fmt.Println(sa2.smthg.first+" "+sa2.smthg.last+" is allowed to kill? ", sa2.ltk)
	fmt.Println(sa3.smthg.first+" "+sa3.smthg.last+" is allowed to kill? ", sa3.ltk)
	fmt.Println(sa4.first+" "+sa4.last+" is allowed to kill? ", sa3.ltk) // we dont have to do sa4.person.first but we can in case of field name collision
}

type secretAgent struct {
	smthg person // inherit person, or we can just type person which is equal to person person
	ltk   bool
}

type secretAgent2 struct {
	person
	ltk bool
}

//---------------------
type person struct {
	first string
	last  string
	age   int
}

func simpleStruct() {
	p1 := person{first: "James", last: "Bond", age: 37}
	p2 := person{first: "Miss", last: "Moneypenny"}
	fmt.Println(p1, "\n", p2)
	fmt.Println(p1.first+" "+p1.last, "\n", "\r"+p2.first+" "+p2.last)
}
