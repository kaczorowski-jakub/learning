package main

import (
	"net/http"

	"com.os.udemy.gowebb.basic/pkg/config"
	"com.os.udemy.gowebb.basic/pkg/handlers"
	"github.com/bmizerany/pat"
)

func routes(app *config.AppConfig) http.Handler {
	mux := pat.New()

	mux.Get("/", http.HandlerFunc(handlers.Repo.MyHandler))
	mux.Get("/home", http.HandlerFunc(handlers.Repo.Home))
	mux.Get("/about", http.HandlerFunc(handlers.Repo.About))
	mux.Get("/aboutNew", http.HandlerFunc(handlers.Repo.AboutNew))
	mux.Get("/homeNew", http.HandlerFunc(handlers.Repo.HomeNew))
	mux.Get("/divide", http.HandlerFunc(handlers.Repo.Divide))
	return mux
}
