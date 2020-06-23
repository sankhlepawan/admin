import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';

import { Credentials, CredentialsService } from './credentials.service';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';

export interface LoginContext {
  username: string;
  password: string;
  remember?: boolean;
}

/**
 * Provides a base for authentication workflow.
 * The login/logout methods should be replaced with proper implementation.
 */
@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  
  
  constructor(private credentialsService: CredentialsService,private _http: HttpClient) {}

  /**
   * Authenticates the user.
   * @param context The login parameters.
   * @return The user credentials.
   */
  login(context: LoginContext): Observable<Credentials> {
    // Replace by proper authentication call
    return this._http.post<Credentials>('/authenticate', {username:context.username,password:context.password})
    .pipe(
      map((res: Credentials) => {
        const data = {
          username: context.username,
          token: res.token,
        };
        this.credentialsService.setCredentials(data, context.remember);
        return data;
      }), catchError( error => {
           return throwError( error && error.error && error.error.message || 'Server error' );
      })
   )
  }


  /**
   * Logs out the user and clear credentials.
   * @return True if the user was logged out successfully.
   */
  logout(): Observable<boolean> {
    // Customize credentials invalidation here
    this.credentialsService.setCredentials();
    return of(true);
  }
}
