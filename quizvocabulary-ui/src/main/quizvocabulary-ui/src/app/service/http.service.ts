import { Injectable } from '@angular/core';
import { Profile } from '../model/profile';
import { AuthHttp } from 'angular2-jwt';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';

const SERVER_URL = '/api/v1';

@Injectable()
export class HttpService {

  constructor(private http: Http, private authHttp: AuthHttp) { }

  doPost(url: string, payload: any): Observable<any> {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    const body = JSON.stringify(payload);
    console.log('Executing POST ' +  SERVER_URL + url + ", payload: " + payload);
    return this.authHttp.post(SERVER_URL + url, payload, options);
  }

  getUsers(): Observable<any> {
    console.log('HttpService.getUsers() called');
    return this.doGet('users');
    //return '{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"},{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}'
  }

  doGet(path: String): Observable<any> {
    return this.authHttp.get(SERVER_URL + path);
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
