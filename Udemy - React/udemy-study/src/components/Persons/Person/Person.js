import React, { useEffect } from 'react';
import classes from './Person.css';
import AuthContext from '../../../context/auth-context';

const person = (props) => {
    const rnd = Math.random();

    if (rnd > 1.0) {
        throw new Error('wrong');
    }

    console.log('[Person.js] rendering');

    useEffect(() => {
        //this.inElem.focus();
    });

    return (
        <div className={classes.Person}>
            <AuthContext.Consumer>
                {(context) => context.authenticated ? <p>Authenticated</p> : <p>Please log in</p>}
            </AuthContext.Consumer>
            <p onClick={props.click}>I'm {props.name} and I am {props.age} yesrs old!</p>
            <p>{props.children}</p>
            <input key="i3" type="text" onChange={props.changed} value={props.name} ref={(inElem) => { this.inElem = inElem }} />
        </div>
    );
};

export default person;