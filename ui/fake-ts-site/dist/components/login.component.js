var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import { WINDOW_LOC } from '../main.js';
import { state } from '../util/state.js';
export class LoginComponent {
    constructor(userService, router) {
        this.userService = userService;
        this.router = router;
        this.template = `
    <div class="login-form">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="username-cred" class="sr-only">Username</label>
        <input type="text" id="username-cred" class="form-control" placeholder="Username" autofocus>
        <br/>
        <label for="password-cred" class="sr-only">Password</label>
        <input type="password" id="password-cred" class="form-control" placeholder="Password">
        <br/>
        <button class="btn btn-lg btn-primary btn-block" id="submit-creds">Sign in</button>
        &nbsp;&nbsp;&nbsp;
        <button class="btn btn-lg btn-secondary btn-block" id="nav-register">Create An Account</button>
        <br>
        <div hidden class="alert alert-danger text-center" id="alert-msg" role="alert">
            Invalid Credentials!
        </div>
        <p class="mt-5 mb-3 text-muted">&copy; Revature 2017-2021</p>
    </div>
    `;
        this.render = () => {
            var _a, _b, _c;
            console.log('LoginComponent.render() invoked!');
            let url = `${WINDOW_LOC}login`;
            window.history.pushState({ key: url }, 'Login to your Quizzard Account!', url);
            (document.getElementById('root') || { innerHTML: '' }).innerHTML = this.template;
            (_a = document.getElementById('submit-creds')) === null || _a === void 0 ? void 0 : _a.addEventListener('click', this.login);
            (_b = document.getElementById('password-cred')) === null || _b === void 0 ? void 0 : _b.addEventListener('keydown', (e) => {
                if (e.keyCode == 13)
                    this.login();
            });
            (_c = document.getElementById('nav-register')) === null || _c === void 0 ? void 0 : _c.addEventListener('click', () => {
                console.log('Navigate to Registration button clicked!');
            });
        };
        this.login = () => __awaiter(this, void 0, void 0, function* () {
            let username = document.getElementById('username-cred').value || '';
            let password = document.getElementById('password-cred').value || '';
            let authUser = yield this.userService.authenticate({ username, password });
            state.currentUser = authUser;
            this.router.navigate('/dashboard');
        });
        console.log('LoginComponent initialized!');
    }
}
