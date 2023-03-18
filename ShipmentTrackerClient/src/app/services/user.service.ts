import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthenticationserviceService } from './authenticationservice.service';
import { RequestBaseService } from './request-base.service';



const API_URL = environment.BASE_URL + '/api/user';

@Injectable({
  providedIn: 'root'
})
export class UserService extends RequestBaseService{


  getShipmentDetails(shipmentId: number): Observable<any> {
    return this.http.get(API_URL + '/shipment/' + shipmentId, { headers: this.getHeaders });
  }


  constructor(authenticationservice: AuthenticationserviceService, http: HttpClient) {
    super(authenticationservice,http);
   }
}
