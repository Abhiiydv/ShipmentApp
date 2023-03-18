import { Component, OnInit } from '@angular/core';
import { ShipmentDetails } from 'src/app/models/ShipmentDetails';

import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  enteredValue1!: number;
  
  s: ShipmentDetails = new ShipmentDetails();
  constructor(private userservice:UserService) { 

  }

  ngOnInit(): void {
  }

  fetchShipmentDetails(enteredValue1:number){

    this.userservice.getShipmentDetails(enteredValue1).subscribe(res =>{
      console.log(enteredValue1);
      this.s=res;
      console.log(this.s);
     
     },
     function (error) {
      console.log(error);
    
    }
    
     )

  }

}
