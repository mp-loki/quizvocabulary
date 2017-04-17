import { Component, OnInit } from '@angular/core';
import { Profile } from '../../model/profile';
import { ProfileService } from '../../service/profile.service';
import { Router } from '@angular/router';

@Component({
  moduleId: module.id,
  selector: 'user-profile',
  templateUrl: '../../view/html/profile.component.html',
})
export class ProfileComponent implements OnInit {

  constructor(
    private router: Router,
    private profileService: ProfileService) { }
  
  profile: Profile;
  
  getProfile(): void {
    this.profileService.getProfile().then(profile => this.profile = profile);
  }
  
  ngOnInit(): void {
    this.getProfile();
  }
}