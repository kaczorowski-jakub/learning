package main

import "fmt"

func main() {
	switchOnValues()
	//switchOnValue()
	//switchCheckingDefault()
	//switchCheckingFallthrough()
	//switchChecking()
	//ifElseChecking()
	//ifChecking()
	//printAsciiFor()
	//evenNumbersFor()
	//emptyForDef()
	//notFullForDef()
	//nestedLoop()
	//loop()
}

func switchOnValues() {
	str := "James"
	switch str {
	case "John", "Jame":
		fmt.Println("John or Jame")
	case "James", "Bruce":
		fmt.Println("James or Bruce")
	default:
		fmt.Println("other")
	}
}

func switchOnValue() {
	switch "Bond" {
	case "bond":
		fmt.Println("bond")
	case "Bond":
		fmt.Println("Bond")
	default:
		fmt.Println("Other")
	}
}

func switchCheckingDefault() {
	switch {
	case false:
		fmt.Println("false")
	case false:
		fmt.Println("true")
	case 2 == 4:
		fmt.Println("2==4")
	case 3 == 4:
		fmt.Println("3==3")
	default:
		fmt.Println("Default")
	}
}

func switchCheckingFallthrough() {
	switch {
	case false:
		fmt.Println("false")
	case true:
		fmt.Println("true")
		fallthrough // will execute the next case without checking its conditions
	case 2 == 4:
		fmt.Println("2==4")
	case 3 == 3:
		fmt.Println("3==3")
	}
}

func switchChecking() {
	// we don't have to specify the switch
	switch {
	case false:
		fmt.Println("false")
		// we don't have to put breaks
	case true:
		fmt.Println("true")
	case 2 == 4:
		fmt.Println("2==4") // this one will not appear because of the above
	case 3 == 3:
		fmt.Println("3==3")
	}
}

func ifElseChecking() {
	if x := 49; x == 48 {
		fmt.Println("value is 48")
	} else if x == 47 {
		fmt.Println("valye is 47")
	} else if x == 49 {
		fmt.Println("value is 49")
	} else {
		fmt.Println("value is different", x)
	}
	//fmt.Printf(x) // here x is undefined
}

func ifChecking() {
	if true {
		fmt.Println("001")
	}
	if false {
		fmt.Println("002")
	}
	if !true {
		fmt.Println("003")
	}
	if !false {
		fmt.Println("004")
	}

	if x := 42; x == 2 {
		fmt.Println("Hello")
	} else {
		fmt.Println("Not hello", x)
	}
	//fmt.Printf(x) // here x is undefined

}

func printAsciiFor() {
	for i := 33; i < 122; i++ {
		fmt.Printf("%v ---> %#U\n", i, i)
	}
}

func evenNumbersFor() {
	x := 0
	for {
		if x > 100 {
			break
		}
		x++
		if (x % 2) != 0 {
			continue
		}
		fmt.Println(x)
	}

}

func emptyForDef() {
	x := 1
	for {
		if x > 6 {
			break
		}
		fmt.Println(x)
		x++
	}
}

func notFullForDef() {
	x := 1
	for x < 10 {
		fmt.Println(x)
		x++
	}
}

func nestedLoop() {
	for i := 0; i <= 100; i++ {
		for j := 0; j < 3; j++ {
			fmt.Println(i, j)
		}
	}
}

func loop() {

	for i := 0; i <= 100; i++ {
		fmt.Println(i)
	}

}
