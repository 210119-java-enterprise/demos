export class User {

    // username: string;
    // password: string;

    // constructor(username: string, password: string) {
    //     this.username = username;
    //     this.password = password;
    // }

    constructor(private _id: number, 
                private _username: string, 
                private _password: string) {}

    getId() {
        return this._id;
    }

    getUsername() {
        return this._username;
    }

    getPassword() {
        return this._password;
    }
    
}