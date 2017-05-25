import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { AuthHttp } from 'angular2-jwt';
import { Profile } from '../model/profile';
import { Language } from '../model/language';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './abstract.service';
import { HttpService } from './http.service';
/*
const LANGUAGES: Language[] = [
    { name: 'English', code: 'en' },
    { name: 'Deutsch', code: 'de' },
    { name: 'Français', code: 'fr' },
    { name: 'Español', code: 'es' },
    { name: 'Українська', code: 'ua' },
    { name: '日本語', code: 'jp' },
];
*/
const LANG_URL = '/languages';
@Injectable()
export class LanguageService extends AbstractService {

  private languages: Language[];
  constructor(private authHttp: AuthHttp, private httpService: HttpService) {
    super();
  }

  getLanguages(): Promise<Language[]> {
    if (this.languages != null) {
      return Promise.all(this.languages);
    }
    return this.httpService.doGet(LANG_URL)
      .toPromise()
      .then(response => {this.languages = response.json() as Language[]; return this.languages; })
      .catch(this.handleError);
  }

  getLanguageByName(name: string): Language {
    if (this.languages === null) { return null; };
    return this.languages.find(language => language.name === name);
  }
}
