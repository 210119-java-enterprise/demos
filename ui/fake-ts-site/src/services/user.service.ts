import { API_URL } from "../main.js";
import { Credentials } from "../models/credentials.js";

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
        return await resp.json();
    }

}