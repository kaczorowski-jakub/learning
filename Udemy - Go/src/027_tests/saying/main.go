package saying

import "fmt"

func Greet(s string) string {
	return fmt.Sprintf("Hello from %v", s)
}
