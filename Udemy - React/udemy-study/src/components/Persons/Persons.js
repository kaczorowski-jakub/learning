import React from 'react';
import ErrorBoundary from '../ErrorBoundary/ErrorBoundary';
import Person from './Person/Person';
import PropTypes from 'prop-types';

const persons = (props) => props.persons.map((person, index) => {

    console.log('[Persons.js] rendering...');

    return <ErrorBoundary key={person.id}>
        <Person
            click={() => props.clicked(index)}
            name={person.name}
            age={person.age}
            key={person.id}
            changed={(event) => props.changed(event, person.id)}
            isAuth={props.isAuthenticated} />
    </ErrorBoundary>
});

Person.propTypes = {
    click: PropTypes.func,
    name: PropTypes.string,
    age: PropTypes.number,
    changed: PropTypes.func
};

export default persons;