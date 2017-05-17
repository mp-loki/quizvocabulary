import { Component, } from '@angular/core';
import { Auth } from '../service/auth.service';

@Component({
  selector: 'app-root',
  providers: [Auth],
  templateUrl: '../view/html/app.template.html'
})

export class AppComponent {
  constructor(private auth: Auth) {
  }

}
