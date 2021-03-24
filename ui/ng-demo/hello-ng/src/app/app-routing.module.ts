import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AttributeDirectivesComponent } from './components/attribute-directives/attribute-directives.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { StructuralDirectivesComponent } from './components/structural-directives/structural-directives.component';
import { PipeExampleComponent } from './pipe-example/pipe-example.component';

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'structural', component: StructuralDirectivesComponent},
  {path: 'attribute', component: AttributeDirectivesComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'pipes', component: PipeExampleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
