package main

import (
	"fmt"
	"time"

	"com.os.golang.testing/inner"
)

/**
Useful go commands
gofmt
	formats the current directory go files
        gofmt  ./...
go vet
	checks suspicious constructs
        go vet ./...
golint
	poor code styling
        golint ./...
godoc
	creates a web documentation

./... as a parameter makes the command to be applicable
      for all the go file in the current and any inner directory
*/

func main() {

	passingStructsAndArrays()

	timeTesting()

	functionInStruct()
	passingFunctions()

	testingMap()

	assertionAndConversion()

	createAndAssignOperator()

	packageTest()

	pointerNonPointerReceiver()

	newTest()
	makeTest()

	deferedNamedParamRealLife()
	deferedNamedParam()
	deferMustBeReached(1)
	deferOrder()
	deferTestInline()

	namedParams()
}

type t1 struct {
	v      string
	i      int
	b      bool
	emails []t2
	vvv    t3
}

type t2 struct {
	email string
}

type t3 struct {
	val int
}

func passingStructsAndArrays() {
	fmt.Println("===\npassingStructsAndArrays")
	x1 := t1{"1", 1, false, []t2{{"a@b"}}, t3{100}}
	//	x2 := t1{"1", 1, false, []t2{t2{"a@b"}}}
	//fmt.Println(x1 == x2)
	change(x1)
	fmt.Println(x1)
}

func change(t t1) {
	t.emails[0].email = "changed@com.pl"
	t.v = "changed"
	t.vvv.val = 777
}

//-------------------------
func timeTesting() {
	fmt.Println("===\ntimeTesting")
	var tm time.Time = time.Now().UTC()
	fmt.Println(tm.Format(time.RFC822))
	fmt.Println(tm.Format("2006-02-01"))
	fmt.Println(tm.Format("2006-01-02"))
}

//------------------------
type funStruct struct {
	s         string
	i         int
	sayMyName func() string
}

func functionInStruct() {
	fmt.Println("===\nfunctionInStruct")
	fs := funStruct{
		s: "Allan",
		i: 123,
		sayMyName: func() string {
			return "Allan"
		},
	}

	fmt.Println(fs.sayMyName())
}

func passingFunctions() {
	fmt.Println("===\npassingFunctions")
	f := func(a int, s string) (string, float32) {
		return s + " - modified", float32(a + 1000)
	}
	passingFunctionsT1(f)
}

func passingFunctionsT1(f1 func(int, string) (string, float32)) {

	s, f := f1(1, "A")
	fmt.Println(s, f)
}

//----------------------
type key struct {
	name string
	age  int
	ki   keyInner
}

type keyInner struct {
	date time.Time
}

func testingMap() {
	fmt.Println("===\ntesting map")
	m := map[key]string{}
	tm := time.Now()
	m[key{"1", 2, keyInner{}}] = "asa"
	m[key{"2", 3, keyInner{tm}}] = "kielbasa"
	fmt.Println(m)
	fmt.Println(m[key{"1", 2, keyInner{}}])
	fmt.Println(m[key{"1", 4, keyInner{}}])
	fmt.Println(m[key{"2", 3, keyInner{}}])
	fmt.Println(m[key{"2", 3, keyInner{tm}}])
}

//-----------------------------
type dog int

type myStruct struct {
	fname string
}

func (ms myStruct) Error() string {
	return fmt.Sprint("Somehting", ms.fname)
}

func assertionAndConversion() {
	fmt.Println("===\nassertionAndConversion test")

	// conversion
	var d dog
	d = 12
	fmt.Printf("%T\n", d)
	i := int(d)
	fmt.Printf("%T\n", i)

	// assertion
	var err error
	err = myStruct{"Testing"}
	fmt.Printf("%T\n", err)
	//err.fname	//err.fname undefined (type error has no field or method fname)
	fmt.Println(err)
	fmt.Println(err.(myStruct).fname)

}

//----------------------
func createAndAssignOperator() {
	fmt.Println("===\ncreateAndAssignOperator test")
	a, _ := test()
	//a, _ := test()	//no new variables on left side of :=
	//a := 12 //no new variables on left side of :=
	a, b := test()

	fmt.Println(a, b)
}

func test() (int, bool) {
	return 1, false
}

