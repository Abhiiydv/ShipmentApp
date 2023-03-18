import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './models/user.model';
import { AuthenticationserviceService } from './services/authenticationservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private authenticationService: AuthenticationserviceService, private router: Router) {
    this.authenticationService.currentUser.subscribe(data => {
      this.currentUser = data;
    });
  }

  currentUser: User = new User;
  title = 'ShipmentTrackerClient';

  logOut() {
    this.authenticationService.logOut();
    this.router.navigate(['/login']);
  }
  
}
