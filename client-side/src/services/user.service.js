import axios from 'axios';
import {BehaviorSubject} from 'rxjs';

const API_URL = 'http://localhost:8080';
const currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));

class UserService {
    get currentUserValue(){
        return currentUserSubject.value;
    }

    get currentUser(){
        return currentUserSubject.asObservable();
    }

    login(user) {
        const headers = {
            authorization: 'Basic ' + btoa(user.username + ':' + user.password)
        };
        return axios.get(`${API_URL}/service/login/`, {headers: headers}).then(response => {
            localStorage.setItem('currentUser', JSON.stringify(response.data));
            currentUserSubject.next(response.data);
        });
    }

    logOut() {
        return axios.post(`${API_URL}/service/logout/`, {}).then(() => {
            
            localStorage.removeItem('currentUser');
            currentUserSubject.next(null);
        });
    }

    register(user) {
        return axios.post(`${API_URL}/service/registration/`, user);
    }

   
}

export default new UserService();