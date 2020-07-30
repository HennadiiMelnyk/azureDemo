import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ProductService} from './service/product.service';
import {MsAdalAngular6Service} from 'microsoft-adal-angular6';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'azuredemo-ui';
  constructor(private httpClient: HttpClient, private adalService: MsAdalAngular6Service, private productService: ProductService) {
    // this.adalService.getToken;
  }

  products: any[];
  // getDataFromApi() {
  //   this.productService.getListProducts().subscribe((data) => {
  //     console.log(data)
  //     this.products = data;
  //   })
  // }

  // login(): void {
  //   this.adalService.login();
  // }

  // logout(): void {
  //   this.adalService.logout();
  // }

  // getLoggedInUser(): any {
  //   return this.adalService.LoggedInUserEmail;
  // }

  // getAccessToken(): Observable<any> {
  //   return this.adalService.acquireToken('backend-api-uri');
  // }

  // getToken(): string {
  //   return this.adalService.accessToken;
  // }
}
