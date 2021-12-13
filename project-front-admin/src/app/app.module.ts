import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LayoutComponent } from './components/layout/layout.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterAdminComponent } from './components/register-admin/register-admin.component';
import { EntrepriseComponent } from './components/entreprise/entreprise.component';
import { EntrepriseOffreComponent } from './components/entreprise-offre/entreprise-offre.component';
import { EntrepriseOffreCandidatureComponent } from './components/entreprise-offre-candidature/entreprise-offre-candidature.component';
import { CategorieComponent } from './components/categorie/categorie.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { PdfComponent } from './components/pdf/pdf.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    LayoutComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    RegisterAdminComponent,
    EntrepriseComponent,
    EntrepriseOffreComponent,
    EntrepriseOffreCandidatureComponent,
    CategorieComponent,
    PdfComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    PdfViewerModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
