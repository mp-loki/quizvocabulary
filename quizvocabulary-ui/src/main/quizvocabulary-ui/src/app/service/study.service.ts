import { Injectable } from '@angular/core';
import { Study } from '../model/study';
import { Language } from '../model/language';
import { Observable } from 'rxjs/Rx';
import { HttpService } from './http.service';

const STUDY_URL = "study"
@Injectable()
export class StudyService {

  constructor(private httpService: HttpService) { }
  
  getStudy(langName: string):Observable<Study> {
    return this.httpService.doGet(STUDY_URL + '/' + langName);
  }
}
