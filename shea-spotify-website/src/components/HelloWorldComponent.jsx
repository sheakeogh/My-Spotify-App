import React, { Component } from 'react'
import HelloWorldService from '../service/HelloWorldService'

class HelloWorldComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {message: ''};
    }

    componentDidMount() {
        HelloWorldService.getMessage().then(res => {
            this.setState({ message: res.data });
        });
    }

    render() {
        return (
            <div>
                <div> 
                    {React.createElement('h1', {className: 'greeting'}, this.state.message)} 
                </div>
            </div>
        )
    }
}

export default HelloWorldComponent