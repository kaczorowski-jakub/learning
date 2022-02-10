package main

import "fmt"

func main() {
	fmt.Println("Ninja - 2")

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

	fmt.Println("Exercise #5")
	exercise5()
	fmt.Println("----------")

	fmt.Println("Exercise #6, #7")
	exercise6and7(43)
	fmt.Println("----------")

	fmt.Println("Exercise #8")
	exercise8()
	fmt.Println("----------")

	fmt.Println("Exercise #9")
	exercise9()
	fmt.Println("----------")

	fmt.Println("Exercise #10")
	exercise10()
	fmt.Println("----------")

}

func exercise10() {

}

func exercise9() {
	favSport := "squash"
	switch favSport {
	case "football":
		fmt.Println("No kidding, everyone likes it, try something else")
	case "squash":
		fmt.Println("Yeah, you're the best")
	default:
		fmt.Println("Unknown for me")
	}
}

func exercise8() {
	switch {
	case true:
		fmt.Println("True")
	case false:
		fmt.Println("False")
	default:
		fmt.Println("Default")
	}
}

func exercise6and7(val int) {
	if val == 100 {
		fmt.Println("a houndred")
	} else if val > 100 {
		fmt.Println("more than a houndred")
	} else {
		fmt.Println("less than a houndred")
	}
}

func exercise5() {
	for i := 10; i <= 100; i++ {
		if i%4 == 0 {
			fmt.Println(i)
		}
	}
}

func exercise4() {
	x := 1984
	for {
		fmt.Println(x)
		x++
		if x > 2022 {
			break
		}
	}
}

func exercise3() {
	x := 1984
	for x <= 2022 {
		fmt.Println(x)
		x++
	}
}

func exercise2() {
	for i := 65; i <= 90; i++ {
		for j := 0; j < 3; j++ {
			fmt.Printf("%#U\n", i)
		}
		fmt.Println("---")
	}
}

func exercise1() {
	for x := 1; x <= 10000; x++ {
		fmt.Println(x)
	}
}
