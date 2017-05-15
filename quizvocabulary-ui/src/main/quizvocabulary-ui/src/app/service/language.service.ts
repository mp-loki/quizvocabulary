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

const LANGUAGES: Language[] = [
    { name: 'English', code: 'en' },
    { name: 'Deutsch', code: 'de' },
    { name: 'Français', code: 'fr' },
    { name: 'Español', code: 'es' },
    { name: 'Українська', code: 'ua' },
    { name: '日本語', code: 'jp' },
];

const LANG_URL = '/api/v1/languages';
@Injectable()
export class LanguageService extends AbstractService {

    constructor(private authHttp: AuthHttp) {
       super();
    }

    getLanguages(): Promise<Language[]> {
        return this.authHttp.get(LANG_URL)
            .toPromise()
            .then(response => response.json() as Language[])
            .catch(this.handleError);

    	//return Promise.all(LANGUAGES);
    }

    getLanguageByName(name: string): Language {
        return LANGUAGES.find(language => language.name === name);
    }

    getBoards(language: Language) { 

    }
}
