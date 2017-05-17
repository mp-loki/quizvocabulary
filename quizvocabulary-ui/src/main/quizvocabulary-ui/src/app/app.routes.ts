import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './component/home.component';
import { SelectLanguageStudiesComponent } from './component/profile/select-language-studies.component';
import { CreateProfileComponent } from './component/profile/create-profile.component';
const appRoutes: Routes = [
  { path: 'profile/select-language-studies', component: SelectLanguageStudiesComponent },
  { path: 'profile/create-profile', component: CreateProfileComponent },
  { path: '', component: HomeComponent },
  { path: '**', redirectTo: '' },
];

export const appRoutingProviders: any[] = [

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
