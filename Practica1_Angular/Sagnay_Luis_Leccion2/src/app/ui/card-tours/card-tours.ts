import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-card-tours',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-tours.html',
  styleUrl: './card-tours.css'
})
export class CardTours {
  @Input() title!: string;
  @Input() description!: string;
  @Input() image!: string;
  @Input() price!: string;
}
