import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Principal } from 'src/app/models/principal';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser: Principal | null;
  private currentUserSub: Subscription | null;

  authLinks = [
    {
      linkName: 'Structural Directives Demo',
      linkPath: '/structural'
    },
    {
      linkName: 'Attribute Directives Demo',
      linkPath: '/attribute'
    },
    {
      linkName: 'Dashboard',
      linkPath: '/dashboard'
    }
  ]

  publicLinks = [
    {
      linkName: 'Login',
      linkPath: '/login'
    }
  ];

  constructor(private authService: AuthService) {
    this.currentUser = null;
    this.currentUserSub = null;
  }

  ngOnInit(): void {
    this.currentUserSub = this.authService.currentUser$.subscribe(user => {
      this.currentUser = user as Principal;
    });
  }

}
