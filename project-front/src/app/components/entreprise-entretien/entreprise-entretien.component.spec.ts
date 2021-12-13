import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseEntretienComponent } from './entreprise-entretien.component';

describe('EntrepriseEntretienComponent', () => {
  let component: EntrepriseEntretienComponent;
  let fixture: ComponentFixture<EntrepriseEntretienComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseEntretienComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseEntretienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
