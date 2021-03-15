var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import { WINDOW_LOC } from "../main.js";
import { state } from "../util/state.js";
export class DashboardComponent {
    constructor(userService) {
        this.userService = userService;
        this.template = `<h1>Welcome, <span id="welcome-username"></span>`;
        this.render = () => __awaiter(this, void 0, void 0, function* () {
            console.log('DashboardComponent.render() invoked!');
            let url = `${WINDOW_LOC}dashboard`;
            window.history.pushState({ key: url }, 'My Quizzard Dashboard', url);
            let user = state.currentUser || { username: '' };
            (document.getElementById('root') || { innerHTML: '' }).innerHTML = this.template;
            (document.getElementById('welcome-username') || { innerText: '' }).innerText = user.username;
            let users = yield this.userService.getAllUsers();
            console.log(users);
        });
        console.log('DashboardComponent initialized!');
    }
}
