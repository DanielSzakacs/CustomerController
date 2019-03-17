import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cutomerpage',
  templateUrl: './cutomerpage.component.html',
  styleUrls: ['./cutomerpage.component.css']
})
export class CutomerpageComponent implements OnInit {
  numbers: number[] = [];
  constructor() {
    for (let index = 0; index < 10000; index++) {
      this.numbers.push(index);
    }
  }

  ngOnInit() {
  }

}
