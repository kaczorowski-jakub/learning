//package myPackOuter // this is wrong because in the same leve of path we can have the same packages only
package main

import "fmt"

func visibleEvenIfNotInUppercase() {
	fmt.Println("Visible because in the same package")
}

func Visible() {
	fmt.Println("Visible in Outer")
}
