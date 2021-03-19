import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptService implements HttpInterceptor {

  constructor(private auth: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // console.log("in interceptor");
    req = req.clone({
      setHeaders: {
        "quizzard-token": `${this.auth.getToken()}`
      }
    });
    // console.log(`set quizzard-token to: ${this.auth.getToken()}`);
    return next.handle(req);
  }
}
