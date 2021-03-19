import { API_URL } from "../main.js";
import { Credentials } from "../models/credentials.js";
import { state } from "../util/state.js";

export class UserService {

    constructor() {
        console.log('UserService initialized!');
    }

    authenticate = async (creds: Credentials) => {
        console.log('UserService.authenticate() invoked!');
        
        let resp = await fetch(`${API_URL}/users/authentication`, {
            method: 'POST',
            body: JSON.stringify(creds),
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        });
        
        console.log(resp);

        // @ts-ignore
        state.token = resp.headers.get('quizzard-token');
        console.log(state.token);
        return await resp.json();
    }

    
    getAllUsers = async () => {
        let resp = await fetch(`${API_URL}/users`, {
            // @ts-ignore
            headers: new Headers({
                'quizzard-token': state.token
            })
        });
        return await resp.json();
    }

}