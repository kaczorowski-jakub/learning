package handlers

import (
	"errors"
	"fmt"
	"log"
	"net/http"

	"com.os.udemy.gowebb.basic/pkg/render"
)

// HomeNew is home page handler
func HomeNew(w http.ResponseWriter, r *http.Request) {
	render.RenderTemplate(w, "home.page.html")
}

// AboutNew is the about page handler
func AboutNew(w http.ResponseWriter, r *http.Request) {
	render.RenderTemplate(w, "about.page.html")
}

// Home is home page handler
func Home(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "This is my Home page")
}

// About is the about page handler
func About(w http.ResponseWriter, r *http.Request) {
	sum := addValues(2, 3)
	fmt.Fprintf(w, fmt.Sprintf("About me page and the result is: %d", sum))
}

func Divide(w http.ResponseWriter, r *http.Request) {
	f, err := divideValues(100, 10)
	if err != nil {
		fmt.Fprintln(w, err)
		return
	}
	fmt.Fprintln(w, fmt.Sprintf("100/10 is %f", f))
}

func divideValues(x, y float32) (float32, error) {
	var sum float32
	if y == 0 {
		return sum, errors.New("Can't divide by 0")
	}
	sum = x / y
	return sum, nil
}

func addValues(x, y int) int {
	return x + y
}

func MyHandler(w http.ResponseWriter, r *http.Request) {
	n, err := fmt.Fprintf(w, "Hello, World")
	if err != nil {
		log.Println(err)
	}
	log.Println(n)
}
