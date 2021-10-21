import React, {useContext} from 'react';
import AuthContext from '../../context/auth-context'

const lengthComponent = (props) => {
    
    let val = "TEST";
    const auth = useContext(AuthContext);
    console.log(auth.authenticated);
    if (props.len > props.max) {
        val = "Text too long";
    } else if (props.len < props.min) {
        val = "Text too short";
    }

    return (
    <p>{val} (User is {auth.authenticated ? '' : 'not'} authenticated)</p>
    );
};

export default lengthComponent;