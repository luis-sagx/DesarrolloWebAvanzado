import { Component } from '@angular/core';
import { signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardTestimonials } from '../../ui/card-testimonials/card-testimonials';

@Component({
  selector: 'app-testimonials',
  standalone: true,
  imports: [CardTestimonials, CommonModule],
  templateUrl: './testimonials.html',
  styleUrl: './testimonials.css'
})
export class Testimonials {
  readonly testimonials = signal([
    {
      name: 'Carlos Pérez',
      location: 'Quito, Ecuador',
      comment: '¡Una experiencia inolvidable! Muy bien organizado.',
    },
    {
      name: 'Lucía Gómez',
      location: 'Guayaquil, Ecuador',
      comment: 'Los guías fueron súper atentos. ¡Repetiría sin duda!',
    },
    {
      name: 'Andrés Torres',
      location: 'Cuenca, Ecuador',
      comment: 'Me encantó el tour por Galápagos. Todo excelente.',
    },
    {
      name: 'María López',
      location: 'Manta, Ecuador',
      comment: 'Un viaje increíble, lleno de aventuras y paisajes hermosos.',
    },
    {
      name: 'Sofía Martínez',
      location: 'Quito, Ecuador',
      comment: 'La atención al cliente fue excepcional. Muy recomendados.',
    },
    {
      name: 'Diego Ramírez',
      location: 'Ambato, Ecuador',
      comment: 'Los tours son muy completos y bien planificados. ¡Gracias!',
    }
  ]);
}
