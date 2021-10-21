import React from 'react';
import './Person.css'
import Radium from 'radium';
const person = (props) => {
    //return <p>I'm a person and I am {Math.floor(Math.random() * 30)} yesrs old!</p>
    const style = {
        '@media (min-width: 500px)': {
            width: '450px'
        }
    }
    return (
        <div className="Person" style={style}>
            <p onClick={props.click}>I'm {props.name} and I am {props.age} yesrs old!</p>
            <p>{props.children}</p>
            <input type="text" onChange={props.changed} value={props.name} />
        </div>
    );
};

export default Radium(person);