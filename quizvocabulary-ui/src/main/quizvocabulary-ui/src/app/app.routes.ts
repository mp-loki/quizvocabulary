import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CreateProfileComponent } from './component/profile/create-profile.component';
import { HomeComponent } from './component/home.component';
import { LoginComponent } from './component/login.component';
import { SelectLanguageStudiesComponent } from './component/profile/select-language-studies.component';
import { StudyComponent } from './component/study/study.component';
const appRoutes: Routes = [
  { path: 'profile/select-language-studies', component: SelectLanguageStudiesComponent },
  { path: 'profile/create-profile', component: CreateProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'study/:langName', component: StudyComponent },
  { path: '', component: HomeComponent },
  { path: '**', redirectTo: '' },
];

export const appRoutingProviders: any[] = [

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
