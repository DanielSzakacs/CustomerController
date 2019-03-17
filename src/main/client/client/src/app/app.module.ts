import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CutomerpageComponent } from './cutomerpage/cutomerpage.component';

@NgModule({
  declarations: [
    AppComponent,
    CutomerpageComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
