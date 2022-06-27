package handlers

import (
	"errors"
	"fmt"
	"log"
	"net/http"

	"com.os.udemy.goweb.bnb/pkg/config"
	"com.os.udemy.goweb.bnb/pkg/models"
	"com.os.udemy.goweb.bnb/pkg/render"
)

var Repo *Repository

type Repository struct {
	App *config.AppConfig
}

func NewRepo(a *config.AppConfig) *Repository {
	return &Repository{
		App: a,
	}
}

func NewHandlers(r *Repository) {
	Repo = r
}

// HomeNew is home page handler
func (m *Repository) HomeNew(w http.ResponseWriter, r *http.Request) {
	render.RenderTemplate(w, "home.page.html", &models.TemplateData{})
}

// AboutNew is the about page handler
func (m *Repository) AboutNew(w http.ResponseWriter, r *http.Request) {

	// business logic
	stringMap := make(map[string]string)
	stringMap["test"] = "Hello again"
	remoteIP := m.App.Session.GetString(r.Context(), "remote_ip")
	stringMap["remote_ip"] = remoteIP
	render.RenderTemplate(w, "about.page.html", &models.TemplateData{
		StringMap: stringMap,
	})
}

// Home is home page handler
func (m *Repository) Home(w http.ResponseWriter, r *http.Request) {

	remoteIP := r.RemoteAddr
	m.App.Session.Put(r.Context(), "remote_ip", remoteIP)

	fmt.Fprintf(w, "This is my Home page")
}

// About is the about page handler
func (m *Repository) About(w http.ResponseWriter, r *http.Request) {
	sum := addValues(2, 3)
	fmt.Fprintf(w, fmt.Sprintf("About me page and the result is: %d", sum))
}

func (m *Repository) Divide(w http.ResponseWriter, r *http.Request) {
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

func (m *Repository) MyHandler(w http.ResponseWriter, r *http.Request) {
	n, err := fmt.Fprintf(w, "Hello, World")
	if err != nil {
		log.Println(err)
	}
	log.Println(n)
}
