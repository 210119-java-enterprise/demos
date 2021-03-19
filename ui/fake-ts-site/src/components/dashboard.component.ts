import { WINDOW_LOC } from "../main.js";
import { UserService } from "../services/user.service.js";
import { state } from "../util/state.js";
import { View } from "./view.js";

export class DashboardComponent implements View {

    template = `<h1>Welcome, <span id="welcome-username"></span>`;

    constructor(private userService: UserService) {
        console.log('DashboardComponent initialized!');
    }

    render = async () => {
        console.log('DashboardComponent.render() invoked!');

        let url = `${WINDOW_LOC}dashboard`;
        window.history.pushState({key: url}, 'My Quizzard Dashboard', url);

        let user = state.currentUser || {username: ''};
        (document.getElementById('root') || {innerHTML: ''}).innerHTML = this.template;
        (document.getElementById('welcome-username') || {innerText: ''}).innerText = user.username;

        let users = await this.userService.getAllUsers();
        console.log(users);
    }
    
}