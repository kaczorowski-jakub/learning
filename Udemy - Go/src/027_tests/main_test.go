// test file has to be _test.go postfixed
package main

import "testing"

// functions have to be TestXxxx(*testing.T)
func TestMySumOrAnyOtherName(t *testing.T) {

	if x := mySum(2, 3); x != 5 {
		t.Error("Expected", 5, "Got", x)
	}
}

func TestMySumTablet(t *testing.T) {
	type test struct {
		data   []int
		answer int
	}

	tests := []test{
		test{[]int{20, 22}, 42},
		test{[]int{1, 2, 3, 4, 5}, 15},
		test{[]int{-1, 0, -1, 2}, 0},
	}

	for _, v := range tests {
		if x := mySum(v.data...); x != v.answer {
			t.Error("Expected", v.answer, "Got", x)
		}
	}
}

/*
// this one fails
func TestMySumFailing(t *testing.T) {

	if x := mySumFailing(2, 3); x != 5 {
		t.Error("Expected", 5, "Got", x)
	}
}
*/
