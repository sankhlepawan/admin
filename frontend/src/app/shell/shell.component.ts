import { Title } from '@angular/platform-browser';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { MediaObserver } from '@angular/flex-layout';
import { getMenus } from './menu';
import { AuthenticationService, CredentialsService } from '@app/auth';
import { UserService } from '@app/user/user.service';
import { Subscription } from 'rxjs';

export interface MenuModel {
  name: string;
  path: string;
}

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss'],
})
export class ShellComponent implements OnInit, OnDestroy {
  constructor(
    private router: Router,
    private titleService: Title,
    private authenticationService: AuthenticationService,
    private credentialsService: CredentialsService,
    private media: MediaObserver,
    private userService: UserService
  ) {}

  menus: MenuModel[];
  _subscription:Subscription;

  ngOnInit() {
    this.menus = [];
    if(this.credentialsService.isAuthenticated()) {
        this.userService._getProfile();
        this._subscription = this.userService.roles.subscribe(roles => {
          this.menus = getMenus(roles);
        });
    }
  }

  ngOnDestroy() {
    this._subscription.unsubscribe();
  }

  logout() {
    this.authenticationService.logout().subscribe(() => this.router.navigate(['/login'], { replaceUrl: true }));
  }

  get username(): string | null {
    const credentials = this.credentialsService.credentials;
    return credentials ? credentials.username : null;
  }

  get isMobile(): boolean {
    return this.media.isActive('xs') || this.media.isActive('sm');
  }

  get title(): string {
    return this.titleService.getTitle();
  }
}
