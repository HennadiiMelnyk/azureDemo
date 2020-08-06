import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsBaseUrl: string = 'http://localhost:8080/products';


  constructor(private httpClient: HttpClient) {
  }

  getListProducts(): Observable<any> {
    return this.httpClient.get(this.productsBaseUrl);
  }

  createProduct(product: object): Observable<any> {
    return this.httpClient.post('http://localhost:8080/product', product);
  }

  getProductById(id: string): Observable<any> {
    return this.httpClient.get(`${this.productsBaseUrl}/${id}`);
  }

  deleteProductById(id: string): Observable<any> {
    return this.httpClient.delete(`${this.productsBaseUrl}/${id}`);
  }

  updateProductById(id: number, product: object): Observable<any> {
    return this.httpClient.put(`${this.productsBaseUrl}/${id}`, product);
  }


}
