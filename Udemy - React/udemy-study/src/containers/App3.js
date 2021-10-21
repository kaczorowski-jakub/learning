import React, { Component } from 'react';
import './App.css';
import UserInput from './User/UserInput';
import UserOutput from './User/UserOutput';

class App3 extends Component {
  state = {
    users: [
      {name: "John"},
      {name: "Nataly"},
      {name: "Ana"}
    ]
  }

  changeUserHandler = (event) => {
    this.setState({
      users: [
        {name: event.target.value},
        {name: "Nataly"},
        {name: "Ana"}
      ]
    });
  }

  render() {

    const style = {
        backgroundColor: 'yellow',
        font: 'inherit',
        border: '1px solid blue',
        padding: '8px',
        cursor: 'pointer'
      };

    return (
      <div className="App">
        <UserInput change={this.changeUserHandler} name={this.state.users[0].name} />
        <UserOutput style={style} user={this.state.users[0].name}>Something 1</UserOutput>
        <UserInput />
        <UserOutput user={this.state.users[1].name}>Something 2</UserOutput>
        <UserInput />
        <UserOutput user={this.state.users[2].name}>Something 3</UserOutput>
      </div>
    );
  }
}

export default App3;
