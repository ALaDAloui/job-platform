import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatListfavoriteComponent } from './candidat-listfavorite.component';

describe('CandidatListfavoriteComponent', () => {
  let component: CandidatListfavoriteComponent;
  let fixture: ComponentFixture<CandidatListfavoriteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatListfavoriteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatListfavoriteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
