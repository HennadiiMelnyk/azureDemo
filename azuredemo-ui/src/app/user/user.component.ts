import {Component, OnInit} from '@angular/core';
import {TokenInterceptor} from '../service/token-interceptor.service';
import {User} from '../model/User';
import {MsAdalAngular6Service} from 'microsoft-adal-angular6';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserService} from '../service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  //user: User;
  // userName: string;

  constructor(private router: Router,
              private httpClient: HttpClient,
              userAuthService: TokenInterceptor,
              private adalService: MsAdalAngular6Service,
              private userService: UserService) {
  }

  login(): void {
    this.adalService.login();
    console.log(this.adalService.userInfo);
    this.userService.signUpUser(this.adalService.accessToken).subscribe();
    // console.log(this.adalService.accessToken);
    // this.userName = this.adalService.userInfo.userName;
  }

  logout(): void {
    this.adalService.logout();
  }

  getLoggedInUser(): any {
    return this.adalService.LoggedInUserEmail;
  }

  getAccessToken(): Observable<any> {
    return this.adalService.acquireToken('backend-api-uri');
  }

  getToken(): string {
    return this.adalService.accessToken;
  }

  navigateToSignUpPage(): void {
    this.router.navigate(['/signUp']).then();
  }

}
