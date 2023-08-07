import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InactiveAdsComponent } from './inactive-ads.component';

describe('InactiveAdsComponent', () => {
  let component: InactiveAdsComponent;
  let fixture: ComponentFixture<InactiveAdsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InactiveAdsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InactiveAdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
