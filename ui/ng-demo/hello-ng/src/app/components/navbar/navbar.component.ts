import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  links = [
    {
      linkName: 'Structural Directives Demo',
      linkPath: '/structural'
    },
    {
      linkName: 'Attribute Directives Demo',
      linkPath: '/attribute'
    },
    {
      linkName: 'Login',
      linkPath: '/login'
    },
    {
      linkName: 'Dashboard',
      linkPath: '/dashboard'
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
