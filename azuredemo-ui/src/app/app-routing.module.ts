import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SignUpPageComponent} from './pages/signuppagecomponent/sign-up-page.component';
import {ProductComponent} from './product/product.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: 'signUp', component: SignUpPageComponent},
    {path: 'products', component: ProductComponent}
  ])
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
