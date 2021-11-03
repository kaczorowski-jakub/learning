import axios from 'axios';
import react from 'react';
import { Link } from 'react-router-dom';
import { toast } from 'react-toastify';

class CollectClinicals extends react.Component {

    state = {
        firstName: "",
        lastName: "",
        age: ""
    };

    componentDidMount() {
        axios.get('http://localhost:8080/clinicalservices/patients/' + this.props.match.params.patientId)
        .then(res=> {
            this.setState(res.data);
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = {
            patientId: this.props.match.params.patientId,
            componentName: this.componentName,
            componentValue: this.componentValue
        }
        console.log(data);
        axios.post('http://localhost:8080/clinicalservices/clinicaldata/', data)
        .then(ret => {
            toast("Patient Data Saved Successfully!", {autoClose: 3000, position: toast.POSITION.BOTTOM_CENTER});
        });
    }

    render() {
        return(
            <div>
                <h2>Patient Details:</h2>
                First Name: {this.state.firstName}<br />
                Last Name: {this.state.lastName}<br />
                Age: {this.state.age}
                <h2>Patient Clinical Data</h2>
                <form>
                    Clinical Entry Type <select onChange={(event) => {this.componentName=event.target.value}}>
                        <option>Select One</option>
                        <option value="bp">Blood Pressure(Sys/Dys)</option>
                        <option value="hw">Height/Weight</option>
                        <option value="heartRate">Heart Rate</option>
                    </select>
                    Value: <input type="text" name="componentValue" onChange={(event) => {this.componentValue=event.target.value}}/>
                    <button onClick={this.handleSubmit.bind(this)}>Confirm</button>
                </form>
                <Link to="/">GO Back</Link>
            </div>
        );
    }
}

export default CollectClinicals;