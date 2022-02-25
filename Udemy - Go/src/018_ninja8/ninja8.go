package main

import (
	"encoding/json"
	"fmt"
	"os"
	"sort"
)

func main() {
	fmt.Println("Ninja -7")

	fmt.Println("Exercise #1")
	exercise1()
	fmt.Println("----------")

	fmt.Println("Exercise #2")
	exercise2()
	fmt.Println("----------")

	fmt.Println("Exercise #3")
	exercise3()
	fmt.Println("----------")

	fmt.Println("Exercise #4")
	exercise4()
	fmt.Println("----------")
}

type ByTries []user

func (a ByTries) Len() int           { return len(a) }
func (a ByTries) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a ByTries) Less(i, j int) bool { return a[i].Tries > a[j].Tries }

func exercise4() {
	users := []user{
		{
			Id:    "id1",
			Pwd:   "abc",
			Email: "a@b.pl",
			Tries: 0,
		},
		{
			Id:    "id2",
			Pwd:   "efg",
			Email: "c@e.pl",
			Tries: 2,
		},
	}

	sort.Slice(users, func(i, j int) bool {
		return users[i].Id > users[j].Id
	})
	fmt.Println(users)

	sort.Slice(users, func(i, j int) bool {
		return users[i].Email < users[j].Email
	})
	fmt.Println(users)

	sort.Sort(ByTries(users))
	fmt.Println(users)
}

//---------------------------
func exercise3() {
	users := []user{
		{
			Id:    "id1",
			Pwd:   "abc",
			Email: "a@b.pl",
			Tries: 0,
		},
		{
			Id:    "id2",
			Pwd:   "efg",
			Email: "c@e.pl",
			Tries: 2,
		},
	}

	err := json.NewEncoder(os.Stdout).Encode(users)
	if err != nil {
		fmt.Println(err)
	}
}

//-----------------------------
type AutoGenerated []struct {
	ID    string `json:"Id"`
	Email string `json:"Email"`
	Tries int    `json:"Tries"`
}

func exercise2() {
	users := []user{
		{
			Id:    "id1",
			Pwd:   "abc",
			Email: "a@b.pl",
			Tries: 0,
		},
		{
			Id:    "id2",
			Pwd:   "efg",
			Email: "c@e.pl",
			Tries: 2,
		},
	}
	bc := marshal(users)
	//var ag AutoGenerated
	var u []user
	err := json.Unmarshal(bc, &u)
	if err != nil {
		fmt.Println(err)
	}
	for i, user := range u {
		fmt.Println("User of index:", i)
		fmt.Println("Id:", user.Id)
		fmt.Println("Email:", user.Email)
		fmt.Println("Tries:", user.Tries)
	}

}

//-----------------------------
type user struct {
	Id    string
	Pwd   string `json:"-"`
	Email string
	Tries int
}

func exercise1() {
	users := []user{
		{
			Id:    "id1",
			Pwd:   "abc",
			Email: "a@b.pl",
			Tries: 0,
		},
		{
			Id:    "id2",
			Pwd:   "efg",
			Email: "c@e.pl",
			Tries: 2,
		},
	}
	fmt.Println(users)

	bc := marshal(users)
	fmt.Println(string(bc))
}

func marshal(users []user) []byte {
	bc, err := json.Marshal(users)
	if err != nil {
		fmt.Println(err)
	}
	return bc
}
