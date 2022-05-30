package main

import (
	"encoding/json"
	"fmt"
	"log"
	"sort"
	"time"

	"com.os.udemy.goweb.overview/helpers"
)

var s = "seven"

func main() {
	//jsons()
	//channels()
	//packages()
	//interfaces()
	//loops()
	//decisions()
	//slices()
	//maps()
	//structsWithFunc()
	//structs()
	//variables()
}

type Person struct {
	FistName  string `json:"first_name"`
	HairColor string `json:"hair_color"`
	HasDog    bool   `json:"has_dog"`
}

func jsons() {
	myJson := `
	[
		{
			"first_name":"Clark",
			"last_name":"Kent",
			"hair_color":"black",
			"has_dog":true
		},
		{
			"first_name":"Bruce",
			"last_name":"Wayne",
			"hair_color":"black",
			"has_dog":false
		}
	]`

	fmt.Println(myJson)
	umar := []Person{}
	err := json.Unmarshal([]byte(myJson), &umar)
	if err != nil {
		log.Println("error", err)
	}

	fmt.Println(umar)

	mySlice := []Person{
		Person{
			FistName:  "Janek",
			HairColor: "green",
			HasDog:    true,
		},
		Person{
			FistName:  "Barbra",
			HairColor: "Red",
			HasDog:    false,
		},
	}

	newJson, err := json.MarshalIndent(mySlice, "", "     ")
	if err != nil {
		log.Println("error", err)
	}

	fmt.Println(string(newJson))

}

//-----------------------
func channels() {
	intChan := make(chan int)
	defer close(intChan)

	go CalculateValue(intChan)

	fmt.Println(<-intChan)
}

const numPool = 10

func CalculateValue(intChan chan int) {
	rn := helpers.RandomNumber(numPool)
	intChan <- rn
}

//------------------------
func packages() {
	var myVar helpers.SomeType
	myVar.TypeAge = 12
	myVar.TypeName = "AAA"
}

//---------------------
type Animal interface {
	Says() string
	NumberOfLegs() int
}

type Dog struct {
	Name  string
	Breed string
}

type Gorilla struct {
	Name          string
	Color         string
	NumberofTeeth int
}

func PrintInfo(a Animal) {
	fmt.Println("This animal says", a.Says(), "and has", a.NumberOfLegs(), "legs")
}

func (d Dog) Says() string {
	return "Woof"
}

func (d Dog) NumberOfLegs() int {
	return 4
}

func (d Gorilla) Says() string {
	return "Blah"
}

func (d Gorilla) NumberOfLegs() int {
	return 2
}

func interfaces() {
	d := Dog{
		Name:  "Samson",
		Breed: "German Shephered",
	}
	PrintInfo(d)

	g := Gorilla{
		Name:          "Jack",
		Color:         "black",
		NumberofTeeth: 34,
	}

	PrintInfo(g)
}

//------------------------
func loops() {

	// at least one time
	b := false
	for i := 1; !b; i++ {
		log.Println("Iteration", i)
		b = true
	}

	// none
	b = false
	for i := 1; b; i++ {
		log.Println("Iteration", i)
		b = true
	}

	// infinit
	for {
		break
	}

	animals := make(map[string]string)
	animals["dog"] = "Fido"
	animals["car"] = "Loona"
	for t, a := range animals {
		log.Println(a, "is", t)
	}

	firstLine := "once upon a midnight dreary"
	for i, l := range firstLine {
		log.Println(i, string(l))
	}

	type User3 struct {
		FirstName string
		LastName  string
		Email     string
		Age       int
	}

	var users []User3
	users = append(users, User3{"John0", "Smith", "john9@smith.com", 30})
	users = append(users, User3{"John1", "Smith", "john1@smith.com", 31})
	users = append(users, User3{"John2", "Smith", "john2@smith.com", 32})
	users = append(users, User3{"John3", "Smith", "john3@smith.com", 33})

	for i, u := range users {
		log.Println(i, u)
	}
}

//-------------------------
func decisions() {

	i := 1
	ii := 2

	//if (i == 1) & (ii == 2) {//invalid operation: operator & not defined for (i == 1) (untyped bool value)
	if (i == 1) && (ii == 2) {
		log.Println("YES")
	}

	mv := "cat2"
	switch mv {
	case "cat":
		log.Println("mv is cat")
	case "dog":
		log.Println("mv is dog")
	default:
		log.Println("mv is unknown to the process")
	}
}

//--------------------
func slices() {
	var ms []string
	ms = append(ms, "John")
	ms = append(ms, "Barry")
	ms = append(ms, "Mary")
	ms = append(ms, "Alice")
	ms = append(ms, "Aly")
	log.Println(ms)

	sort.Strings(ms)
	log.Println(ms)

	log.Println(ms[:3])
	log.Println(ms[2:4])
}

//-----------------------
type User2 struct {
	FirstName string
	LastName  string
}

// maps are immutable and not sorted
func maps() {
	myMap := make(map[string]int)
	// or
	myMap2 := map[string]string{}

	myMap2["dog"] = "Samson"

	log.Println(myMap, myMap2)
	log.Println(myMap2["dog"])
	myMap2["dog"] = "Samson2222"
	log.Println(myMap2["dog"])

	myMap3 := map[string]User2{}
	myMap3["me"] = User2{
		FirstName: "Jakub",
		LastName:  "Kaczorowski",
	}
	log.Println(myMap3)
}

//--------------------------
type myStruct struct {
	FirstName string
}

func (m myStruct) printFirstName() string {
	return m.FirstName
}

func structsWithFunc() {
	var myVar myStruct
	myVar.FirstName = "John"
	myVar2 := myStruct{
		FirstName: "Mary",
	}
	log.Println("myVar", myVar.FirstName)
	log.Println("myVar2", myVar2.FirstName)

	log.Println(myVar.printFirstName())
}

//---------------------------
type User struct {
	FirstName   string
	LastName    string
	PhoneNumber string
	Age         int
	BirthDate   time.Time
}

func structs() {
	user := User{
		FirstName: "Trevor",
		LastName:  "Sawler",
	}

	fmt.Println(user.FirstName, user.LastName, user.BirthDate)

}

//--------------------
func variables() {
	var s2 = "six"
	log.Println("s is", s)
	log.Println("s2 is", s2)

	log.Println(saySomething("xxx"))
}

func saySomething(s string) (string, string) {
	return s, "World"
}
