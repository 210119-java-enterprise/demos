import { AppModule } from "./util/app.module.js"

export const API_URL = 'http://localhost:5000';
export const WINDOW_LOC = window.location.toString();

window.onload = () => {
    const app = new AppModule();
    app.services['router'].navigate('/login');
}