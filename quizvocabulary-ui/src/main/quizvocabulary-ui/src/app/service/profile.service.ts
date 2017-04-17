import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Profile } from '../model/profile';

@Injectable()
export class ProfileService {
  private profile = this.initProfile();
  constructor(private http: Http) { }

  initProfile(): Profile {
    let profile = new Profile();
    profile.name = 'Savi';
    profile.email = 'savi@gmail.com';
    //profile.nativeLanguage = { name: 'English', code: 'en' };
    return profile;
  }

  getProfile(): Promise<Profile> {
    return Promise.resolve(this.profile);
  }

  saveTempProfile(profile: Profile) {
    this.profile = profile;
  }

  saveProfile(profile: Profile) {
    // TODO: Save profile to server
    this.profile = profile;
  }
}
