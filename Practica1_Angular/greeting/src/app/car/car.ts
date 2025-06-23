import { Component } from '@angular/core';

@Component({
  selector: 'app-car',
  templateUrl: './car.html',
  styleUrls: ['./car.css']
})
export class Car {
  protected cars = [
    {
      title: 'Auto 1',
      brand: 'Porsche',
      model: '911',
      year: 2021,
      description: 'Un coche deportivo veloz y eficiente.'
    },
    {
      title: 'Auto 2',
      brand: 'Ford',
      model: 'Mustang',
      year: 2020,
      description: 'Un auto deportivo de alto rendimiento.'
    },
    {
      title: 'Auto 3',
      brand: 'Honda',
      model: 'Civic',
      year: 2022,
      description: 'Un sedán confiable y moderno.'
    },
    {
      title: 'Auto 4',
      brand: 'Chevrolet',
      model: 'Camaro',
      year: 2019,
      description: 'Un auto deportivo clásico y potente.'
    }
  ];

  protected selectedCar = this.cars[0];

  selectCar(index: number): void {
    this.selectedCar = this.cars[index];
  }
}
