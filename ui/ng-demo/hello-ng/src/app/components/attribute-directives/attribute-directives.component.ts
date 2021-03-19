import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'attribute-directives',
  templateUrl: './attribute-directives.component.html',
  styleUrls: ['./attribute-directives.component.css']
})
export class AttributeDirectivesComponent {

  isDisabled = true;
  name = 'Wezley';
  selectedColor = 'green';
  colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];

  classes = [
    {
      className: 'font-weight-bold', // Bootstrap class name
      displayName: 'bold' // Name to rendered for the user to the DOM
    },
    {
      className: 'font-italic',
      displayName: 'italic'
    },
    {
      className: 'mark',
      displayName: 'highlight'
    }
  ];

  selectedClasses = [];


  enabler() {
    this.isDisabled = !this.isDisabled;
  }

  addClasses($event: any) {

    this.selectedClasses = [];

    for (let option of $event.target.selectedOptions) {

      // @ts-ignore
      this.selectedClasses.push(option.value);

    }

    console.log(this.selectedClasses);
  }
}
