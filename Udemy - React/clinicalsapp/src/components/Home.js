import react from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

class Home extends react.Component {
    
    state = {
        patientData:[]
    };

    componentDidMount() {
        axios.get('http://localhost:8080/clinicalservices/patients/').then(res=>{
            const patientData = res.data;
            this.setState({patientData});
        });
    }
    render() {
        return(
            <div>
                <h2>Patients:</h2>
                <table align="center">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.patientData.map(patient => {
                            return <RowCreator item={patient} />
                        })}
                    </tbody>
                </table>
                <br />
                <Link to={'/addPatient'}><font size="5">Register Patient</font></Link>
            </div>
        );
    }
}

class RowCreator extends react.Component {
    render() {
        var patient = this.props.item;
        return <tr>
                <td>{patient.id}</td>
                <td>{patient.firstName}</td>
                <td>{patient.lastName}</td>
                <td>{patient.age}</td>
                <td><Link to={'/patientDetails/'+patient.id}>Add Data</Link></td>
                <td><Link to={'/analyze/'+patient.id}>Analyze Data</Link></td>
        </tr>
    }
}
export default Home;