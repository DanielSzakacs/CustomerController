import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CutomerpageComponent } from './cutomerpage/cutomerpage.component';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { FormsModule } from '@angular/forms'


@NgModule({
  declarations: [
    AppComponent,
    CutomerpageComponent
  ],
  imports: [
    BrowserModule,
    ScrollingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
