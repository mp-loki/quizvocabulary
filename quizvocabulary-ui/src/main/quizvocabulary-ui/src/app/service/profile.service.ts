import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Profile } from '../model/profile';
import { AbstractService } from './abstract.service';
import { Observable } from 'rxjs/Rx';
import { HttpService } from './http.service';

const PROFILE_URL = '/profile';

@Injectable()
export class ProfileService extends AbstractService {

  private profile: Profile;

  constructor(private httpService: HttpService) {
    super();
  }

  getProfile(): Promise<Profile> {
    if (this.profile != null) {
      return Promise.resolve(this.profile);
    } else {
      return this.httpService.doGet(PROFILE_URL)
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
      this.httpService.doPost(PROFILE_URL, this.profile).subscribe(
        p => this.profile = p,
        error => Observable.throw(error));
    }
  }
}
