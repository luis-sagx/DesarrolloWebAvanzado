import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-products',
  imports: [CommonModule  ],
  templateUrl: './products.html',
  styleUrl: './products.css'
})
export class Products {
  protected products = [
    { id: 1, name: 'Product 1', price: 100 },
    { id: 2, name: 'Product 2', price: 200 },
    { id: 3, name: 'Product 3', price: 300 }
  ]; 

  protected selectedProduct: any = null;
  protected index = 0;

  protected showSelectedProduct(index : number): void {
    this.selectedProduct = this.products[index]; 
  }
}
