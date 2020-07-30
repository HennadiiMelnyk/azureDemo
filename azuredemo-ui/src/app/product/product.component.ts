import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/Product';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product [] = new Array();
  product: Product;
  pageSlice;
  error: string;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getListProducts()
      .subscribe(p => {
        this.products = p;
        this.pageSlice = p.slice(0, 3);
      });

  }

  addProduct(name: string, id: string, price: string, color: string, description: string): void {
    const newProduct: Product = {name, id, price, color, description} as Product;
    this.productService.createProduct(newProduct).subscribe(p => this.products.push(newProduct));
  }

  deleteProduct(productId: string): void {
    this.productService.deleteProductById(productId).subscribe(data => {
      console.log(data);
    });
  }

  getProductById(productId: string): void {
    console.log(productId);
    this.productService.getProductById(productId).subscribe(p => {
        this.product = p;
      },
      er => {
        this.error = er;
      }
    );
    console.log(this.product);
  }

  public getPaginatorData(event: PageEvent): void {
    console.log(event);
    const startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex + event.pageSize;
    if (endIndex > this.products.length) {
      endIndex = this.products.length;
    }
    this.pageSlice = this.products.slice(startIndex, endIndex);
    console.log(this.pageSlice);
  }

}
