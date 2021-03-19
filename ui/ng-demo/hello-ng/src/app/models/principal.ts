export class Principal {
    id: number;
    username: string;
    role: string;
    token: string;

    constructor(id: number, username: string, role: string, token: string) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.token = token;
    }
}