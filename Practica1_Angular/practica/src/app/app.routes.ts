import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Products } from './products/products';

export const routes: Routes = [
    {
        path: 'home',
        component: Home,
    },
    {
        path: 'products',
        component: Products,
    },
    {
        path: '**',
        redirectTo: '/home',
    }
];
