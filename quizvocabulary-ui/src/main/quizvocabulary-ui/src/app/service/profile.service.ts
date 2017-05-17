import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Profile } from '../model/profile';
import { AuthHttp } from 'angular2-jwt';
import { AbstractService } from './abstract.service';
import { Observable } from 'rxjs/Rx';

const PROFILE_URL = '/api/v1/profile';

@Injectable()
export class ProfileService extends AbstractService {
  private profile: Profile;// = this.initProfile();
  constructor(private authHttp: AuthHttp) {
    super();
  }

  getProfile(): Promise<Profile> {
    if (this.profile != null) {
      return Promise.resolve(this.profile);
    } else {
      return this.authHttp.get(PROFILE_URL)
        .toPromise()
        .then(response => {
          this.profile = response.json() as Profile;
          return this.profile;
        })
        .catch(error => {
          console.log(error);
          return null;
        });
    }
  }

  saveTempProfile(profile: Profile) {
    this.profile = profile;
  }

  saveProfile(profile: Profile) {
    this.profile = profile;
    if (this.profile != null) {
      this.post(PROFILE_URL, this.profile).subscribe(
        p => this.profile = p,
        error => Observable.throw(error));
    }
  }

  post(url: string, payload: any): Observable<any> {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    const body = JSON.stringify(payload);
    return this.authHttp.post(url, payload, options);
  }
}
