package main

import (
	"errors"
	"fmt"
	"io"
	"io/ioutil"
	"log"
	"os"
	"strings"
)

func main() {
	customError3()
	// customError2()
	//customError()

	//recoverTest()

	//justPanic()
	//logPanic() // will stop the rest and go to panic.go
	//logFatal() // will stop the rest
	//logErr()
	//printErr()

	//errRead()
	//errCreate()
}

/*
// recover makes sense only in defer
func recoverTest2() {
	invokePanic2()

	if r := recover(); r != nil {
		fmt.Println("Recover from Panic 2", r)
	}
	fmt.Println("recover Test exit")
}

func invokePanic2() {
	log.Panic("Ttest")
}
*/

func customError3() {
	x, err := smthg2()
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(x)
	}
}

func smthg2() (string, error) {
	return "TEST", fmt.Errorf("another way to make a custom error")
}

func customError2() {
	x, err := smthg()
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(x)
	}
}

func smthg() (string, error) {
	return "TEST", errors.New("Custom message error")
}

func customError() {
	divR, err := div(6, 3)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(divR)
	}
	divR, err = div(6, 0)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(divR)
	}
}

func div(i int, y int) (float64, error) {
	if y == 0 {
		return 0, custErr1{12}
	} else {
		return float64(i / y), nil
	}
}

type custErr1 struct {
	i int
}

func (ce1 custErr1) Error() string {
	return fmt.Sprint("Error message custom - cannot div by 0", ce1.i)
}

//-------------------------------
func recoverTest() {
	invokePanic()
	fmt.Println("recover Test exit")
}

func invokePanic() {
	//makes sense only in defer
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Recovered in invokePanic", r)
		}
	}()

	fmt.Println("Calling inner")
	invokePanicInner(0)
	fmt.Println("invoke Panic Exit") // this won't be printed out
}

func invokePanicInner(i int) {
	if i > 5 {
		fmt.Println("Panicking")
		log.Panic("HEHEHEHE")
	}
	defer fmt.Println("Defer in invokePanicInner", i)
	invokePanicInner(i + 1)
}

//------------------------
// defer are run but the function breaks where panic is called
func justPanic() {
	defer fmt.Println("justPanic defer") // will be printed
	_, err := os.Open("doesntexist")
	if err != nil {
		panic("err happened")
	}
	fmt.Println("Exit logFatal()")
}

// defer are run but the function breaks where panic is called
func logPanic() {
	defer fmt.Println("logPanic defer") // will be printed
	_, err := os.Open("doesntexist")
	if err != nil {
		log.Panic("err happened", err)
	}
	fmt.Println("Exit logFatal()")
}

// fatal quits - no defer functions are run
func logFatal() {
	defer fmt.Println("logFatal defer") // won't be printed
	_, err := os.Open("doesntexist")
	if err != nil {
		log.Fatal("err happened", err)
	}
	fmt.Println("Exit logFatal()")
}

func logErr() {
	_, err := os.Open("doesntexist")
	if err != nil {
		log.Println("err happened", err)
	}
	fmt.Println("Exit logErr()")
}

func printErr() {
	_, err := os.Open("doesntexist")
	if err != nil {
		fmt.Println("err happened", err)
	}
	fmt.Println("Exit printErr()")
}

//----------------------------
func errRead() {
	f, err := os.Open("names.txt")
	//f, err := os.Open("hahaha.txt")
	if err != nil {
		fmt.Println(err)
		return
	}
	defer f.Close()

	bs, err := ioutil.ReadAll(f)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(string(bs))
	}
}

func errCreate() {
	f, err := os.Create("names.txt")
	//f, err := os.Create("names///s.txt")
	if err != nil {
		fmt.Println(err)
		return
	}
	defer f.Close()

	r := strings.NewReader("wassup")
	io.Copy(f, r)
}
