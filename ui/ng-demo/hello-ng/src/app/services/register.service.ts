import { Injectable } from '@angular/core';
import { environment as env } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  registerUser(username: string, password: string,
              firstName: string, lastName: string,
              email: string): Promise<any> {
    console.log('in registerservice.registerUser', username, password, firstName, lastName, email);
    return this.http.post(env.API_URL + '/users', {username, password, firstName, lastName, email}, {
      headers: {
        'Content-Type': 'application/json'
      },
      observe: 'response'
    }).toPromise();
  }
}
