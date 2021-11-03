import axios from 'axios';
import react from 'react';

class AnalyzeCoding extends react.Component {
    
    state = {
        clinicalData: [],
        firstName: "",
        lastName: "", 
        age: ""
    }

    componentDidMount() {
        axios.get("http://localhost:8080/clinicalservices/patients/analyze/" + this.props.match.params.patientId)
        .then((res)=> {
            this.setState(res.data);
        });
    }

    render() {
        return(
            <div>
                <h2>Patient Details:</h2>
                First Name: {this.state.firstName}<br />
                Last Name: {this.state.lastName}<br />
                Age: {this.state.age}
                <h2>Clinical Report:</h2>
                {
                    this.state.clinicalData.map(entry=> {
                        return <TableCreator item={entry} patientId={this.state.patientId}/>
                    })
                }
            </div>
        );
    }
}

class TableCreator extends react.Component {
    render() {
        const clinicalData = this.props.item;
        const patientId = this.props.patientId;

        return <div>
            <table>
                <tr>
                    <td>{clinicalData.componentName}</td>
                </tr>
                <tr>
                    <td>{clinicalData.componentName}</td>
                    <td>{clinicalData.componentValue}</td>
                    <td>{clinicalData.measuredDateTime}</td>
                </tr>
            </table>
        </div>
    }
}

export default AnalyzeCoding;