import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { CustomersComponent } from '../customers/customers.component';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'app-listview',
  templateUrl: './listview.component.html',
  styleUrls: ['./listview.component.css']
})
export class ListviewComponent implements OnInit {

customerinfo:any;

  constructor( private dataService:DataService, private router:Router) { }

  deleteCustomer(id){
  		console.log(id);
  		this.dataService.deleteCustomerById(id).subscribe((res)=>{
  			this.customerinfo=res;
  			console.log(this.customerinfo);

  		});
  }
  edit(id){
  	this.router.navigate(['/customers/add-customer', {id}]);
  }

  details(id){
  	this.router.navigate(['customerinformation', {id}]);
  }

  ngOnInit() {
  	this.dataService.getData().subscribe((res)=>{
      this.customerinfo=res;
      console.log(this.customerinfo);

  });

}
}
