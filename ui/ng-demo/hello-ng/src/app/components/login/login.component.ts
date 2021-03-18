import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  loginSuccess = false;

  constructor(private formBuilder: FormBuilder, 
              private authService: AuthService, 
              private router: Router) {
    console.log('LoginComponent constructor was invoked!');

    console.log('Initializing form values for LoginComponent...');

    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    console.log('Initialization of LoginComponent form values complete');
  }

  get formFields() {
    return this.loginForm.controls;
  }

  login = async () => {

    if (this.loginForm.invalid) { 
      console.log('The form is invalid!');
      console.log(this.formFields.username.errors)
      return; 
    }

    this.loading = true;

    this.submitted = true;
    let un = this.formFields.username.value;
    let pw = this.formFields.password.value;

    console.log('in loginComponent.login', un, pw);

    try {
      await this.authService.authenticateUser(un, pw);
      this.loading = false;
      this.router.navigate(['/dashboard']);
    } catch (e) {
      console.log('Login failed!');
      console.error(e);
      this.loading = false;
    }
  
  }

}
