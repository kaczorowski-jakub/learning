import React, { useState } from 'react';
import './App.css';
import Person from './Person/Person';

const app2 = props => {

  const [personsState, setPersonsState] = useState({
    persons: [
      { name: "Max", age: 27},
      { name: "Manu", age: 26},
      { name: "Stepg", age: 25}
    ]
  });

  const [otherState, setOtherState] = useState('stateOther');

  console.log(personsState, otherState);

  const switchNameHandler = () => {
    setPersonsState({
        persons: [
          { name: "Maximilian", age: 27},
          { name: "Manu", age: 26},
          { name: "Stepg", age: 19}
        ]
      } );
  }

    return (
      <div className="App">
        <h1>Hello World</h1>
        <p>something</p>
        <button onClick={switchNameHandler} >Switch</button>
        <Person name={personsState.persons[0].name} age={personsState.persons[0].age} />
        <Person name={personsState.persons[1].name} age={personsState.persons[1].age}>My hobbies: React</Person> 
        <Person name={personsState.persons[2].name} age={personsState.persons[2].age} />
      </div>
    );
}

export default app2;

