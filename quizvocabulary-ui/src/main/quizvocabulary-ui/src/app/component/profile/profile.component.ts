import { Component, OnInit } from '@angular/core';
import { Profile } from '../../model/profile';
import { Language } from '../../model/language';
import { ProfileService } from '../../service/profile.service';
import { Router } from '@angular/router';
import { Auth } from '../../service/auth.service';

@Component({
  moduleId: module.id,
  selector: 'user-profile',
  templateUrl: '../../view/html/profile.component.html',
})
export class ProfileComponent implements OnInit {

  profile: Profile;

  constructor(
    private router: Router,
    private profileService: ProfileService,
    private auth: Auth
  ) { }


  getProfile(): void {
    this.profileService.getProfile().then(profile => {
      if (profile != null && profile.defaultLanguage != null) {
        this.profile = profile;
      } else {
        this.router.navigateByUrl('profile/create-profile');
      }
    });
  }

  getProfileLanguages() {
    return this.profile.languages;
  }

  openStudy(language: Language) {
    this.router.navigateByUrl('study/' + language.name);
  }

  openLanguageStudies() {
    this.router.navigateByUrl('profile/select-language-studies');
  }
  ngOnInit(): void {
    this.getProfile();
  }
}