import { Component, OnInit, OnDestroy } from '@angular/core';
import { Profile } from '../../model/profile';
import { Language } from '../../model/language';
import { LanguageService } from '../../service/language.service';
import { ProfileService } from '../../service/profile.service';
import { StudyService } from '../../service/study.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  moduleId: module.id,
  selector: 'study',
  templateUrl: '../../view/html/study.component.html',
})
export class StudyComponent implements OnInit, OnDestroy {

  logosToAdd: string;
  translationToAdd: string;

  studyLanguage: Language;
  defaultlanguage: Language;
  private sub: any;

  constructor(private router: Router,
    private profileService: ProfileService,
    private languageService: LanguageService,
    private route: ActivatedRoute) {
  }

  save(): void {
    this.clear();
  }

  clear(): void {
    this.logosToAdd = null;
    this.translationToAdd = null;
  }
  ngOnInit(): void {    this.sub = this.route.params.subscribe(params => {
      const langName = params['langName'];
      console.log("Lang is: " + langName);

      // In a real app: dispatch action to load the details here.
    });  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }}
