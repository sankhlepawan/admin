import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of as observableOf, throwError,BehaviorSubject } from 'rxjs';
import { UserModel, UserApi, RoleApi, RolesTypes } from './user.types';
import { defaultPagination } from '@shared/constants';
import { Logger } from '@core/logger.service';
import { map, catchError } from 'rxjs/operators';

const log = new Logger('OrderService');

@Injectable({
  providedIn: 'root',
})
export class UserService {
  
  selectUser: UserModel;
  _profile: UserModel;
  userRoleSource = new BehaviorSubject(false);
  isAdmin = this.userRoleSource.asObservable();

  rolesSource = new BehaviorSubject([]);
  roles = this.rolesSource.asObservable();

  rolesTypes = RolesTypes;
  
  constructor(private _httpClient: HttpClient) {}

  setSelectedUser(u: UserModel) {
    this.selectUser = u;
  }

  getSelectedUser() {
    return this.selectUser;
  }

  _createRIQL(filter: any) {
    let q = '';
    for (let key in filter) {
      if (key == 'role' && filter[key]) {
        q += `roles.roleName==${filter[key]};`;
      } else if (key == 'name' && filter[key]) {
        q += `(firstName==*${filter[key]}*,lastName==*${filter[key]}*);`;
      } else if (filter[key]) {
        q += `${[key]}==*${filter[key]}*;`;
      }
    }
    return q.substring(0, q.length - 1);
  }

  getUsers(sortBy: string, sortType: string, page: number, limit: number, filter: any): Observable<UserApi> {
    const body = { sortType, sortBy, page, limit, query: '' };
    body.query = this._createRIQL(filter);
    log.info('fetching order data...');
    const url = '/v1/user/search';
    return this._httpClient.post<UserApi>(url, body);
  }

  create(form: any) {
    return this._httpClient.post<UserModel>('/v1/user/create', form);
  }

  deleteUser(userId: number) {
    return this._httpClient.post<UserModel>(`/v1/user/delete`, { id: userId });
  }

  enableUser(user: UserModel) {
    return this._httpClient.post<UserModel>(`/v1/user/enable`, { id: user.id, enable: !user.enable });
  }

  findByMobile(mobile: string) {
    let body = { query: `mobile==*${mobile}*`, limit: 100, ...defaultPagination };
    return this._httpClient.post<UserApi>('/v1/user/search', body);
  }

  getAllRoles() {
    const url = '/v1/role/search';
    const form = {
      query: 'id=gt=0',
      limit: 100,
      ...defaultPagination,
    };
    return this._httpClient.post<RoleApi>(url, form);
  }

  _getProfile() {
    this.rolesSource.next([]);
    return this._httpClient.post<any>('/v1/user/profile','')
    .pipe(
      map((res: any) => {
        this._profile = res;
        let roles = this._profile.roles.map(r => r.roleName);
        if(this.roles) {
           this.userRoleSource.next(roles.indexOf('ROLE_ADMIN') !== -1)
           this.rolesSource.next(roles);
        }
        return res;
      }), catchError( error => {
           return throwError( error && error.error && error.error.message || 'Server error' );
      })
   ).subscribe(res=> log.info('logged in username is =>', res.username))
  }

  // get roles(): string[] {
  //   if(this._profile) {
  //     return this._profile.roles.map(r => r.roleName);
  //   }
  //   return null;
  // }
}
