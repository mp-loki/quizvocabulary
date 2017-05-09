import { Component } from '@angular/core';
import { Auth } from './auth.service';

@Component({
    selector: 'app-root',
    providers: [ Auth ],
    templateUrl: './app.template.html'
})

export class AppComponent {
  constructor(private auth: Auth) {
    
  }
}
