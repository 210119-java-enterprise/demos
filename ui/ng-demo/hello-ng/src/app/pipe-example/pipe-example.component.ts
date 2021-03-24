import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'pipe-example',
  templateUrl: './pipe-example.component.html',
  styleUrls: ['./pipe-example.component.css']
})
export class PipeExampleComponent {

  examplePerson = {
    firstName: '',
    lastName: ''
  }

  time = 1616528753;

  changeToDefault() {
    this.examplePerson = {
      firstName: 'default',
      lastName: 'person'
    }
  }

  updateTime(newTime: number) {
    this.time = newTime;
  }

}
