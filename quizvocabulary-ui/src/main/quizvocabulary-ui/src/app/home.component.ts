import { Component } from '@angular/core';
import { Auth } from './auth.service';
import { HttpService } from './service/http.service';

@Component({
  selector: 'home',
  templateUrl: './home.template.html'
})

export class HomeComponent {
  response: any;
  constructor(private auth: Auth, private httpService: HttpService) {
  }

  getUsers() {
    this.httpService.getUsers().then((data) => {
      console.log('***' + data);
      this.response = data;
    });
  }
};
