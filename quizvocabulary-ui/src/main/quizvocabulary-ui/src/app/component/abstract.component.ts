import { Injector, OnInit } from '@angular/core';
import { Profile } from '../model/profile';
import { Language } from '../model/language';
import { ProfileService } from '../service/profile.service';
import { LanguageService } from '../service/language.service';
import { Auth } from '../auth.service';
import { Router } from '@angular/router';

export class AbstractComponent implements OnInit {

  protected router: Router;
  protected profileService: ProfileService;
  protected languageService: LanguageService;
  protected auth: Auth;

  profile: Profile;
  languages: Language[];

  constructor(injector: Injector) {
    this.router = injector.get(Router);
    this.profileService = injector.get(ProfileService);
    this.languageService = injector.get(LanguageService);
    this.auth = injector.get(Auth);
  }

  getProfile(): void {
    this.profileService.getProfile().then(profile => {
      this.profile = profile;
      if (profile.nativeLanguage === undefined) {
        profile.nativeLanguage = this.languages[0];
      }
    });
  }

  getLanguages(): void {
    this.languageService.getLanguages()
      .then(languages => {
          this.languages = languages;
          this.getProfile();
      })
  }

  ngOnInit(): void {
    //this.getLanguages();
	  if (!this.auth.authenticated()) {
		  this.auth.login();
	  }
  }

  isEmpty(str: string): boolean {
    if (!str || !str.trim) { return true; };
    return false;
  }
}