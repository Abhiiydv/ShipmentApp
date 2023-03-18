import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShipmentDetails } from 'src/app/models/ShipmentDetails';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {


  shipment: ShipmentDetails = new ShipmentDetails();
  errorMessage: string ="";



  constructor(private adminservice:AdminService,private router:Router) { }

  ngOnInit(): void {
  }
  register( ){

    this.adminservice.registershipment(this.shipment).subscribe(data => {
      console.log(data);
      this.errorMessage = "Shipment Submitted";
      console.log("Shipment Submitted");
    },
      err => {
        console.log(err);

      })

  }

  

}
