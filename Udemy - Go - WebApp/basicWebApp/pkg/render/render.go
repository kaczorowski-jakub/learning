package render

import (
	"fmt"
	"net/http"
	"text/template"
)

func RenderTemplate(w http.ResponseWriter, tmpl string) {
	parsedTmplt, _ := template.ParseFiles("../../templates/" + tmpl)
	err := parsedTmplt.Execute(w, nil)
	if err != nil {
		fmt.Println(err)
		return
	}
}
