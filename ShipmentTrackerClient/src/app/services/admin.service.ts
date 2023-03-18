import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ShipmentDetails } from '../models/ShipmentDetails';
import { AuthenticationserviceService } from './authenticationservice.service';
import { RequestBaseService } from './request-base.service';


const API_URL = environment.BASE_URL + '/api/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService extends RequestBaseService{


  registershipment(shipment: ShipmentDetails): Observable<any> {
    return this.http.post(API_URL + '/saveshipment', shipment, { headers: this.getHeaders });
  }

  constructor(authenticationservice: AuthenticationserviceService, http: HttpClient) {
    super(authenticationservice,http);
   }
}
