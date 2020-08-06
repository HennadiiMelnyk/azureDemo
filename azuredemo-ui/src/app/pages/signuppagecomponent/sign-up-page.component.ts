import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signuppagecomponent',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  goBackToProductsPage(): void {
    this.router.navigate(['/products']).then();
  }
}
