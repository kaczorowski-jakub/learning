package main

import (
	"fmt"

	"com.os.udemy.golang.ninja13/dog"
	"com.os.udemy.golang.ninja13/mymath"
	"com.os.udemy.golang.ninja13/quote"
	"com.os.udemy.golang.ninja13/word"
)

func main() {
	fmt.Println("Ninja - 13")

	fmt.Println("Exercise #1")
	exercise1()
	fmt.Println("----------")

	fmt.Println("Exercise #2")
	exercise2()
	fmt.Println("----------")

	fmt.Println("Exercise #3")
	exercise3()
	fmt.Println("----------")
}

func exercise3() {
	ma := mymath.Gen()

	for _, v := range ma {
		fmt.Println(mymath.CenteredAvg(v))
	}
}

func exercise2() {
	for k, v := range word.UseCount(quote.SunAlso) {
		fmt.Println(v, k)
	}
	fmt.Println("# of words", word.Count(quote.SunAlso))
}

func exercise1() {
	// this is not rellevant - the job is done in dog folder
	fmt.Println(dog.Years(100))
}
