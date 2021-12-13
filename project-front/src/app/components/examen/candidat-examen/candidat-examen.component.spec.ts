import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatExamenComponent } from './candidat-examen.component';

describe('CandidatExamenComponent', () => {
  let component: CandidatExamenComponent;
  let fixture: ComponentFixture<CandidatExamenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatExamenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
