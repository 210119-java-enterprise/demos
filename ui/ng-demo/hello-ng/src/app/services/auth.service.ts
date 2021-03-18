import { HttpClient } from '@angular/common/http';
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

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<Principal | null>(null);
    this.currentUser$ = this.currentUserSubject.asObservable();
  }

  get currentUserValue() {
    return this.currentUserSubject.value;
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
