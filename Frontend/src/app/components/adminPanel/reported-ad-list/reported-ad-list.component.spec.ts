import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportedAdListComponent } from './reported-ad-list.component';

describe('ReportedAdListComponent', () => {
  let component: ReportedAdListComponent;
  let fixture: ComponentFixture<ReportedAdListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportedAdListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReportedAdListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
