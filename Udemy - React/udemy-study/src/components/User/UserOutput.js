import React from 'react';

const userOutput = (props) => {
    return (
    <div>
        <p style={props.style}>{props.children}</p>
        <p style={props.style}>{props.user}</p>
    </div>
    );
}

export default userOutput;