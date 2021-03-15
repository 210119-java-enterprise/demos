var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import { API_URL } from "../main.js";
export class UserService {
    constructor() {
        this.authenticate = (creds) => __awaiter(this, void 0, void 0, function* () {
            console.log('UserService.authenticate() invoked!');
            let resp = yield fetch(`${API_URL}/users/authentication`, {
                method: 'POST',
                body: JSON.stringify(creds),
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            });
            return yield resp.json();
        });
        console.log('UserService initialized!');
    }
}
