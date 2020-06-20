import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';

import { MaterialModule } from '@app/material.module';
import {
  LoaderComponent,
  NoDataComponent,
  ValidationErrorComponent,
  FilterChipComponent,
  FileUploadComponent,
} from './components';
import { RoleNamePipe, FullNamePipe } from './pipes';

const pipes = [RoleNamePipe, FullNamePipe];
const components = [
  LoaderComponent,
  NoDataComponent,
  ValidationErrorComponent,
  FilterChipComponent,
  FileUploadComponent,
];
@NgModule({
  imports: [FlexLayoutModule, MaterialModule, CommonModule],
  declarations: [...components, ...pipes],
  exports: [...components, ...pipes],
  providers: [],
})
export class SharedModule {}
