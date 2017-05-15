import { Component, OnInit } from '@angular/core';
import { Auth } from './auth.service';

@Component({
  selector: 'app-root',
  providers: [Auth],
  templateUrl: './app.template.html'
})

export class AppComponent implements OnInit {
  constructor(private auth: Auth) {
  }
  
  ngOnInit(): void {

  }

}
