package helpers

import (
	"math/rand"
	"time"
)

type SomeType struct {
	TypeName string
	TypeAge  int
}

func RandomNumber(n int) int {
	rand.Seed(time.Now().Unix())
	value := rand.Intn(n)
	return value
}
