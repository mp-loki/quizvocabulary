import { Component, OnInit, Input } from '@angular/core';
import { Auth } from '../service/auth.service';

@Component({
  selector: 'login',
  template: ''
})
export class LoginComponent implements OnInit {
  constructor(private auth: Auth) { }
  ngOnInit(): void {
    this.auth.login();
  }
}