
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { Angulartics2Module } from 'angulartics2';
import { SharedModule } from '@shared';
import { MaterialModule } from '@app/material.module';
import { BioRoutingModule } from './bio-routing.module';
import { BioComponent } from './bio.component';
import { AddBioComponent, UserProfileComponent } from './components';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    TranslateModule,
    SharedModule,
    FlexLayoutModule,
    MaterialModule,
    Angulartics2Module,
    BioRoutingModule,
    ReactiveFormsModule,
  ],
  declarations: [BioComponent, AddBioComponent, UserProfileComponent],
})
export class BioModule {}
