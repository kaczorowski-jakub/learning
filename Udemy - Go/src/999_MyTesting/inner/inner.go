package inner

import "fmt"

type notVisibleObj struct {
	s string
}

type VisibleObj struct {
	s string
	i int
}

func (v VisibleObj) VisibleFunc() {
	fmt.Println("Visible inner ")
}

func (v VisibleObj) notVisibleFunc() {
	fmt.Println("not visible inner")
}
