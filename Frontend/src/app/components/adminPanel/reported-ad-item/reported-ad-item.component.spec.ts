import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportedAdItemComponent } from './reported-ad-item.component';

describe('ReportedAdItemComponent', () => {
  let component: ReportedAdItemComponent;
  let fixture: ComponentFixture<ReportedAdItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportedAdItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReportedAdItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