//---------------------------
func packageTest() {
	fmt.Println("===\nPackage test")
	Visible()
	visibleEvenIfNotInUppercase()
	inner.VisibleObj{}.VisibleFunc()

}

//----------------------------
func pointerNonPointerReceiver() {
	fmt.Println("===\nPointer and non-pointer receiver")
	s := smthg{"start"}
	s.chng1()
	fmt.Println(s)
	s.chng2()
	fmt.Println(s)
}

type smthg struct {
	val string
}

func (s smthg) chng1() {
	s.val += " chng1"
}

func (s *smthg) chng2() {
	s.val += " chng2"
}

//------------------------------------
func newTest() {
	fmt.Println("===\nNew Test")
	key := new(mapKey)
	val := new(mapValue)
	key.no = 100
	key.desc = "ABC"
	val.fname = "Jan"
	val.lname = "Kowalski"
	val.age = 98
	fmt.Println(key, val)

	key2 := &mapKey{50, "xyz"}
	fmt.Println(key2)
	key2.desc = "something new"
	fmt.Println(key2)
	fmt.Printf("%T", key2)

	key3 := mapKey{0, "classic"}
	fmt.Println(key3)
	fmt.Printf("%T\n", key3)

	c := customer{}.New("admin", "admin@wp.pl")
	fmt.Println(c)
}

func makeTest() {
	fmt.Println("===\nMake Test")
	a := make(map[mapKey]mapValue)
	a[mapKey{1, "Fast"}] = mapValue{"Alina", "Banach", 54}
	fmt.Println(a)
}

type mapKey struct {
	no   int
	desc string
}

type mapValue struct {
	fname string
	lname string
	age   int
}

type customer struct {
	uid   string
	email string
}

func (c customer) New(uid string, email string) customer {
	return customer{uid, email}
}

//--------------------------------------
func deferedNamedParamRealLife() {
	fmt.Println("===\ndeferedNamedParamRealLife")
	deferedNamedParamRealLifeInner()
	deferedNamedParamRealLifeInnerNil()
}

func deferedNamedParamRealLifeInner() (i int, s string) {
	defer func() {
		fmt.Println("i is ", i)
		fmt.Println("s is ", s)
	}()

	i = 100
	s = "a houndred"

	ii := 200
	ss := "two houndred"
	return ii, ss
}

func deferedNamedParamRealLifeInnerNil() (ds error) {
	defer func() {
		fmt.Println("After deferedNamedParamRealLifeInnerNil", ds)
	}()

	ds = deferStruct{
		s: "ABCD",
		i: 123,
	}
	fmt.Println("Before deferedNamedParamRealLifeInnerNil", ds)
	return nil
}

type deferStruct struct {
	s string
	i int
}

func (ds deferStruct) Error() string {
	return fmt.Sprintf("%v, %v", ds.s, ds.i)
}

func deferTestInline() {
	fmt.Println("===\nDefer Test Inline")
	a := 101

	defer fmt.Println("Inline:", a) // a is being evaluated at compile time
	defer func() {
		fmt.Println("Inner func:", a) // here it is not because it's a anonymous function
	}()

	a++
	fmt.Println("On exit:", a)

}

func deferOrder() {
	fmt.Println("===\nDefer Order")
	fmt.Println("start")
	for i := 1; i <= 5; i++ {
		defer fmt.Println(i)
	}
	fmt.Println("end")
}

func deferMustBeReached(a int) {
	fmt.Println("===\nDefer Must Be Reached")
	defer fmt.Println("Defer A")
	if a > 0 {
		return
	}

	defer fmt.Println("Defer B")              // if a> 0 this will not be reached -> won't be printed
	fmt.Println("Exit of deferMustBeReached") // if a>0 this won't be printed neither
}

func deferedNamedParam() {
	fmt.Println("===\nDefer Named Param")
	fmt.Println(deferedNamedParamIn())
}

func deferedNamedParamIn() (a int) {
	defer func() {
		a = 100 // this will be returned
	}()

	return 5
}

//--------------------------
func namedParams() {
	fmt.Println("===\nNamed Return Parameters")
	fmt.Println(ret1(1, "Ala "))
	fmt.Println(ret2(12, "Ala2 "))
}

func ret1(i int, s string) (a string, b int) {
	a = s + "add"
	b = i + 100

	return a, b
}

func ret2(i int, s string) (a string, b int) {
	a = s + "add"
	b = i + 100

	return
}
