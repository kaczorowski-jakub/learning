package dog

import (
	"fmt"
	"testing"
)

func TestYears(t *testing.T) {
	if s := Years(6); s != (42) {
		t.Error("Expected:", 42, "got", s)
	}
}

func ExampleYears() {
	fmt.Println(Years(6))
	// Output:
	// 42
}

func BenchmarkYears(b *testing.B) {
	for i := 0; i < b.N; i++ {
		Years(i)
	}
}
