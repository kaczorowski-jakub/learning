package main

import "fmt"

func main() {
	mapIntro()
	//multiDimSlice()
	//makeChecking()
	//deleteFromSlice()
	//appendToSlice()
	//slicingASlice()
	//sliceCompositeLiteral()
	//simpleArray()
}

func mapIntro() {
	m := map[string]int{
		"James":           32,
		"Miss Moneypenny": 27, // trailing comma!!! why?!!
	}
	fmt.Println(m)
	fmt.Println(m["James"])
	fmt.Println(m["NonExisting"])

	v, ok := m["NonExisting"]
	fmt.Println(v, ok)
	if v, ok := m["Barnabas"]; ok {
		fmt.Println(v)
	} else {
		fmt.Println("It doesnt exist")
	}

}

func multiDimSlice() {
	jb := []string{"James", "Bond", "One", "Two"}
	fmt.Println(jb)
	mp := []string{"Miss", "Moneypenny", "Ten", "Eleven"}
	fmt.Println(mp)

	xp := [][]string{jb, mp}
	fmt.Println(xp)

	// do all the dimensions have to be equal?
	mn := [][]string{jb, {"Only", "Two"}}
	fmt.Println(mn)
}

func makeChecking() {
	x := make([]int, 20)
	fmt.Println(x, len(x), cap(x))
	x = append(x, 1)
	fmt.Println(x, len(x), cap(x))
	x = append(x, 2)
	fmt.Println(x, len(x), cap(x))

	y := make([]int, 20, 22)
	fmt.Println(y, len(y), cap(y))

	y[10] = 10
	y[19] = 19
	//y[20]=20 // index out of range error
	y = append(y, 20)
	fmt.Println(y, len(y), cap(y))
	y = append(y, 21)
	fmt.Println(y, len(y), cap(y))
	y = append(y, 22)
	fmt.Println(y, len(y), cap(y))
}

func deleteFromSlice() {
	x := []int{4, 5, 7, 8, 42, 105, 208}
	fmt.Println(x)
	x = append(x[:2], x[4:]...)
	fmt.Println(x)
}

func appendToSlice() {
	x := []int{4, 5, 7, 8, 42}
	fmt.Println(x)
	x = append(x, 101, 607)
	fmt.Println(x)

	y := []int{}
	fmt.Println(y)
	y = append(x, 111, 222, 333)
	fmt.Println(y)

	z := []int{}
	fmt.Println(z)
	z = append(x, y...)
	fmt.Println(z)
}

func slicingASlice() {
	x := []int{4, 5, 7, 8, 42}
	fmt.Println(x)
	fmt.Println(x[1])
	fmt.Println(x[0:2])
	fmt.Println(x[2:])
	fmt.Println(x[:4])
}

func sliceCompositeLiteral() {
	// slices allow to group together values of the same type
	x := []int{4, 5, 7, 8, 42}
	fmt.Println("Slice length: ", len(x))
	fmt.Println("Slice values: ", x)

	for i, v := range x {
		fmt.Println("At index of ", i, " there is value ", v)
	}
}

func simpleArray() {
	var x [5]int
	fmt.Println(x)
	x[3] = 42
	fmt.Println(x)
	fmt.Println(len(x))
}
