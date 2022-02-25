package main

import "fmt"

func main() {
	fmt.Println("Ninja - 5")

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

}

func exercise4() {
	s := struct {
		name      string
		age       int
		gender    string
		friends   map[string]int
		favDrinks []string
	}{
		name:   "John",
		age:    37,
		gender: "male",
		friends: map[string]int{
			"Ioana": 123,
			"Brad":  456,
		},
		favDrinks: []string{"Cola", "Water"},
	}
	fmt.Println(s)
}

//----------------------------------------------------------------
type vehicle struct {
	doors int
	color string
}

type truck struct {
	vehicle
	fourWheel bool
}

type sedan struct {
	vehicle
	luxury bool
}

func exercise3() {
	truck := truck{
		vehicle: vehicle{
			doors: 2,
			color: "white",
		},
		fourWheel: true,
	}

	sedan := sedan{
		vehicle: vehicle{
			doors: 4,
			color: "black",
		},
		luxury: false,
	}

	truckPrinter(truck)
	sedanPrinter(sedan)
}

func sedanPrinter(sedan sedan) {
	fmt.Println("Sedan:")
	fmt.Println("Luxury: ", sedan.luxury)
	vehiclePrinter(sedan.vehicle)
}

func truckPrinter(truck truck) {
	fmt.Println("Truck:")
	fmt.Println("4WD: ", truck.fourWheel)
	vehiclePrinter(truck.vehicle)
}

func vehiclePrinter(vehicle vehicle) {
	fmt.Println("Doors: ", vehicle.doors)
	fmt.Println("Color: ", vehicle.color)
}

//----------------------------------------------------------------
func exercise2() {
	p1 := person{"Ala", "Makuch", []string{"Wanilia", "Monte"}}
	p2 := person{
		firstName: "Jagoda",
		lastName:  "Kaczorowska",
		flavors:   []string{"Czekolada", "Truskawka"},
	}
	myMap := map[string]person{p1.lastName: p1, p2.lastName: p2}
	mapPrinter(myMap)
}

func mapPrinter(myMap map[string]person) {
	for k, v := range myMap {
		fmt.Println("Key: " + k)
		personPrinter(v)
	}
}

type person struct {
	firstName string
	lastName  string
	flavors   []string
}

//----------------------------------------------------------------
func exercise1() {
	p1 := person{"Ala", "Makuch", []string{"Wanilia", "Monte"}}
	p2 := person{
		firstName: "Jagoda",
		lastName:  "Kaczorowska",
		flavors:   []string{"Czekolada", "Truskawka"},
	}

	personPrinter(p1)
	personPrinter(p2)
}

func personPrinter(p person) {
	fmt.Println(p.firstName)
	fmt.Println(p.lastName)
	for _, v := range p.flavors {
		fmt.Print(v + " ")
	}
	fmt.Println("")
}
