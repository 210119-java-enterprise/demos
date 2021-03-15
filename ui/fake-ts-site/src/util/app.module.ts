import { DashboardComponent } from "../components/dashboard.component.js";
import { LoginComponent } from "../components/login.component.js";
import { UserService } from "../services/user.service.js";
import { Route } from "./route.js";
import { Router } from "./router.js";

export class AppModule {

    components: {login: LoginComponent, dashboard: DashboardComponent};
    services: {router: Router, user: UserService};

    constructor() {
        console.log('AppModule initialized');

        this.services = {
            router: new Router(),
            user: new UserService()
        }

        this.components = {
            login: new LoginComponent(this.services['user'], this.services['router']),
            dashboard: new DashboardComponent()
        }

        let routes = [
            new Route('/login', this.components['login']),
            new Route('/dashboard', this.components['dashboard'])
        ];

        this.services['router'].addRoutes(routes);

    }
}