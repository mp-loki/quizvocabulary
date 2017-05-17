import { Injector, OnInit, Component } from '@angular/core';
import { Profile } from '../../model/profile';
import { Language } from '../../model/language';
import { ProfileService } from '../../service/profile.service';
import { LanguageService } from '../../service/language.service';
import { Auth } from '../../service/auth.service';
import { Router } from '@angular/router';

@Component({
  moduleId: module.id,
  selector: 'create-profile',
  templateUrl: '../../view/html/create-profile.component.html',
})
export class CreateProfileComponent implements OnInit {

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

  proceed(): void {
    this.profileService.saveTempProfile(this.profile);
    this.router.navigateByUrl('profile/select-language-studies');
  }

  ngOnInit(): void {
    if (this.profile != null) {
      this.router.navigateByUrl('home');
    }
    this.profile = new Profile();
    this.getLanguages();
  }

  getLanguages(): void {
    this.languageService.getLanguages()
      .then(languages => {
        console.log(languages);
        this.languages = languages;
      });
  }

}