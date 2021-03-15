export class Router {
    constructor() {
        this.routes = [];
        this.addRoutes = (rts) => {
            rts.forEach(route => this.routes.push(route));
        };
        this.navigate = (path) => {
            let route = this.routes.filter(r => r.path === path).pop();
            return route && route.component.render();
        };
    }
}
