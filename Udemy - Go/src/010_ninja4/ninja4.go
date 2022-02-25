package main

import "fmt"

func main() {
	fmt.Println("Ninja - 4")

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

	fmt.Println("Exercise #6")
	exercise6()
	fmt.Println("----------")

	fmt.Println("Exercise #7")
	exercise7()
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
	myMap := map[string][]string{
		"bond_james":      {"Shaken, not stirred", "Martini", "Women"},
		"moneypenny_miss": {"James Bond", "Literatur", "Computer Science"},
		"no_dr":           {"Being evil", "Ice cream", "Sunset"},
	}

	delete(myMap, "no_dr")

	if _, ok := myMap["no_dr"]; !ok {
		fmt.Println("no_dr has been deleted")
	}

	for k, v := range myMap {
		fmt.Println("this is the record for", k)
		for i, v2 := range v {
			fmt.Println("\t", i, v2)
		}
	}
}

func exercise9() {
	myMap := map[string][]string{
		"bond_james":      {"Shaken, not stirred", "Martini", "Women"},
		"moneypenny_miss": {"James Bond", "Literatur", "Computer Science"},
		"no_dr":           {"Being evil", "Ice cream", "Sunset"},
	}

	myMap["jakub"] = []string{"one", "two"}

	for k, v := range myMap {
		fmt.Println("this is the record for", k)
		for i, v2 := range v {
			fmt.Println("\t", i, v2)
		}
	}
}

func exercise8() {
	myMap := map[string][]string{
		"bond_james":      {"Shaken, not stirred", "Martini", "Women"},
		"moneypenny_miss": {"James Bond", "Literatur", "Computer Science"},
		"no_dr":           {"Being evil", "Ice cream", "Sunset"},
	}

	for k, v := range myMap {
		fmt.Println("this is the record for", k)
		for i, v2 := range v {
			fmt.Println("\t", i, v2)
		}
	}
}

func exercise7() {
	x := [][]string{{"James", "Bond", "Shaken, not stirred"}, {"Miss", "Moneypenny", "Helloooooo, James."}}
	for i, v := range x {
		fmt.Println(x[i])
		fmt.Println(v)
	}

	for i, v1 := range x {
		fmt.Println("Record no: ", i)
		for j, v2 := range v1 {
			fmt.Println("Piece: ", j, " of value: ", v2)
		}
	}
}

func exercise6() {
	x := make([]string, 50, 50)
	x = append(x, ` Alabama`, ` Alaska`, ` Arizona`, ` Arkansas`, ` California`, ` Colorado`, ` Connecticut`, ` Delaware`, ` Florida`, ` Georgia`, ` Hawaii`, ` Idaho`, ` Illinois`, ` Indiana`, ` Iowa`, ` Kansas`, ` Kentucky`, ` Louisiana`, ` Maine`, ` Maryland`, ` Massachusetts`, ` Michigan`, ` Minnesota`, ` Mississippi`, ` Missouri`, ` Montana`, ` Nebraska`, ` Nevada`, ` New Hampshire`, ` New Jersey`, ` New Mexico`, ` New York`, ` North Carolina`, ` North Dakota`, ` Ohio`, ` Oklahoma`, ` Oregon`, ` Pennsylvania`, ` Rhode Island`, ` South Carolina`, ` South Dakota`, ` Tennessee`, ` Texas`, ` Utah`, ` Vermont`, ` Virginia`, ` Washington`, ` West Virginia`, ` Wisconsin`, ` Wyoming`)
	fmt.Println(x)
	fmt.Println(cap(x))
	fmt.Println(len(x))

	y := make([]string, 50, 50)
	y = append(y[0:0], ` Alabama`, ` Alaska`, ` Arizona`, ` Arkansas`, ` California`, ` Colorado`, ` Connecticut`, ` Delaware`, ` Florida`, ` Georgia`, ` Hawaii`, ` Idaho`, ` Illinois`, ` Indiana`, ` Iowa`, ` Kansas`, ` Kentucky`, ` Louisiana`, ` Maine`, ` Maryland`, ` Massachusetts`, ` Michigan`, ` Minnesota`, ` Mississippi`, ` Missouri`, ` Montana`, ` Nebraska`, ` Nevada`, ` New Hampshire`, ` New Jersey`, ` New Mexico`, ` New York`, ` North Carolina`, ` North Dakota`, ` Ohio`, ` Oklahoma`, ` Oregon`, ` Pennsylvania`, ` Rhode Island`, ` South Carolina`, ` South Dakota`, ` Tennessee`, ` Texas`, ` Utah`, ` Vermont`, ` Virginia`, ` Washington`, ` West Virginia`, ` Wisconsin`, ` Wyoming`)
	fmt.Println(y)
	fmt.Println(cap(y))
	fmt.Println(len(y))

	// or we can do for
	z := make([]string, 50, 50)
	states := []string{` Alabama`, ` Alaska`, ` Arizona`, ` Arkansas`, ` California`, ` Colorado`, ` Connecticut`, ` Delaware`, ` Florida`, ` Georgia`, ` Hawaii`, ` Idaho`, ` Illinois`, ` Indiana`, ` Iowa`, ` Kansas`, ` Kentucky`, ` Louisiana`, ` Maine`, ` Maryland`, ` Massachusetts`, ` Michigan`, ` Minnesota`, ` Mississippi`, ` Missouri`, ` Montana`, ` Nebraska`, ` Nevada`, ` New Hampshire`, ` New Jersey`, ` New Mexico`, ` New York`, ` North Carolina`, ` North Dakota`, ` Ohio`, ` Oklahoma`, ` Oregon`, ` Pennsylvania`, ` Rhode Island`, ` South Carolina`, ` South Dakota`, ` Tennessee`, ` Texas`, ` Utah`, ` Vermont`, ` Virginia`, ` Washington`, ` West Virginia`, ` Wisconsin`, ` Wyoming`}
	for i, v := range states {
		z[i] = v
	}
	fmt.Println(cap(z))
	fmt.Println(len(z))

}

func exercise5() {
	x := []int{42, 43, 44, 45, 46, 47, 48, 49, 50, 51}
	y := append(x[:3], x[6:]...)
	fmt.Println(y)
}

func exercise4() {
	x := []int{42, 43, 44, 45, 46, 47, 48, 49, 50, 51}
	x = append(x, 52)
	fmt.Println(x)
	x = append(x, 53, 54, 55)
	fmt.Println(x)
	x = append(x, []int{56, 57, 58, 59, 60}...)
	fmt.Println(x)
}

func exercise3() {
	arr := []int{42, 43, 44, 45, 46, 47, 48, 49, 50, 51}
	fmt.Println(arr[:5])
	fmt.Println(arr[5:])
	fmt.Println(arr[2:7])
	fmt.Println(arr[1:6])
}

func exercise2() {
	arr := []int{10, 20, 100, 200, -32, -54, -101, -67, 544, 2121}
	for i, v := range arr {
		fmt.Println(i, v)
	}
	fmt.Printf("%T\n", arr)
}

func exercise1() {
	var arr [5]int
	for i, _ := range arr {
		arr[i] = i * i
	}

	for i, v := range arr {
		fmt.Println(i, v)
	}

}
