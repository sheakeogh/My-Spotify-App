import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/home/";

class HelloWorldService {

    getMessage(){
        return axios.get(USER_API_BASE_URL+"hello");
    }
}

export default new HelloWorldService()