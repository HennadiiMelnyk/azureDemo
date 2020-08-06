import {Injectable} from '@angular/core';
import {HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {mergeMap} from 'rxjs/operators';
import {MsAdalAngular6Service} from 'microsoft-adal-angular6';
import {User} from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptor implements HttpInterceptor {

  req: HttpRequest<any>;

  constructor(private adal: MsAdalAngular6Service, private httpClient: HttpClient) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    // get api url from adal config
    // console.log(req.headers.get('token'));
    const resource = this.adal.GetResourceForEndpoint(req.url);
    if (!resource || !this.adal.isAuthenticated) {
      return next.handle(req);
    }

    // merge the bearer token into the existing headers
    return this.adal.acquireToken(resource).pipe(
      mergeMap((token: string) => {
        const authorizedRequest = req.clone({
          headers: req.headers.set('Authorization', `Bearer ${token}`),
        });
        console.log(req.headers);
        return next.handle(authorizedRequest);
      }));
  }
}

