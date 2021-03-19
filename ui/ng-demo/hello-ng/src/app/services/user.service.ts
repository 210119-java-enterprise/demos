import { Injectable } from '@angular/core';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: User[];

  constructor() {
    console.log('UserService created!');
    this.users = [
      new User(1, 'aanderson', 'alice-pw'),
      new User(2, 'bbailey', 'bob-pw'),
      new User(3, 'ccalhoun', 'charlie-pw'),
      new User(4, 'ddaniels', 'derek-pw'),
      new User(5, 'eeinstein', 'emily-pw'),
    ];
  }

  getAllUsers(): User[] {
    return this.users;
  }

  getUserById(id: number): User {
    // example 1 of casting in TypeScript
    return <User> this.users.filter(u => u.getId() == id).pop();
  }

  getUserByUsername(username: string): User {
    // example 2 of casting in TypeScript
    return this.users.filter(u => u.getUsername() == username).pop() as User;
  }

}
