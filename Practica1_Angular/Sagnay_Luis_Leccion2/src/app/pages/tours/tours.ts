import { Component } from '@angular/core';
import { signal } from '@angular/core';
import { CardTours } from '../../ui/card-tours/card-tours';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tours',
  standalone: true,
  imports: [CardTours, CommonModule],
  templateUrl: './tours.html',
  styleUrl: './tours.css'
})
export class Tours {
  readonly tours = signal([
    {
      title: 'Aventura en Ecuador dentro de la Selva Amazónica',
      description: 'Explora la biodiversidad única con guías expertos durante 3 días.',
      image: 'https://www.enciclopediadelecuador.com/wp-content/uploads/2023/09/Descubre-los-lugares-turisticos-de-la-Amazonia.jpg',
      price: '$444'
    },
    {
      title: 'Tour por las principales Islas de las Islas Galápagos',
      description: 'Crucero de lujo visitando las islas más emblemáticas del archipiélago.',
      image: 'https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic2714870_0.jpg?w=1900&h=1269',
      price: '$999'
    },
    {
      title: 'Escalar los Andes Ecuatorianos en equipos',
      description: 'Recorrido cultural por pueblos andinos escalando con tu grupo por la montaña.',
      image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrNCkKaN5gIWHuVeCp1UN1C-tbYa2RQNEy_Q&s',
      price: '$333'
    },
    {
      title: 'Ruta del Cacao y Cultura en la Costa Ecuatoriana',
      description: 'Vive la experiencia del chocolate artesanal y visita haciendas tradicionales en un tour de 2 días.',
      image: 'https://grandsur.com/wp-content/uploads/2021/02/GrandSur-Our-Products-ASSS.jpg',
      price: '$299'
    },
    {
      title: 'Aventura Mística en la Laguna de Quilotoa',
      description: 'Caminata escénica y navegación por la laguna volcánica más impresionante de los Andes.',
      image: 'https://upload.wikimedia.org/wikipedia/commons/2/29/Panorama_quilotoa_crater_lake_ecuador.jpg',
      price: '$249'
    },
    {
      title: 'Tour Gastronómico y Patrimonial en Cuenca',
      description: 'Degusta lo mejor de la cocina andina mientras descubres el centro histórico de Cuenca, Patrimonio de la Humanidad.',
      image: 'https://besttripecuador.com/wp-content/uploads/2022/03/1.Cuenca-portada-vf.jpg',
      price: '$199'
    }

  ]);
}
