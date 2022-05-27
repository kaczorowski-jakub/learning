package mystr

import (
	"fmt"
	"strings"
	"testing"
)

const a = `In the event of a discrepancy between the Dutch text of these General Terms and Conditions or other conditions which are referred to herein and any translation thereof, or in the event that the Dutch text or any translation thereof can be interpreted in different ways, the Dutch text and/or the explanation given to the Dutch text will have precedence. The determination by any court of competent
jurisdiction that one or more of the sections or provisions of these General Conditions of Sale are unenforceable shall not invalidate the General Conditions of Sale, and the decision of such court shall be given effect so as to limit to the extent possible the sections or provisions which are deemed unenforceable.`

// BET stands for (B)enchmarking, (E)xampling, (T)esting

func TestCat(t *testing.T) {
	if s := Cat(strings.Split(a, " ")); s != (a + " ") {
		t.Error("Expected:", a, "got", s)
	}
}

func TestJoin(t *testing.T) {
	if s := Join(strings.Split(a, " ")); s != a {
		t.Error("Expected:", a, "got", s)
	}
}

func ExampleJoin() {
	fmt.Println(Join(strings.Split("Ala ma kota", " ")))
	// Output:
	// Ala ma kota
}

func ExampleCat() {
	fmt.Println(Cat(strings.Split("Ala ma kota", " ")))
	// Output:
	// Ala ma kota
}

func BenchmarkCat(b *testing.B) {
	for i := 0; i < b.N; i++ {
		Cat(strings.Split(a, " "))
	}
}

func BenchmarkJoin(b *testing.B) {
	for i := 0; i < b.N; i++ {
		Join(strings.Split(a, " "))
	}
}
