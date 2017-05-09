import { Injectable }      from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { myConfig }        from './auth.config';

// Avoid name not found warnings
var options = {
  auth: {
    params: {scope: 'openid email user_metadata app_metadata picture',
             responseType: 'id_token token'},
  }
};  

declare var Auth0Lock: any;

@Injectable()
export class Auth {
  // Configure Auth0
  lock = new Auth0Lock(myConfig.clientID, myConfig.domain, options);

  //Store profile object in auth class
  userProfile: any;

  constructor() {
    // Set userProfile attribute if already saved profile
    this.userProfile = JSON.parse(localStorage.getItem('profile'));

    // Add callback for lock `authenticated` event
    this.lock.on('authenticated', (authResult) => {
      
    
      localStorage.setItem('token', authResult.idToken);

      // Fetch profile information
      this.lock.getProfile(authResult.idToken, (error, profile) => {
        if (error) {
          // Handle error
          alert(error);
          return;
        }

        profile.user_metadata = profile.user_metadata || {};
        localStorage.setItem('profile', JSON.stringify(profile));
        this.userProfile = profile;
      });
    });
  };

  public login() {
    // Call the show method to display the widget.
    this.lock.show();
  };

  public authenticated() {
    // Check if there's an unexpired JWT
    // It searches for an item in localStorage with key == 'id_token'
    return tokenNotExpired('token');
  };

  public logout() {
    // Remove token and profile from localStorage
    console.log("logout clicked");
    localStorage.removeItem('token');
    localStorage.removeItem('profile');
    this.userProfile = undefined;
  };
}