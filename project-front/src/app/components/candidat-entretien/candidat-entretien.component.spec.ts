import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatEntretienComponent } from './candidat-entretien.component';

describe('CandidatEntretienComponent', () => {
  let component: CandidatEntretienComponent;
  let fixture: ComponentFixture<CandidatEntretienComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatEntretienComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatEntretienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
