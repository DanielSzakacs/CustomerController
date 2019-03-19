import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CutomerpageComponent } from './cutomerpage.component';

describe('CutomerpageComponent', () => {
  let component: CutomerpageComponent;
  let fixture: ComponentFixture<CutomerpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CutomerpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CutomerpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
