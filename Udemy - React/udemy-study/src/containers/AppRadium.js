import React, { Component } from 'react';
import './App.css';
import Radium, {StyleRoot} from 'radium';
import Person from './Person/Person';
import LengthComponent from '../components/LengthComponent/LengthComponent';

class App extends Component {
  state = {
    persons: [
      { id: 1, name: "Max", age: 27},
      { id: 2, name: "Manu", age: 26},
      { id: 3, name: "Stepg", age: 25}
    ],
    otherState: "stateOther",
    showPersons: false,
    lengthComponentVal: 0
  }

  deletePersonHandler = (index) => {
    //const persons = this.state.persons.slice();
    const persons = [...this.state.persons];
    persons.splice(index, 1);
    this.setState({persons: persons});
  }

  nameChangedHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex( p => p.id === id);
    // const person = {...this.state.persons[personIndex]};
    const person = Object.assign({}, this.state.persons[personIndex]);
    person.name = event.target.value;
    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({
      persons: persons
    } );
  }

changedLength = (event) => {
  this.setState({lengthComponentVal: event.target.value.length})
}

togglePersonsHandler = () => {
  const doesShow = this.state.showPersons;
  this.setState({showPersons: !doesShow});
}

  render() {
    const style = {
      backgroundColor: 'green',
      color: 'white',
      font: 'inherit',
      border: '1px solid blue',
      padding: '8px',
      cursor: 'pointer',
      ':hover': {
        backgroundColor: 'lightgreen',
        color: 'black'
      }
    };

    let persons = null;
    let res = () => <div>{this.abc}</div>;
    let length = (
      <div>
        List length: {this.state.persons.length}
      </div>
    );
    if (this.state.showPersons) {
      style.backgroundColor = 'red';
      style[":hover"] = {
        backgroundColor: 'salmon',
        color: 'black'
      }
      persons = (
        <div>
          {this.state.persons.map((person, index) => {
            return <Person 
            click={() => this.deletePersonHandler(index)}
            name={person.name} 
            age={person.age} 
            key={person.id}
            changed={(event) => this.nameChangedHandler(event, person.id)}/>
          })}
        </div>
      );
    }

    let classes = [];
    if (this.state.persons.length <= 2) {
      classes.push('red');
    }
    if (this.state.persons.length <= 1) {
      classes.push('bold');
    }

    return (
      <StyleRoot>
      <div className="App">
        <h1>Hello World</h1>
        <p className={classes.join(' ')}>something</p>
        <button style={style} onClick={this.togglePersonsHandler} >Switch</button>
        {persons}
        {length}
        {res}
        <input onChange={(event) => this.changedLength(event)} />
        <p>Length: {this.state.lengthComponentVal}</p>
        <LengthComponent len={this.state.lengthComponentVal} max="10" min="5"/>
      </div>
      </StyleRoot>
    );
    //return React.createElement('div', {className: 'App'}, React.createElement('h1', null, 'Hello world'));
  }
}

export default Radium(App);
