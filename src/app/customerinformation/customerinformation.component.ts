import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router'
import { DataService } from '../data.service';
// import { CUSTOMERS } from "../customer";
import { Customer } from "../customer.model";
@Component({
  selector: 'app-customerinformation',
  templateUrl: './customerinformation.component.html',
  styleUrls: ['./customerinformation.component.css']
})
export class CustomerinformationComponent implements OnInit {

  constructor(private router:Router, private rout:ActivatedRoute, private data:DataService) { }

  id1:string;
  customer:any=Customer;
  
  showCustomer(){
    
    this.id1= this.rout.snapshot.params.id;
    this.data.getDataById(this.id1).subscribe(res=>{
      this.customer=res;
    });
    console.log(this.id1);
    console.log(this.customer);
  }

  


edit(id){
	this.router.navigate(["/customers/add-customer", {id}]);
}

  ngOnInit() {
  	
  	this.showCustomer();
  }

}
