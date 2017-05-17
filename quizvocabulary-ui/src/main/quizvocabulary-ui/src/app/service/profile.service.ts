import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Profile } from '../model/profile';
import { AuthHttp } from 'angular2-jwt';
import { AbstractService } from './abstract.service';

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
    // TODO: Save profile to server
    this.profile = profile;
  }
}
