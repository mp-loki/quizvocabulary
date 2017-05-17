import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http, RequestOptions, JsonpModule } from '@angular/http';
import { provideAuth, AuthHttp, AuthConfig } from 'angular2-jwt';

import { AppComponent } from './component/app.component';
import { HomeComponent } from './component/home.component';
import { ProfileComponent } from './component/profile/profile.component';
import { SelectLanguageStudiesComponent } from './component/profile/select-language-studies.component';
import { CreateProfileComponent } from './component/profile/create-profile.component';
import { ProfileService } from './service/profile.service';
import { LanguageService } from './service/language.service';
import { HttpService } from './service/http.service';
import {
  routing,
  appRoutingProviders
} from './app.routes';

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
    headerPrefix: 'Bearer',
    noJwtError: true,
    tokenName: 'accessToken',
    globalHeaders: [{ 'Accept': 'application/json' }],
    tokenGetter: (() => localStorage.getItem('accessToken'))
  }), http);
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    SelectLanguageStudiesComponent,
    CreateProfileComponent
  ],
  providers: [
    appRoutingProviders,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    },
    ProfileService,
    LanguageService,
    HttpService
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    HttpModule,
    JsonpModule
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
