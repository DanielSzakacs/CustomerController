import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AlertsService} from "angular-alert-module";
import {environment} from "../../environments/environment.prod";

@Component({
  selector: 'app-cutomerpage',
  templateUrl: './cutomerpage.component.html',
  styleUrls: ['./cutomerpage.component.css']
})
export class CutomerpageComponent implements OnInit {
  private customersList = [];

  constructor(private http: HttpClient, private alert: AlertsService) {
  }

  ngOnInit() {
    this.alert.setDefaults('timeout', 4); //The alert will be visible for 4 sec.
    this.getAllCustomer();
    console.log(this.customersList);
  }

  private getAllCustomer(){
    this.http.get(environment.backendUrl+environment.getAllCustomer).subscribe(res => {
      this.customersList = res;
    },
      error1 => {
      this.alert.setMessage('No connection with the database', 'error')
      })
  }
  // search_customer
  // addNewCustomer
}
