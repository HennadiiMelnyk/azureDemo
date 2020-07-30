import {BrowserModule} from '@angular/platform-browser';
import {NgModule, APP_INITIALIZER} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {MsAdalAngular6Module} from 'microsoft-adal-angular6';
import {MsAdalAngular6Service} from 'microsoft-adal-angular6';
import {MatCardModule} from '@angular/material/card';

import {AppRoutingModule} from './app-routing.module';
import {UserAuthorizationService} from './service/user-authorization.service';
import {ProductService} from './service/product.service';
import {AppComponent} from './app.component';
import {ProductComponent} from './product/product.component';
import {MatButtonModule} from '@angular/material/button';
import {MatPaginatorModule} from '@angular/material/paginator';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { UserComponent } from './user/user.component';


// function initializer(adalService: MsAdalAngular6Service) {
//   console.log(adalService.userInfo)
//   return () => new Promise((resolve, reject) => {
//     if (adalService.isAuthenticated) {
//       resolve();
//     } else {
//       adalService.login();
//     }
//   });
// }

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule,
    MatPaginatorModule,
    MatCardModule,
    MsAdalAngular6Module.forRoot({
      tenant: 'd6397071-8e3e-45d2-a2d6-36698acf0fea',
      clientId: '45cd0c49-bb19-4ccf-b327-f563c1482936',
      redirectUri: window.location.origin,
      navigateToLoginRequestUrl: false,
      grantType: 'authorization_code',
      cacheLocation: 'localStorage',
    })
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: UserAuthorizationService,
      multi: true,
      deps: [MsAdalAngular6Service]
    },
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
