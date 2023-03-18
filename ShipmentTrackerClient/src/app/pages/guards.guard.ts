import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { AuthenticationserviceService } from '../services/authenticationservice.service';

@Injectable({
  providedIn: 'root'
})
export class GuardsGuard implements CanActivate {
  
  private currentUser: User = new User;

  constructor(private authenticationService: AuthenticationserviceService, private router: Router) {
    this.authenticationService.currentUser.subscribe(data => {
      this.currentUser = data;
    });
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    if (this.currentUser) {
      if (route.data['roles']?.indexOf(this.currentUser.role) === -1) {
        this.router.navigate(['/401']);
        return false;
      }

      return true;
    }

    this.router.navigate(['/login']);

    return true;
  }

  
}
