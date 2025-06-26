import { Routes } from '@angular/router';
import { Car } from './car/car';
import { Message } from './message/message';

export const routes: Routes = [
  {
    path: '',
    component: Message,
  },
  {
    path: 'vehiculo',
    component: Car
  },
  {
    path: '**',
    redirectTo: 'mensaje'
  }
];
