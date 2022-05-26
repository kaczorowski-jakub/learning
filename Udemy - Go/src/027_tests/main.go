package main

import (
	"fmt"

	"com.os.udemy.golang.testing/acdc"
	"com.os.udemy.golang.testing/saying"
)

func main() {
	benchmark()

	fmt.Println(mySum(1, 2, 100, 9912, 21))
	fmt.Println(acdc.Sum(1, 2))
}

func benchmark() {
	fmt.Println(saying.Greet("heaven"))
}

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
