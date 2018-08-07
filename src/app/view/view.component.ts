import { Component, OnInit } from '@angular/core';
import { Customer} from "../customer.model";
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { DataService } from '../data.service';
import { CustomersComponent } from '../customers/customers.component';
@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

	
	
  customerinfo:any;

  constructor(private router:Router, private rout:ActivatedRoute, private dataService:DataService) { }

  onClick(id){
  	this.router.navigate(['customerinformation', {id}]);
  }

  ngOnInit() {
  	this.dataService.getData().subscribe((res)=>{
      this.customerinfo=res;
      console.log(this.customerinfo);
    })
    
  }

}
