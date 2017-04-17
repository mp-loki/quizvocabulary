import { Component, Injector, OnInit } from '@angular/core';
import { AbstractComponent } from '../abstract.component';

@Component({
  moduleId: module.id,
  selector: 'create-profile',
  templateUrl: '../../view/html/create-profile.component.html',
})
export class CreateProfileComponent extends AbstractComponent implements OnInit {
  
  constructor(injector: Injector) {
    super(injector);
  }
      
  proceed():void {
    this.profileService.saveTempProfile(this.profile);
    this.router.navigateByUrl('profile/select-language-studies');
  }
}