import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  loading = false;
  submitted = false;
  registerSuccess = false;

  constructor(private formBuilder: FormBuilder, 
      private router: Router,
      private registerService: RegisterService) {

    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  get formFields() {
    return this.registerForm.controls;
  }

  register = async () => {
    if (this.registerForm.invalid) { 
      console.log('The form is invalid!');
      console.log(this.formFields.username.errors);
      console.log(this.formFields.password.errors);
      console.log(this.formFields.firstName.errors);
      console.log(this.formFields.lastName.errors);
      console.log(this.formFields.email.errors);
      this.submitted = true;
      this.registerSuccess = false;
      return; 
    }

    this.loading = true;

    this.submitted = true;
    let un = this.formFields.username.value;
    let pw = this.formFields.password.value;
    let fn = this.formFields.firstName.value;
    let ln = this.formFields.lastName.value;
    let em = this.formFields.email.value;

    console.log('in registerComponent.register', un, pw, fn, ln, em);

    try {
      await this.registerService.registerUser(un, pw, fn, ln, em);
      this.loading = false;
      this.router.navigate(['/login']);
    } catch (e) {
      console.log('Register failed!');
      console.error(e);
      this.loading = false;
    }
  }

}
