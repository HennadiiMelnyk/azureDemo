import {BrowserModule} from '@angular/platform-browser';
import {NgModule, APP_INITIALIZER} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {MsAdalAngular6Module, MsAdalAngular6Service, AuthenticationGuard} from 'microsoft-adal-angular6';
import {MatCardModule} from '@angular/material/card';

import {AppRoutingModule} from './app-routing.module';
import {TokenInterceptor} from './service/token-interceptor.service';
import {ProductService} from './service/product.service';
import {AppComponent} from './app.component';
import {ProductComponent} from './product/product.component';
import {MatButtonModule} from '@angular/material/button';
import {MatPaginatorModule} from '@angular/material/paginator';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {UserComponent} from './user/user.component';
import { SignUpPageComponent } from './pages/signuppagecomponent/sign-up-page.component';



function initializer(adalService: MsAdalAngular6Service) {
  console.log(adalService.userInfo);
  return () => new Promise((resolve, reject) => {
    if (adalService.isAuthenticated) {
      resolve();
    } else {
      adalService.login();
    }
  });
}

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    UserComponent,
    SignUpPageComponent
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
      tenant: 'cc8d9e54-1f40-4753-9899-96e37c0597f8',
      clientId: '2d468dab-bcbb-4074-8a1f-c9b40aa7291d',
      redirectUri: 'http://localhost:4200/',
      navigateToLoginRequestUrl: false,
      grantType: 'authorization_code',
      cacheLocation: 'localStorage',
    })
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
      deps: [MsAdalAngular6Service]
    },
    AuthenticationGuard,
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
