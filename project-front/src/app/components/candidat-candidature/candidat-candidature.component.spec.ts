import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatCandidatureComponent } from './candidat-candidature.component';

describe('CandidatCandidatureComponent', () => {
  let component: CandidatCandidatureComponent;
  let fixture: ComponentFixture<CandidatCandidatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatCandidatureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatCandidatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
