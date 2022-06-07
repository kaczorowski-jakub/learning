package main

import (
	"log"
	"net/http"

	"com.os.udemy.gowebb.basic/pkg/config"
	"com.os.udemy.gowebb.basic/pkg/handlers"
	"com.os.udemy.gowebb.basic/pkg/render"
)

const port = ":8080"

// from terminal go run *.go
func main() {

	var appCfg config.AppConfig

	tc, err := render.CreateTemplateCache()
	if err != nil {
		log.Fatalln("Cannot create template cache")
	}
	appCfg.TemplateCache = tc
	appCfg.UseCache = true

	render.Init(&appCfg)

	repo := handlers.NewRepo(&appCfg)
	handlers.NewHandlers(repo)

	http.HandleFunc("/", handlers.Repo.MyHandler)
	http.HandleFunc("/home", handlers.Repo.Home)
	http.HandleFunc("/about", handlers.Repo.About)
	http.HandleFunc("/aboutNew", handlers.Repo.AboutNew)
	http.HandleFunc("/homeNew", handlers.Repo.HomeNew)
	http.HandleFunc("/divide", handlers.Repo.Divide)
	http.ListenAndServe(port, nil)
}
