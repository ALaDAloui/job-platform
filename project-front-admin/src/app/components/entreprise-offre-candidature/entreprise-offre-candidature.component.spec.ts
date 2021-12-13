import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseOffreCandidatureComponent } from './entreprise-offre-candidature.component';

describe('EntrepriseOffreCandidatureComponent', () => {
  let component: EntrepriseOffreCandidatureComponent;
  let fixture: ComponentFixture<EntrepriseOffreCandidatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseOffreCandidatureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseOffreCandidatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
