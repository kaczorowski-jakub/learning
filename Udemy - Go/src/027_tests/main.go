package main

import (
	"fmt"
	"strings"

	"com.os.udemy.golang.testing/mystr"
	"com.os.udemy.golang.testing/saying"
)

/*
	We can run go test -cover to see the coverage
	we can run go test -coverprofile file.out to generate a file, a next
	go tool cover -html=file.out to see a nice html view on what's covered and what's not

*/

func main() {

	benchmarkExample()
	//benchmark()

	//fmt.Println(mySum(1, 2, 100, 9912, 21))
	//fmt.Println(acdc.Sum(1, 2))
}

const a = `In the event of a discrepancy between the Dutch text of these General Terms and Conditions or other conditions which are referred to herein and any translation thereof, or in the event that the Dutch text or any translation thereof can be interpreted in different ways, the Dutch text and/or the explanation given to the Dutch text will have precedence. The determination by any court of competent
jurisdiction that one or more of the sections or provisions of these General Conditions of Sale are unenforceable shall not invalidate the General Conditions of Sale, and the decision of such court shall be given effect so as to limit to the extent possible the sections or provisions which are deemed unenforceable.`

func benchmarkExample() {
	xs := strings.Split(a, " ")

	for _, v := range xs {
		fmt.Println(v)
	}

	fmt.Println(xs)
	fmt.Printf("\n%s\n", mystr.Cat(xs))
	fmt.Printf("\n%s\n", mystr.Join(xs))

}

func benchmark() {
	fmt.Println(saying.Greet("heaven"))
}

//-----------------------------------------
func mySum(xi ...int) int {
	sum := 0
	for _, v := range xi {
		sum += v
	}
	return sum
}

func mySumFailing(xi ...int) int {
	sum := 0
	for _, v := range xi {
		sum += v
	}
	return sum + 1
}
