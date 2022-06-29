package render

import (
	"bytes"
	"fmt"
	"log"
	"net/http"
	"path/filepath"
	"text/template"

	"com.os.udemy.goweb.bnb/pkg/config"
	"com.os.udemy.goweb.bnb/pkg/models"
)

var functions = template.FuncMap{}

var appConfig *config.AppConfig

func Init(appCfg *config.AppConfig) {
	appConfig = appCfg
}

//AddDefaultData adds information shared across all of the pages
func AddDefaultData(td *models.TemplateData) *models.TemplateData {

	td.StringMap["app.vendor"] = "offSoft"

	return td
}

func RenderTemplate(w http.ResponseWriter, tmpl string, td *models.TemplateData) {

	var tc map[string]*template.Template
	var err error

	if appConfig.UseCache {
		tc = appConfig.TemplateCache
	} else {
		tc, err = CreateTemplateCache()
		if err != nil {
			log.Panic("Cannot read cache templates")
		}
	}

	t, ok := tc[tmpl]
	if !ok {
		log.Fatal("Cannot Find the given template:" + tmpl)
	}

	td = AddDefaultData(td)
	buf := new(bytes.Buffer)
	_ = t.Execute(buf, td)

	_, err = buf.WriteTo(w)
	if err != nil {
		fmt.Println("Error writing template to a buffer")
	}

	// OLD:
	// parsedTmplt, _ := template.ParseFiles("../../templates/" + tmpl)
	// err := parsedTmplt.Execute(w, nil)
	// if err != nil {
	// 	fmt.Println(err)
	// 	return
	// }
}

// CreateTemplateCache cretes a template cache as a map
func CreateTemplateCache() (map[string]*template.Template, error) {
	myCache := map[string]*template.Template{}

	pages, err := filepath.Glob("../../templates/*.page.html")
	if err != nil {
		return myCache, err
	}

	for _, page := range pages {
		name := filepath.Base(page)
		ts, err := template.New(name).Funcs(functions).ParseFiles(page)
		if err != nil {
			return myCache, err
		}

		matches, err := filepath.Glob("../../templates/*layout.html")
		if err != nil {
			return myCache, err
		}

		if len(matches) > 0 {
			ts, err = ts.ParseGlob("../../templates/*layout.html")
			if err != nil {
				return myCache, err
			}
		}

		myCache[name] = ts
	}

	return myCache, nil
}
