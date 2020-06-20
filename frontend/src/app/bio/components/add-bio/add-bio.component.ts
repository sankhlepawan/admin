import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { BioModel, ComplexionType, GenderType } from '../../bio.types';
import { BioService } from '../../bio.service';
import { numberPattern, numberFloatPattern } from '@shared/constants';

@Component({
  selector: 'app-add-bio',
  templateUrl: './add-bio.component.html',
  styleUrls: ['./add-bio.component.scss'],
})
export class AddBioComponent implements OnInit {
  constructor(private fb: FormBuilder, private _service: BioService) {
    this._createForm();
    this.itemDetailsType = [];
    this.itemDetailsType[0] = [];
    this.selectedItemDetails = [];
  }

  ngOnInit(): void {}

  addBioForm: FormGroup;
  isLoading = false;
  categories: any;
  subCategoriesList: any[];
  itemDetailsType: any[];
  selectedCategoryId: number;
  selectedCategory: any;
  selectedItemDetails: string[];
  complextionTypes: any = Object.keys(ComplexionType);
  genderTypes: any = Object.keys(GenderType);

  _createForm() {
    console.log(this.complextionTypes);
    this.addBioForm = this.fb.group({
      name: ['', { validators: [Validators.required] }],
      gender: ['', { validators: [Validators.required] }],
      dob: ['', { validators: [Validators.required] }],
      birthPlace: ['', { validators: [Validators.required] }],
      complextion: ['', { validators: [Validators.required] }],
      height: [undefined, { validators: [Validators.required, Validators.pattern(numberFloatPattern)] }],
      weight: [undefined, { validators: [Validators.pattern(numberPattern)] }],
      qualification: ['', { validators: [Validators.required] }],
      occupation: ['', { validators: [Validators.required] }],
      birthTime: ['', { validators: [Validators.required] }],
      salary: ['', { validators: [Validators.pattern(numberPattern)] }],
      currentWorkLocation: ['', { validators: [Validators.required] }],
      motherName: ['', { validators: [Validators.required] }],
      fatherName: ['', { validators: [Validators.required] }],
      fatherOccupation: ['', { validators: [Validators.required] }],
      motherOccupation: ['', { validators: [Validators.required] }],
      gotra: ['', { validators: [Validators.required] }],
      city: ['', { validators: [Validators.required] }],
      country: ['', { validators: [Validators.required] }],
      state: ['', { validators: [Validators.required] }],
      fullAddress: ['', { validators: [Validators.required] }],
      primaryContactNumber: ['', { validators: [Validators.required, Validators.minLength(10)] }],
      secondaryContactNumber: ['', { validators: [Validators.required, Validators.minLength(10)] }],
      siblings: ['', { validators: [Validators.required] }],
      working: [false, { validators: [Validators.required] }],
      petlover: [false, { validators: [Validators.required] }],
      eatingHabits: ['BOTH', { validators: [Validators.required] }],
    });
  }

  get name() {
    return this.addBioForm.get('birthPlace');
  }

  get gender() {
    return this.addBioForm.get('gender');
  }

  get petlover() {
    return this.addBioForm.get('petlover');
  }

  get dob() {
    return this.addBioForm.get('birthPlace');
  }
  get birthPlace() {
    return this.addBioForm.get('birthPlace');
  }
  get height() {
    return this.addBioForm.get('height');
  }

  get weight() {
    return this.addBioForm.get('weight');
  }
  get complextion() {
    return this.addBioForm.get('complextion');
  }

  get qualification() {
    return this.addBioForm.get('qualification');
  }
  get occupation() {
    return this.addBioForm.get('occupation');
  }

  get birthTime() {
    return this.addBioForm.get('birthTime');
  }

  get salary() {
    return this.addBioForm.get('salary');
  }

  get working() {
    return this.addBioForm.get('working');
  }

  get eatingHabits() {
    return this.addBioForm.get('eatingHabits');
  }

  get currentWorkLocation() {
    return this.addBioForm.get('currentWorkLocation');
  }

  get motherName() {
    return this.addBioForm.get('motherName');
  }

  get fatherName() {
    return this.addBioForm.get('fatherName');
  }

  get fatherOccupation() {
    return this.addBioForm.get('fatherOccupation');
  }

  get motherOccupation() {
    return this.addBioForm.get('motherOccupation');
  }

  get city() {
    return this.addBioForm.get('city');
  }

  get country() {
    return this.addBioForm.get('country');
  }

  get state() {
    return this.addBioForm.get('state');
  }

  get gotra() {
    return this.addBioForm.get('gotra');
  }

  get fullAddress() {
    return this.addBioForm.get('fullAddress');
  }

  get siblings() {
    return this.addBioForm.get('siblings');
  }

  get secondaryContactNumber() {
    return this.addBioForm.get('secondaryContactNumber');
  }

  get primaryContactNumber() {
    return this.addBioForm.get('primaryContactNumber');
  }

  onCollectionAdd(values: BioModel) {
    this.isLoading = true;
    console.log(JSON.stringify(values));
    // values.testMode = TestModeType.MANUAL;
    this._service.addBio(values).subscribe((res) => {
      this.isLoading = false;
      this.addBioForm.markAsPristine();
      this._createForm();
    });
  }
}
