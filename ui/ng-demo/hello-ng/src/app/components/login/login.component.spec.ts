import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, fakeAsync, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { Principal } from 'src/app/models/principal';
import { AuthService } from 'src/app/services/auth.service';
import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authServiceSpy: jasmine.SpyObj<AuthService>;
  let routerSpy: jasmine.SpyObj<Router>;

  beforeEach(async () => {

    const spyA = jasmine.createSpyObj('AuthService', ['authenticateUser']);
    const spyB = jasmine.createSpyObj('Router', ['navigate']);
    
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      providers: [
        { provide: AuthService, useValue: spyA },
        { provide: Router, useValue: spyB }
      ],
      imports: [ReactiveFormsModule]
    })
    .compileComponents();

    authServiceSpy = TestBed.inject(AuthService) as jasmine.SpyObj<AuthService>;
    routerSpy = TestBed.inject(Router) as jasmine.SpyObj<Router>;

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have empty form fields when rendered', () => {
    let usernameFieldValue = component.formFields.username.value;
    let passwordFieldValue = component.formFields.password.value;
    expect(usernameFieldValue).toBe('');
    expect(passwordFieldValue).toBe('');
  });

  it('should not display the #invalid-credentials-warning initially', () => {
    expect(fixture.nativeElement.querySelector('#invalid-credentials-warning')).toBeFalsy();
  });

  it('should display only the #username-required-warning if no username is provided when form is submitted', () => {
    component.formFields.username.setValue('');
    component.formFields.password.setValue('some-password');
    component.login();
    fixture.detectChanges();

    expect(fixture.debugElement.query(By.css('#username-required-warning'))).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#password-required-warning')).toBeFalsy();
  });

  it('should display only the #password-required-warning if no password is provided when form is submitted', () => {
    component.formFields.username.setValue('some-username');
    component.formFields.password.setValue('');
    component.login();
    fixture.detectChanges();

    expect(fixture.debugElement.query(By.css('#password-required-warning'))).toBeTruthy();
    expect(fixture.nativeElement.querySelector('#username-required-warning')).toBeFalsy();
  });

  it('should display both the required warnings if neither a username nor password is provided when form is submitted', () => {
    component.login();
    fixture.detectChanges();

    expect(fixture.debugElement.query(By.css('#username-required-warning'))).toBeTruthy();
    expect(fixture.debugElement.query(By.css('#password-required-warning'))).toBeTruthy();
  });

  it('should pass the provided username and password to AuthService.authenticateUser()', () => {
    component.formFields.username.setValue('some-username');
    component.formFields.password.setValue('some-password');
    component.login();

    expect(authServiceSpy.authenticateUser).toHaveBeenCalledOnceWith('some-username', 'some-password');
  });

  it('should pass the path to the dashboard to Router.navigate() when given valid credentials', fakeAsync(() => {
    component.formFields.username.setValue('some-username');
    component.formFields.password.setValue('some-password');
    authServiceSpy.authenticateUser.and.callFake(() => Promise.resolve(new Principal(1, 'mock-usr', 'mock-pw', 'mock-tkn')));
    component.login();
    fixture.detectChanges();
    
    fixture.whenStable().then(() => {
      expect(routerSpy.navigate).toHaveBeenCalledOnceWith(['/dashboard']);
    });
    
  }));

});
