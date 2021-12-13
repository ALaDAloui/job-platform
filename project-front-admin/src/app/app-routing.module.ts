import { CategorieComponent } from './components/categorie/categorie.component';
import { EntrepriseOffreCandidatureComponent } from './components/entreprise-offre-candidature/entreprise-offre-candidature.component';
import { EntrepriseOffreComponent } from './components/entreprise-offre/entreprise-offre.component';
import { RegisterAdminComponent } from './components/register-admin/register-admin.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LayoutComponent } from './components/layout/layout.component';
import { LoginComponent } from './components/login/login.component';
import { EntrepriseComponent } from './components/entreprise/entreprise.component';
import { PdfComponent } from './components/pdf/pdf.component';

const routes: Routes = [
  {path:'pdf/:id',component:PdfComponent},
  {path:'',component:LoginComponent},
  {path:'register',component:RegisterAdminComponent},
    {path:'home',component:HomeComponent,children:[
    {path:'',component:LayoutComponent},
    {path:'entreprise',component:EntrepriseComponent},
    {path:'offre',component:EntrepriseOffreComponent},
    {path:'listcandidature/:id',component:EntrepriseOffreCandidatureComponent},
    {path:'categorie',component:CategorieComponent},




    ]}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
