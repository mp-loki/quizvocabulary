import { Component, OnInit } from '@angular/core';
import { Profile } from '../../model/profile';
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
      if (profile != null && profile.nativeLanguage != null) {
        this.profile = profile;
      } else {
        this.router.navigateByUrl('profile/create-profile');
      }
    });
  }

  ngOnInit(): void {
    this.getProfile();
  }
}