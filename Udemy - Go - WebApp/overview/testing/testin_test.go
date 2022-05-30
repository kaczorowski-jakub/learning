package testing

import "testing"

func TestDivide(t *testing.T) {
	_, err := Divide(3.0, 1.0)
	if err != nil {
		t.Error("Got error when we shouldn't have it")
	}
}

func TestBadDivide(t *testing.T) {
	_, err := Divide(3.0, 0)
	if err == nil {
		t.Error("Didn't have an error when we should have")
	}
}

var tests = []struct {
	name     string
	divident float32
	divisor  float32
	expected float32
	isErr    bool
}{
	{"valid-data", 100.0, 10.0, 10.0, false},
	{"invalid-data", 100.0, 0, 0.0, true},
}

func TestDivision(t *testing.T) {
	for _, tt := range tests {
		got, err := Divide(tt.divident, tt.divisor)
		if tt.isErr {
			if err == nil {
				t.Error("expected an error but did not get one")
			}
		} else {
			if err != nil {
				t.Error("did not expect an error but got one", err.Error())
			}
		}

		if got != tt.expected {
			t.Errorf("expected %f but got %f", tt.expected, got)
		}
	}
}
