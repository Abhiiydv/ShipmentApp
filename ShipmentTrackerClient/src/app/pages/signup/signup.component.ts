import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthenticationserviceService } from 'src/app/services/authenticationservice.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: User = new User();
  errorMessage: string ="";
  
    constructor(private authenticationService: AuthenticationserviceService, private router: Router) { }
  
    ngOnInit(): void {
      if(this.authenticationService.currentUserValue?.id){
        if(this.authenticationService.currentUserValue.role == 'ADMIN'){
          this.router.navigate(['/admin-dashboard']);
        }
        else if(this.authenticationService.currentUserValue.role == 'USER'){
          this.router.navigate(['/user-dashboard']);
        }
      }
    }
     register() {
       this.authenticationService.registeradmin(this.user).subscribe(data => {
        this.router.navigate(['/login']);
       }, err => {
         if (err?.status === 409) {
           this.errorMessage = 'Username already exist.';
         }
         else {
          this.errorMessage = 'Unexpected error occurred.';
           console.log(err);
       }
     })
     }
   
  
}
