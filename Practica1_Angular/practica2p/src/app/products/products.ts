import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Card } from '../card/card';

@Component({
  selector: 'app-products',
  imports: [CommonModule, Card],
  templateUrl: './products.html',
  styleUrl: './products.css'
})
export class Products {
  protected productos = [
    {
      id: 1,
      title: 'Product 1',
      description: 'Description for Product 1',
      price: 100
    },
    {
      id: 2,
      title: 'Product 2',
      description: 'Description for Product 2',
      price: 200
    },
    {
      id: 3,
      title: 'Product 3',
      description: 'Description for Product 3',
      price: 300
    }
  ]
}
