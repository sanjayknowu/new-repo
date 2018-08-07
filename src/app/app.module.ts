import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Routes, RouterModule} from "@angular/router";
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { CustomersComponent } from './customers/customers.component';
import { OrdersComponent } from './orders/orders.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { ViewComponent } from './view/view.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { DataService } from './data.service';
import { ListviewComponent } from './listview/listview.component';
import { CustomerinformationComponent } from './customerinformation/customerinformation.component';

const approute: Routes=[
{
  path:'customers', component:CustomersComponent,
  children: [ 
      {
    path: 'view',   component: ViewComponent
      },

      {
    path:'add-customer', component:AddCustomerComponent
      },
      {
    path:'listview', component:ListviewComponent
      }

      ]
  
},

// {path:'customers/add-customer',component:AddCustomerComponent},

{
  path:'about', component:AboutComponent
},
{
  path:'login', component:LoginComponent
},
{
  path:'orders', component:OrdersComponent
},
{
  path:'customerinformation', component:CustomerinformationComponent
},

{
  path: '', redirectTo: '/customers', pathMatch: 'full'
},
{
  path: '**', component:CustomersComponent
}
];




  





@NgModule({

  declarations: [
    AppComponent,
    CustomersComponent,
    OrdersComponent,
    AboutComponent,
    LoginComponent,
    ViewComponent,
    AddCustomerComponent,
    ListviewComponent,
    CustomerinformationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(approute),
    
  ],

  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
