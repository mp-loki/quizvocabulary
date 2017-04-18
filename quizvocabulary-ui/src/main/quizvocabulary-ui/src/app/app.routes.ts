import { ModuleWithProviders }         from '@angular/core';
import { Routes, RouterModule }        from '@angular/router';

import { HomeComponent }               from './home.component';
import { ProfileRoutes }               from './profile.routes';
import { SelectLanguageStudiesComponent } from './component/profile/select-language-studies.component';
const appRoutes: Routes = [
  { path: 'profile/select-language-studies', component: SelectLanguageStudiesComponent },
  { path: '', component: HomeComponent },
  ...ProfileRoutes,
  { path: '**', redirectTo: '' },
];

export const appRoutingProviders: any[] = [

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
