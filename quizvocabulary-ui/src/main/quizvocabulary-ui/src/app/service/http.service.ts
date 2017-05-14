import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Profile } from '../model/profile';
import { AuthHttp } from 'angular2-jwt';

const SERVER_URL = "http://localhost:8080/api/v1/";

@Injectable()
export class HttpService {

  constructor(private http: Http, private authHttp: AuthHttp) { }

  getUsers(): Promise<any> {
    console.log('HttpService.getUsers() called');
    return this.doGet('users');
    //return '{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"},{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}'
  }

  doGet(path: String): Promise<any> {
    return this.authHttp.get(SERVER_URL + path).toPromise().then(this.extractData).catch(this.handleError);
  }
  private extractData(res: Response) {
   // let body = res.json();
   // return body.data || {};
    return JSON.stringify(res);
  }
  private handleError(error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Promise.reject(errMsg);
  }
}
