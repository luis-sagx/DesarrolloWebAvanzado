import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-card-testimonials',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-testimonials.html',
  styleUrl: './card-testimonials.css'
})
export class CardTestimonials {
  @Input() name!: string;
  @Input() comment!: string;
  @Input() location!: string;
}
