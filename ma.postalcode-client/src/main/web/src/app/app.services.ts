import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {map, catchError, tap} from 'rxjs/operators';
import {PostalCode} from './postalcode.class';

@Injectable()
export class PostalCodeService {

  apiV1URL: string = '/api/postalcode/v1/';

  constructor(private httpClient: HttpClient) {
  }


  find(value: string): Observable<PostalCode[]> {
    return this.httpClient.get<PostalCode[]>(this.apiV1URL + value);
  }


}
