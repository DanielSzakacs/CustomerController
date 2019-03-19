import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.prod";
import {AlertService} from "ngx-alerts";

@Component({
  selector: 'app-cutomerpage',
  templateUrl: './cutomerpage.component.html',
  styleUrls: ['./cutomerpage.component.css']
})
export class CutomerpageComponent implements OnInit {
  protected customersList;
  protected selectedCustomer;

  constructor(private http: HttpClient, private alertService: AlertService) {
  }

  ngOnInit() {
    this.getAllCustomer();
  }

  private getAllCustomer(){
    this.http.get(environment.backendUrl+environment.getAllCustomer).subscribe(res => {
      this.customersList = res;
    },
      error1 => {
      this.alertService.danger('No connection with the database')
      })
  }

  protected addNewCustomer(customer){
    this.http.post(environment.backendUrl + environment.addNewCustomer, customer).subscribe(res => {
      this.alertService.success('New customer is saved');
      this.getAllCustomer();
    },
      error1 => {
      if(error1['status']==405){
        this.alertService.warning('Email is already registered');
      }
      if(error1['status']==406){
        this.alertService.danger('This is not an valid email');
      }
      })
  }
  // search_customer

  protected selectCustomer(customer){
    this.selectedCustomer = customer;
    this.alertService.success('Customer selected');
  }
}
