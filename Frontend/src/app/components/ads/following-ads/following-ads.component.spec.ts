import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowingAdsComponent } from './following-ads.component';

describe('FollowingAdsComponent', () => {
  let component: FollowingAdsComponent;
  let fixture: ComponentFixture<FollowingAdsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FollowingAdsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FollowingAdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
