import { Component } from '@angular/core';
import { Auth }      from './auth.service';
import { HttpService } from './service/http.service';

@Component({
  selector: 'home',
  templateUrl: './home.template.html'
})

export class HomeComponent {
  constructor(private auth: Auth, httpService: HttpService) {
	  this.httpService = httpService
  }
  
  response: string;
  httpService:HttpService; 
  
  getUsers() {
	  console.log('getUsers() called')
	  this.response = this.httpService.getUsers()
  }
};
