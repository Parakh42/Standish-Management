import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../client';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {
  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getClients(): Observable<any> {
    return this.http.get(this.baseUrl + '/clients');
  }

  createClient(cli: Client) {
    return this.http.post(this.baseUrl+'/createClient', cli);
  }

  updateClient(id: Number, cli : Client) {
    return this.http.put(this.baseUrl + '/clients/' + id, cli);

  }


}
