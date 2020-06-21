import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { extract } from '@app/i18n';
import { BioComponent } from './bio.component';
import { AddBioComponent, UserProfileDetailComponent } from './components';

const routes: Routes = [
  { path: '', component: BioComponent, data: { title: extract('Bio') } },
  { path: 'add-bio', component: AddBioComponent, data: { title: extract('Bio') } },
  { path: 'bio-detail', component: UserProfileDetailComponent, data: { title: extract('Bio') } },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class BioRoutingModule {}
