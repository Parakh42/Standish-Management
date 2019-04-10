import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FundService {
  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getFunds(id: Number): Observable<any> {
    return this.http.get(this.baseUrl + '/investors/' + id + '/getFund');
  }
}
