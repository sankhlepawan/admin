import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { BioModel, ComplexionType, GenderType, MaritalStatusType, EatingHabitsType,CastType } from '../../bio.types';
import { BioService } from '../../bio.service';
import { numberPattern, numberFloatPattern } from '@shared/constants';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-bio',
  templateUrl: './add-bio.component.html',
  styleUrls: ['./add-bio.component.scss'],
})
export class AddBioComponent implements OnInit {
  constructor(private fb: FormBuilder, private _service: BioService,private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    let isEdit = this.route.snapshot.paramMap.get('isEdit');
    console.log(this._service);
    let bio = this._service.getSelectedBio();

    if (isEdit) {
      this._createForm(bio);
    } else {
      this._createForm(undefined);
    }
  }

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
  maritalStatusType: any = Object.keys(MaritalStatusType);
  eatingHabitsType: any = Object.keys(EatingHabitsType);

  _createForm(bio: BioModel) {
    this.addBioForm = this.fb.group({
      name: [(bio && bio.name) || '', { validators: [Validators.required] }],
      gender: [ (bio && bio.gender) || '', { validators: [Validators.required] }],
      dob: [ (bio && bio.dob) || '', { validators: [Validators.required] }],
      birthPlace: [ (bio && bio.birthPlace), { validators: [Validators.required] }],
      complextion: [ (bio && bio.complextion), { validators: [Validators.required] }],
      height: [(bio && bio.height) || 0, { validators: [Validators.required, Validators.pattern(numberFloatPattern)] }],
      weight: [(bio && bio.weight) | 0, { validators: [Validators.pattern(numberPattern)] }],
      qualification: [(bio && bio.qualification) || '', { validators: [Validators.required] }],
      occupation: [ (bio && bio.occupation) || '', { validators: [Validators.required] }],
      birthTime: [ (bio && bio.birthTime) || '', { validators: [Validators.required] }],
      salary: [ (bio && bio.salary) || 0, { validators: [] }],
      currentWorkLocation: [ (bio && bio.currentWorkLocation)||'', { validators: [Validators.required] }],
      motherName: [ (bio && bio.motherName) ||'', { validators: [Validators.required] }],
      fatherName: [ (bio && bio.fatherName)||'', { validators: [Validators.required] }],
      fatherOccupation: [ (bio && bio.fatherOccupation) ||'', { validators: [Validators.required] }],
      motherOccupation: [  (bio && bio.motherOccupation) || '', { validators: [Validators.required] }],
      gotra: [ (bio && bio.gotra) || '', { validators: [Validators.required] }],
      city: [ (bio && bio.city) || '', { validators: [Validators.required] }],
      country: [ (bio && bio.country) || 'India', { validators: [Validators.required] }],
      state: [(bio && bio.state) || '', { validators: [Validators.required] }],
      fullAddress: [ (bio && bio.fullAddress) || '', { validators: [Validators.required] }],
      primaryContactNumber: [ (bio && bio.primaryContactNumber) || '', { validators: [Validators.required, Validators.minLength(10)] }],
      secondaryContactNumber: [(bio && bio.secondaryContactNumber) ||'', { validators: [Validators.required, Validators.minLength(10)] }],
      siblings: [(bio && bio.siblings) ||'', { validators: [Validators.required] }],
      working: [ (bio && bio.working) || false, { validators: [Validators.required] }],
      petlover: [ (bio && bio.petlover) || false, { validators: [Validators.required] }],
      eatingHabits: [ (bio && bio.eatingHabits) || 'BOTH', { validators: [Validators.required] }],
      maritalStatus : [(bio && bio.maritalStatus) || 'SINGLE', { validators: [Validators.required] }],
      cast : [ (bio && bio.cast) || CastType.DHOBI, { validators: [] }],
    });
  }

  get name() {
    return this.addBioForm.get('birthPlace');
  }

  get maritalStatus() {
    return this.addBioForm.get('maritalStatus');
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

  onBioAdd(values: BioModel) {
    this.isLoading = true;
    console.log(JSON.stringify(values));
    // values.testMode = TestModeType.MANUAL;
    this._service.addBio(values).subscribe((res) => {
      this.isLoading = false;
      this.addBioForm.markAsPristine();
      this._createForm(undefined);
    });
  }
}
