import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/User';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersBaseUrl: string = 'http://localhost:8080/users';

  constructor(private httpClient: HttpClient) {
  }

  signUpUser(token: string): Observable<any> {
    return this.httpClient.post(this.usersBaseUrl, token);
  }
}
