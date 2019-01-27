import * as React from 'react';
import helloService from '../../services/hello/HelloService';

interface State {
    message: string;
}

export default class Hello extends React.Component<any, State> {

    constructor(props: any) {
        super(props);
        this.state = {
            message: ''
        };
    }

    async componentDidMount() {
        const message = await helloService.getMessage();

        this.setState({message: message});
    }

    render() {
        return (
            <div>
                <h1 className="message">{this.state.message}</h1>
            </div>
        );

    }
}
