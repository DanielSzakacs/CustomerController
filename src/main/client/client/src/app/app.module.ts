import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CutomerpageComponent } from './customerpage/cutomerpage.component';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { FormsModule } from '@angular/forms'
import {HttpClientModule} from "@angular/common/http";
import {AlertsModule} from "angular-alert-module";

@NgModule({
  declarations: [
    AppComponent,
    CutomerpageComponent
  ],
  imports: [
    BrowserModule,
    ScrollingModule,
    FormsModule,
    HttpClientModule,
    AlertsModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
