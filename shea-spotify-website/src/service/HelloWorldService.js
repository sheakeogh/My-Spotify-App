import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/";

const getMessage = () => {
    return axios.get(USER_API_BASE_URL + "hello");
}

const exportedObject = { getMessage };

export default exportedObject;