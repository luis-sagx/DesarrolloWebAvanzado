import { Routes } from '@angular/router';
import { Car } from './car/car';
import { Message } from './message/message';
import { Counter } from './counter/counter';

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
    path: 'contador',
    component: Counter
  },
  {
    path: '**',
    redirectTo: 'mensaje'
  }
];
