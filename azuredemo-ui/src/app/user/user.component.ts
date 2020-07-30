import {Component, OnInit} from '@angular/core';
import {UserAuthorizationService} from '../service/user-authorization.service';
import {User} from '../model/User';
import {MsAdalAngular6Service} from 'microsoft-adal-angular6';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  user: User;
  adalService: MsAdalAngular6Service;

  constructor(userAuthService: UserAuthorizationService, adalService: MsAdalAngular6Service) {

  }

  login(): void {
    this.adalService.login();
  }

}
