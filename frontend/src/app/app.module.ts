// app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: FirstComponent},
      // { path: 'first-page', component: FirstComponent },
      { path: 'login', component: LoginComponent },
      // { path: '**', component: 404Component }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
