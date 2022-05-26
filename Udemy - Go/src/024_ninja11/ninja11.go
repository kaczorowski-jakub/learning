package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"log"
)

func main() {
	fmt.Println("Ninja - 11")

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
	_, err := sqrt(-10.23)
	if err != nil {
		log.Println(err)
	}
}

type sqrtError struct {
	lat  string
	long string
	err  error
}

func (se sqrtError) Error() string {
	return fmt.Sprintf("math error: %v %v %v", se.lat, se.long, se.err)
}

func sqrt(f float64) (float64, error) {
	if f < 0 {
		return 0, sqrtError{"10.121", "54.123", errors.New("no sqrt of <0")}
	}
	return 42, nil
}

//---------------------------
func exercise3() {
	ce := customError{101, "FUN"}
	foo(ce)
}

func foo(e error) {
	fmt.Println(e)
}

type customError struct {
	extraInt int
	extraStr string
}

func (ce customError) Error() string {
	return fmt.Sprint("My custom error ", ce.extraInt, " ", ce.extraStr)
}

//--------------------------------
func exercise2() {
	p1 := person{
		First:   "James",
		Last:    "Bond",
		Sayings: []string{"Shaken, not stirred", "Any last wishes", "Never say never"},
	}

	bs, err := toJSON(p1)
	if err != nil {
		fmt.Println(err)
		return
	}

	fmt.Println(string(bs))
}

func toJSON(a interface{}) ([]byte, error) {
	bs, err := json.Marshal(a)
	if err != nil {
		return []byte{}, fmt.Errorf("Error when marshaling", err)
	}
	return bs, err
}

//--------------------------------
type person struct {
	First   string
	Last    string
	Sayings []string
}

func exercise1() {
	p1 := person{
		First:   "James",
		Last:    "Bond",
		Sayings: []string{"Shaken, not stirred", "Any last wishes", "Never say never"},
	}
	bs, err := json.Marshal(p1)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(string(bs))
	}
}
