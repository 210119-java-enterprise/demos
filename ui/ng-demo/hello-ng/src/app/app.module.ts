import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnotherAppComponent } from './components/another-app/another-app.component';
import { StructuralDirectivesComponent } from './components/structural-directives/structural-directives.component';
import { AttributeDirectivesComponent } from './components/attribute-directives/attribute-directives.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { HttpInterceptService } from './services/http-intercept.service';

@NgModule({
  // components, directives, and pipes declared within this module
  declarations: [
    AppComponent,
    AnotherAppComponent,
    StructuralDirectivesComponent,
    AttributeDirectivesComponent,
    LoginComponent,
    DashboardComponent,
    NavbarComponent,
    RegisterComponent
  ],
  // other modules which contain members we wish to use within members of this module
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, // home of the ngModel attribute (for two-way data binding)
    ReactiveFormsModule,
    NgbModule, 
    HttpClientModule
  ],

  // a subset of declarations that can be made visible to other modules
  exports: [

  ],

  // you can optionally declare services used within this module here
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptService,
      multi: true
    }
  ],
  
  // defines a root component, which hosts all other app views
  // only included within the root module of your NG app
  bootstrap: [AppComponent]
})
export class AppModule { }
