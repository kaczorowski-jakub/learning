package main

import (
	"net/http"

	"com.os.udemy.goweb.bnb/pkg/config"
	"com.os.udemy.goweb.bnb/pkg/handlers"
	"github.com/go-chi/chi"
)

func routes(app *config.AppConfig) http.Handler {

	// pat way
	/*mux := pat.New()

	mux.Get("/", http.HandlerFunc(handlers.Repo.MyHandler))
	mux.Get("/home", http.HandlerFunc(handlers.Repo.Home))
	mux.Get("/about", http.HandlerFunc(handlers.Repo.About))
	mux.Get("/aboutNew", http.HandlerFunc(handlers.Repo.AboutNew))
	mux.Get("/homeNew", http.HandlerFunc(handlers.Repo.HomeNew))
	mux.Get("/divide", http.HandlerFunc(handlers.Repo.Divide))
	*/

	mux := chi.NewRouter()

	//mux.Use(middleware.Recoverer)
	//mux.Use(middleware.Logger)
	//mux.Use(WriteToConsole)
	mux.Use(NoSurf)
	mux.Use(SessionLoad)

	mux.Get("/", handlers.Repo.MyHandler)
	mux.Get("/home", handlers.Repo.Home)
	mux.Get("/about", handlers.Repo.About)
	mux.Get("/aboutNew", handlers.Repo.AboutNew)
	mux.Get("/homeNew", handlers.Repo.HomeNew)
	mux.Get("/divide", handlers.Repo.Divide)
	return mux
}
