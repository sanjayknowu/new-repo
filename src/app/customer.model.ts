export class Customer{

	
	firstname:string;
	lastname:string;
	state:string;
	country:string;
	order:[
	{ 
		orderId:string;
		itemname:string;
		quantity:string;
		price:string;
	}
	];
	
}