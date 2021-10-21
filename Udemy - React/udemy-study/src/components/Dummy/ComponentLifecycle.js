import React, { Component } from 'react';
import AuthContext from '../../context/auth-context'

class ComponentLifecycle extends Component {

    static contextType = AuthContext;

    static getDerivedStateFromProps(props, state) {
        console.log("[ComponentLifecycle.js] getDerivedStateFromProps");
        return state;
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("[ComponentLifecycle.js] shouldComponentUpdate");
        return (nextProps.persons !== this.props.persons);
    }

    getSnapshotBeforeUpdate(prevProps, prevState, snapshot) {
        console.log("[ComponentLifecycle.js] getSnapshotBeforeUpdate");
        return { message: 'snapshot' };
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log("[ComponentLifecycle.js] componentDidUpdate");
        console.log(snapshot);
    }

    render() {
        console.log("[ComponentLifecycle.js] rendering...");
    return <p onClick={this.props.click} onChange={this.props.change}>{this.props.value} - {this.context.authenticated ? 'true' : 'false'}</p>;
    }

    componentWillUnmount() {
        console.log("[ComponentLifecycle.js] componentWillUnmount");
    }

}

export default ComponentLifecycle;