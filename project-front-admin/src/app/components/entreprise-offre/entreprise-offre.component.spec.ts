import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseOffreComponent } from './entreprise-offre.component';

describe('EntrepriseOffreComponent', () => {
  let component: EntrepriseOffreComponent;
  let fixture: ComponentFixture<EntrepriseOffreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseOffreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
