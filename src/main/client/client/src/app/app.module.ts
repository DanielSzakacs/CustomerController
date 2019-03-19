import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CutomerpageComponent } from './customerpage/cutomerpage.component';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { FormsModule } from '@angular/forms'
import {HttpClientModule} from "@angular/common/http";
// Import BrowserAnimationsModule
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

// Import your library
import { AlertModule } from 'ngx-alerts';

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
    BrowserAnimationsModule,
    // Specify your library as an import
    AlertModule.forRoot({maxMessages: 5, timeout: 5000, position: 'right'})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
