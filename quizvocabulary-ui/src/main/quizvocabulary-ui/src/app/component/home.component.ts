import { Component, OnChanges, Input } from '@angular/core';
import { Auth } from '../service/auth.service';
import { HttpService } from '../service/http.service';
import { LanguageService } from '../service/language.service';

@Component({
  selector: 'home',
  templateUrl: '../view/html/home.template.html'
})

export class HomeComponent {
  response: any;

  constructor(private auth: Auth, private httpService: HttpService, private langService: LanguageService) {}

  getLanguages() {
    this.langService.getLanguages().then((data) => {
      console.log('***' + data);
      this.response = data;
    });
  }

};
