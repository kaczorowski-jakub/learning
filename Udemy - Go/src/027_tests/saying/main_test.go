package saying

import (
	"fmt"
	"testing"
)

// go test .
// 		to run all the test from a given directory
// go test com.os.udemy.golang.testing/saying
//		to run all tests in a given test file
// go test -run ^TestGreet$ com.os.udemy.golang.testing/saying
//		to run a single tesr
func TestGreet(t *testing.T) {
	if s := Greet("heaven"); s != "Hello from heaven" {
		t.Error("Expected:", "Hello from heaven", "got", s)
	}
}

// godoc -http=:8080 to and go to the browser localhost:8080 to see the doc
func ExampleGreet() {
	fmt.Println(Greet("heaven"))
	// Output:
	// Hello from heaven
}

// go test -bench .
//		to run all tests with benchmarking
// go test -bench Greet
//		to run just one test with benchmarking
func BenchmarkGreet(b *testing.B) {
	for i := 0; i < b.N; i++ {
		Greet("heaven")
	}
}
