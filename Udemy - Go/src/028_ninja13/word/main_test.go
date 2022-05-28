package word

import (
	"fmt"
	"testing"
)

const txt = "This is a simple test to see how it works"

func TestUseCount(t *testing.T) {
	for k, v := range UseCount(txt) {
		if v != 1 {
			t.Error("Expected:", 1, "got", v, "in word of", k)
		}
	}
}

func TestCount(t *testing.T) {
	if l := Count(txt); l != 10 {
		t.Error("Expected:", 10, "got", l)
	}
}

func ExampleUseCount() {
	fmt.Println(Count(txt))
	// Output:
	// 10
}

func BenchmarkUseCount(b *testing.B) {
	for i := 0; i < b.N; i++ {
		UseCount(txt)
	}
}

func BenchmarkCount(b *testing.B) {
	for i := 0; i < b.N; i++ {
		Count(txt)
	}
}
