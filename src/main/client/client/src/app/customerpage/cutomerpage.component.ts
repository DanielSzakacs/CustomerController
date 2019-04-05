import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment.prod";
import {AlertService} from "ngx-alerts";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-cutomerpage',
  templateUrl: './cutomerpage.component.html',
  styleUrls: ['./cutomerpage.component.css']
})
export class CutomerpageComponent implements OnInit {
  customersList;
  selectedCustomer;
  queryField: FormControl = new FormControl();

  constructor(private http: HttpClient, private alertService: AlertService) {
  }

  ngOnInit() {
    this.queryField.valueChanges
      .subscribe( result => {
        this.searchCustomersByName(result);
      });
    this.getAllCustomer();
  }

  searchCustomersByName(name){
    if(name == ''){
      this.getAllCustomer();
    }
    this.http.get(environment.backendUrl + '/search_customer?name=' + name).subscribe(res => {
      this.customersList = res;
    },
      error1 => {
      console.log(error1);
      })
  }

  getAllCustomer(){
    this.http.get(environment.backendUrl+environment.getAllCustomer).subscribe(res => {
      this.customersList = res;
    },
      error1 => {
      this.alertService.danger('No connection with the database')
      })
  }

  addNewCustomer(customer){
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

  search_customer(email){
    this.alertService.warning('This feature is under development')
  }

  selectCustomer(customer){
    this.selectedCustomer = customer;
  }

  delete_customer(){
    this.http.delete(environment.backendUrl + environment.deleteCustomer + "?id=" + this.selectedCustomer['id']).subscribe(res =>{
      this.getAllCustomer();
      this.selectCustomer(null);
      this.alertService.info('Customer deleted');
    },
      error1n => {
      this.alertService.warning('Something went wrong');
      })
  }

  edit_customer_data(data){
    this.alertService.info('still under development');
    // let packagedata = {'newdata': data, 'original' : this.selectedCustomer};
    // this.http.post(environment.backendUrl + environment.editCustomer, packagedata).subscribe(res => {
    //   this.alertService.success('Success');
    //   this.getAllCustomer();
    //   },
    //   error1 => {
    //   if(error1['status'] == 406){
    //     this.alertService.warning('Can\'t edit the customer data')
    //   }else{
    //     this.alertService.danger('Something wrong, please try is later')
    //   }
    //   });
  }
}
