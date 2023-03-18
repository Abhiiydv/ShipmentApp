import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthenticationserviceService } from 'src/app/services/authenticationservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  errorMessage: string = "";

  constructor(private authenticationService: AuthenticationserviceService, public router: Router) { }

  ngOnInit(): void {
    if (this.authenticationService.currentUserValue?.id) {
      if (this.authenticationService.currentUserValue.role == 'ADMIN') {
        this.router.navigate(['/admin-dashboard']);
      }
      else if (this.authenticationService.currentUserValue.role == 'USER') {
        this.router.navigate(['user-dashboard']);
      }
    }
  }

  login() {
    this.authenticationService.login(this.user).subscribe(data => {
      if (data.role == 'ADMIN')
        this.router.navigate(['/admin-dashboard']);
      else if (data.role == 'USER')
        this.router.navigate(['/user-dashboard'])
      console.log(data.role);
    }, error => {
      this.errorMessage = 'Username or password is incorrect.';
      console.log(error);
    });
  }



}
