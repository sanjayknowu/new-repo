import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer.model';
import { DataService} from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

	id:string;
	
	newCustomer:Customer={
		 firstname:'', lastname:'', state:'', country:'', order:[{orderId:'', itemname:'', quantity:'', price:''}]
	}
    editNewCustomer:any;

  constructor(private data:DataService, private router:Router, private rout:ActivatedRoute) { }

  onSubmit(){
		this.data.saveCustomer(this.newCustomer).subscribe(res=>{this.router.navigate(['../view'],{ relativeTo: this.rout });});
		

	}

	 editCustomer(){
		
	 	this.id=this.rout.snapshot.params['id'];
	 	console.log(this.id);

		this.data.getDataById(this.id).subscribe(res=>{

	 		console.log("before");
	 		this.editNewCustomer=res;
	 		console.log(this.editNewCustomer);
			console.log("after");

	 		this.newCustomer.firstname=this.editNewCustomer.firstname;
	 		this.newCustomer.lastname=this.editNewCustomer.lastname;
	 		this.newCustomer.state=this.editNewCustomer.state;
	 		this.newCustomer.country=this.editNewCustomer.country;
	 	});
  
	 }
  
  onEdit(){
   

   	        this.editNewCustomer.firstname=this.newCustomer.firstname;
	 		this.editNewCustomer.lastname=this.newCustomer.lastname;
	 		this.editNewCustomer.state=this.newCustomer.state;
	 		this.editNewCustomer.country=this.newCustomer.country;
	 	this.data.saveCustomer(this.editNewCustomer).subscribe(res=>{this.router.navigate(['../view'],{ relativeTo: this.rout });});
		//this.router.navigate(['../view'],{ relativeTo: this.rout });

   }

  ngOnInit() {
   this.editCustomer();
  }

}
