import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'another-app',
  templateUrl: './another-app.component.html',
  styleUrls: ['./another-app.component.css']
})
export class AnotherAppComponent implements OnInit {

  componentName = 'Another Angular App Component';

  constructor() { }

  ngOnInit(): void {
  }

}
