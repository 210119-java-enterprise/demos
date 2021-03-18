import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

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
              private userService: UserService, 
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

    try {
      this.submitted = true;
      let user = await this.userService.authenticateUser(this.formFields.username.value, this.formFields.password.value);
      this.loginSuccess = true;
      this.loading = false;
      this.router.navigate(['/dashboard']);
    } catch (err) {
      this.submitted = false;
      this.loginSuccess = false;
      console.error(err);
    }

  }

}
