import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent {

  //  ngIf Demo
  myCondition = true;

  // doesn't matter if you use standard function declarations or arrow functions
  // changeCondition() {
  
  // }

  changeCondition = () => {
    this.myCondition = !this.myCondition;
  }


  //----------------------

  // ngFor Demo
  people = [
    'Wezley', 'Greg', 'Brian', 'Cole', 'Kalyb'
  ];

  monsters = [
    {
      name: 'Nessie',
      location: 'Loch Ness, Scotland'
    },
    {
      name: 'Bigfoot',
      location: 'Pacific Northwest, USA'
    },
    {
      name: 'Godzilla',
      location: 'Tokyo, Japan'
    }
  ];

  //-----------------------------------

  // ngSwitch Demo

  time = '';

  changeTimeOfDay(desiredTime: string) {
    this.time = desiredTime;
  }
  
}
