package main

import (
	"net/http"

	"com.os.udemy.gowebb.basic/pkg/handlers"
)

const port = ":8080"

// from terminal go run *.go
func main() {
	http.HandleFunc("/", handlers.MyHandler)
	http.HandleFunc("/home", handlers.Home)
	http.HandleFunc("/about", handlers.About)
	http.HandleFunc("/aboutNew", handlers.AboutNew)
	http.HandleFunc("/homeNew", handlers.HomeNew)
	http.HandleFunc("/divide", handlers.Divide)
	http.ListenAndServe(port, nil)
}
