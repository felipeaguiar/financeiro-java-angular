import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthRoutingModule } from './auth-routing.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RecoverComponent } from './recover/recover.component';
import { AuthWrapperComponent } from './auth-wrapper/auth-wrapper.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    RecoverComponent,
    AuthWrapperComponent
  ],
  imports: [
    AuthRoutingModule,
    CommonModule
  ]
})
export class AuthModule { }
