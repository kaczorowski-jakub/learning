import React, { useEffect, useRef } from 'react';
import classes from './Cockpit.css';
import AuthContext from '../../context/auth-context';

const cockpit = (props) => {

    const btnRef = useRef(null);

    useEffect(() => {
        console.log('[Cockpit.js] useEffect');
        // const timer = setTimeout(() => {
        //     alert('test');
        // }, 1000);
        btnRef.current.click();
        return () => {
            //clearTimeout(timer);
            console.log('[Cockpit.js] cleanup work in useEffect')
        };
        //}, [props.persons]);
    }, []);

    useEffect(() => {
        console.log('[Cockpit.js] useEffect 2');
        return () => {
            console.log('[Cockpit.js] cleanup work in useEffect 2')
        };
    });

    let btnClass = '';

    let assignedClasses = [];
    if (props.personsLength <= 2) {
        assignedClasses.push(classes.red);
    }
    if (props.personsLength <= 1) {
        assignedClasses.push(classes.bold);
    }

    if (props.showPers) {
        btnClass = classes.Red;
    }

    return (
        <div className={classes.Cockpit}>
            <h1>{props.title}</h1>
            <p className={assignedClasses.join(' ')}>something</p>
            <button ref={btnRef} className={btnClass} onClick={props.tglPersons} >Switch</button>
            <AuthContext.Consumer>
                {(context) => <button onClick={context.login}>Log in</button>}
            </AuthContext.Consumer>
        </div>
    );

}

export default React.memo(cockpit);