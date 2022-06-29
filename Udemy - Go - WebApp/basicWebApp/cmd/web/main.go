package main

import (
	"log"
	"net/http"
	"time"

	"com.os.udemy.gowebb.basic/pkg/config"
	"com.os.udemy.gowebb.basic/pkg/handlers"
	"com.os.udemy.gowebb.basic/pkg/render"
	"github.com/alexedwards/scs/v2"
)

const port = ":8080"

var appCfg config.AppConfig
var session *scs.SessionManager

// from terminal go run *.go
func main() {

	appCfg.InProduction = false

	session = scs.New()
	session.Lifetime = 24 * time.Hour
	session.Cookie.Persist = true
	session.Cookie.SameSite = http.SameSiteLaxMode
	session.Cookie.Secure = appCfg.InProduction
	appCfg.Session = session

	tc, err := render.CreateTemplateCache()
	if err != nil {
		log.Fatalln("Cannot create template cache")
	}
	appCfg.TemplateCache = tc
	appCfg.UseCache = true

	render.Init(&appCfg)

	repo := handlers.NewRepo(&appCfg)
	handlers.NewHandlers(repo)

	// http.HandleFunc("/", handlers.Repo.MyHandler)
	// http.HandleFunc("/home", handlers.Repo.Home)
	// http.HandleFunc("/about", handlers.Repo.About)
	// http.HandleFunc("/aboutNew", handlers.Repo.AboutNew)
	// http.HandleFunc("/homeNew", handlers.Repo.HomeNew)
	// http.HandleFunc("/divide", handlers.Repo.Divide)
	//http.ListenAndServe(port, nil)

	srv := &http.Server{
		Addr:    port,
		Handler: routes(&appCfg),
	}

	err = srv.ListenAndServe()
}
