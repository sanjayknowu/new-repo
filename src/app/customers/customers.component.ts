import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer.model';
import { ActivatedRoute, Router } from '@angular/router';
// import { DataService } from '../data.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
 
  constructor(private router:Router,private rout:ActivatedRoute) { }

 
  ngOnInit() {
  	//this.router.navigate(['/customers/view']);

  	//
  }


  

}
