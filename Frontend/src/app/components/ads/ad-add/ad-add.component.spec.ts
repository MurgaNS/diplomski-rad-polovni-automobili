import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdAddComponent } from './ad-add.component';

describe('AdAddComponent', () => {
  let component: AdAddComponent;
  let fixture: ComponentFixture<AdAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
