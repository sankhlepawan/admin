import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.scss'],
})
export class ValidationErrorComponent {
  constructor() {}
  @Input('fieldVal') fieldVal: any;
  @Input('message') message: string;
}