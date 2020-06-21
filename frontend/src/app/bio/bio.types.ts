export enum ComplexionType {
  FAIR = 'FAIR',
  DARK = 'DARK',
  WHITISH = 'WHITISH',
}

export enum MaritalStatusType {
  SINGLE = 'SINGLE',
  DIVORCED = 'DIVORCED',
}

export enum CastType {
  DHOBI = 'DHOBI'
}

export enum EatingHabitsType {
  VEG = 'VEG',
  NON_VEG = 'NON_VEG',
  BOTH = 'BOTH',
}

export enum GenderType {
  MALE = 'MALE',
  FEMALE = 'FEMALE',
}

export interface BioModel {
  id: number;
  name: string;
  gender: GenderType;
  dob: string;
  manglik: boolean;
  birthPlace: string;
  height: number;
  weight: number;
  complextion: ComplexionType;
  qualification: string;
  occupation: string;
  birthTime: string;
  salary: string;
  working: boolean;
  petlover: boolean;
  eatingHabits: EatingHabitsType;
  currentWorkLocation: string;
  motherName: string;
  fatherName: string;
  fatherOccupation: string;
  motherOccupation: string;
  city: string;
  country: string;
  state: string;
  gotra: string;
  fullAddress: string;
  primaryContactNumber: string;
  secondaryContactNumber: string;
  siblings: string;
  photo: [string];
  maritalStatus: string;
  profilePic: string;
  cast: string;
}

export interface AllBioApi {
  count: number;
  items: BioModel[];
}
