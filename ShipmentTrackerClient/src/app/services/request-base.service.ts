import { User } from "../models/user.model";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { AuthenticationserviceService } from "./authenticationservice.service";


export abstract class RequestBaseService {

  protected currentUser: User = new User;

  protected constructor(protected authenticationService: AuthenticationserviceService, protected http: HttpClient) {
    this.authenticationService.currentUser.subscribe(data => {
      this.currentUser = data;
    });
  }

  get getHeaders(): HttpHeaders {
    return new HttpHeaders(
      {
        authorization: 'Bearer ' + this.currentUser?.accessToken,
        "Content-Type": "application/json; charset=UTF-8"
      }
    );
  }
}
