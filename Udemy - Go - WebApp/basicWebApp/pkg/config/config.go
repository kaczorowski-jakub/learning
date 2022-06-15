package config

import (
	"log"
	"text/template"
)

// AppConfig hold the app config
type AppConfig struct {
	UseCache      bool
	TemplateCache map[string]*template.Template
	InfoLog       *log.Logger
}
