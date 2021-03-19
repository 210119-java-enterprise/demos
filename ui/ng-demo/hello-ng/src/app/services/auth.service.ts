import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { Principal } from '../models/principal';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject: BehaviorSubject<Principal | null>;
  currentUser$: Observable<Principal | null>;
  private token: string | null = null;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<Principal | null>(null);
    this.currentUser$ = this.currentUserSubject.asObservable();
  }

  get currentUserValue() {
    return this.currentUserSubject.value;
  }

  getToken(): string | null {
    return this.token;
  }

  authenticateUser(username: string, password: string): Promise<Principal> {
    console.log('in authservice.authenticateUser', username, password);
    return this.http.post(env.API_URL + '/users/authentication', {username, password}, {
      headers: {
        'Content-Type': 'application/json'
      },
      observe: 'response'
    }).pipe(
      map(resp => {
        this.token = resp.headers.get('quizzard-token');
        // console.log(`token: ${this.token}`);
        let principal = resp.body as Principal;
        this.currentUserSubject.next(principal);
        return principal;
      })
    ).toPromise();
  }

  logout() {
    this.currentUserSubject.next(null);
  }

  isAuthenticated(): boolean {
    return !!this.currentUserValue;
  }

}
