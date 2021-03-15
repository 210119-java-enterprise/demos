import { WINDOW_LOC } from "../main.js";
import { state } from "../util/state.js";
export class DashboardComponent {
    constructor() {
        this.template = `<h1>Welcome, <span id="welcome-username"></span>`;
        this.render = () => {
            console.log('DashboardComponent.render() invoked!');
            let url = `${WINDOW_LOC}dashboard`;
            window.history.pushState({ key: url }, 'My Quizzard Dashboard', url);
            let user = state.currentUser || { username: '' };
            (document.getElementById('root') || { innerHTML: '' }).innerHTML = this.template;
            (document.getElementById('welcome-username') || { innerText: '' }).innerText = user.username;
        };
        console.log('DashboardComponent initialized!');
    }
}
