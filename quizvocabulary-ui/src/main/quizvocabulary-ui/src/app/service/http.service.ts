import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Profile } from '../model/profile';

@Injectable()
export class HttpService {
  
  constructor(private http: Http) { }

  getUsers() {
	  console.log('HttpService.getUsers() called')
	  return '{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"},{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}'
  }
}
