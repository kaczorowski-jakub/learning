package acdc

import "fmt"

// run godoc -http=:8080
// go to http://localhost:8080/pkg/com.os.udemy.golang.testing/acdc/#example_Sum
func ExampleSum() {
	fmt.Println(Sum(2, 3))
	// Output:
	// 5
}

/*
// this one fails
func ExampleSum2() {
	fmt.Println(Sum(2, 3))
	// Output:
	// 7
}
*/
