import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { Role } from './models/role.enum';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { GuardsGuard } from './pages/guards.guard';
import { LoginComponent } from './pages/login/login.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { ShipmentRegisterationComponent } from './pages/shipment-registeration/shipment-registeration.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UnauthorizedComponent } from './pages/unauthorized/unauthorized.component';
import { UserDashboardComponent } from './pages/user-dashboard/user-dashboard.component';

const routes: Routes = [

  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent, canActivate: [GuardsGuard], data: { roles: [Role.ADMIN] } },
  { path: 'user-dashboard', component: UserDashboardComponent, canActivate: [GuardsGuard], data: { roles: [Role.USER] } },
  { path: 'createshipment', component: ShipmentRegisterationComponent, canActivate: [GuardsGuard], data: { roles: [Role.ADMIN] } },
  { path: '404', component: NotFoundComponent },
  { path: '401', component: UnauthorizedComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  constructor(private router: Router) {
    this.router.errorHandler = (error: any) => {
      this.router.navigate(['404']);
    }

  }


 }
