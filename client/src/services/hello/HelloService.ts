import axios, { AxiosRequestConfig } from 'axios';

export class HelloService {

    public async getMessage(): Promise<string> {
        const config: AxiosRequestConfig = {
            url: '/api/hello',
            method: 'get'
        };

        const response = await axios.request(config);
        return response.data.message;
    }
}

const helloService = new HelloService();
export default helloService;