import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { environment as env } from 'src/environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hello-ng';

  constructor(private http: HttpClient) {}

  doTheThing = () => {
    console.log('did the thing!');
  }

  // thing = () => {
  //   this.http.get(env.API_URL + "users").subscribe();
  // };


  
}
