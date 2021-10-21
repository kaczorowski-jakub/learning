import React, { Component, Fragment } from 'react';
import classes from './App.css';
import Persons from '../components/Persons/Persons';
import Cockpit from '../components/Cockpit/Cockpit'
import LengthComponent from '../components/LengthComponent/LengthComponent';
import ComponentLifecycle from '../components/Dummy/ComponentLifecycle';
import Arr from '../components/Arr/Arr'
import ArrFragment from '../components/ArrFragment/ArrFragment'
//import WithClass from '../components/hoc/WithClass'
import withClass2 from '../components/hoc/WithClass2'
import AuthContext from '../context/auth-context'

class App extends Component {

  constructor(props) {
    super(props);
    console.log("[App.js] Constructor");
  }

  state = {
    persons: [
      { id: 1, name: "Max", age: 27 },
      { id: 2, name: "Manu", age: 26 },
      { id: 3, name: "Stepg", age: 25 }
    ],
    otherState: "stateOther",
    showPersons: false,
    lengthComponentVal: 0,
    showCockpit: true,
    changeCounter: 0,
    authenticated: false
  }

  static getDerivedStateFromProps(props, state) {
    console.log("[App.js] getDerivedStateFromProps", props);
    return state;
  }

  lifeComponentClick() {
    console.log("ASDAS");
  }

  componentDidMount() {
    console.log("[App.js] componentDidMount");
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("[App.js] shouldComponentUpdate");
    return true;
  }

  componentDidUpdate() {
    console.log("[App.js] componentDidUpdate");
  }

  deletePersonHandler = (index) => {
    //const persons = this.state.persons.slice();
    const persons = [...this.state.persons];
    persons.splice(index, 1);
    this.setState({ persons: persons });
  }

  nameChangedHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex(p => {
      return p.id === id;
    });
    // const person = {...this.state.persons[personIndex]};
    const person = Object.assign({}, this.state.persons[personIndex]);
    person.name = event.target.value;
    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState((prevState, props) => {
      return {
        persons: persons,
        changeCounter: prevState.changeCounter + 1
      }
    });
  }

  changedLength = (event) => {
    this.setState({ lengthComponentVal: event.target.value.length })
  }

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({ showPersons: !doesShow });
  }

  loginHandler = () => {
    this.setState({ authenticated: true });
  }

  render() {

    console.log("[App.js] render");

    let persons = null;
    let componentLifecycle = null;
    let res = () => <div>{this.abc}</div>;
    let length = (
      <div>
        List length: {this.state.persons.length}
      </div>
    );
    if (this.state.showPersons) {
      persons = (
        <Persons
          persons={this.state.persons}
          clicked={this.deletePersonHandler}
          changed={this.nameChangedHandler}
          isAuthenticated={this.state.authenticated} />
      );
      componentLifecycle = <ComponentLifecycle value="12" click={this.lifeComponentClick} />;
    }

    return (
      //<WithClass classes={classes.App}>
      <Fragment>
        <button onClick={() => { this.setState({ showCockpit: false }); }}>Remove Cockpit</button>
        <AuthContext.Provider value={{ authenticated: this.state.authenticated, login: this.loginHandler }}>
          {this.state.showCockpit ?
            <Cockpit
              title={this.props.appTitle}
              personsLength={this.state.persons.length}
              showPers={this.state.showPersons}
              tglPersons={this.togglePersonsHandler} /> : null}
          {persons}
          {componentLifecycle}
          {length}
        </AuthContext.Provider>
        
        {res}
        <input onChange={(event) => this.changedLength(event)} />
        <p>Length: {this.loginHandler}</p>
        <LengthComponent len={this.state.lengthComponentVal} max="10" min="5" />
        <Arr />
        <ArrFragment />
      </Fragment>
      //</WithClass>
    );
    //return React.createElement('div', {className: 'App'}, React.createElement('h1', null, 'Hello world'));
  }
}

export default withClass2(App, classes.App);
