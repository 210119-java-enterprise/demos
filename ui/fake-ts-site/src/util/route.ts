import { View } from "../components/view.js";

export class Route {

    path: string;
    component: View;

    constructor(path: string, component: View) {
        this.path = path;
        this.component = component;
    }
    
}