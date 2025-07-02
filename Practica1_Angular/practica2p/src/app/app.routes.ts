import { Routes } from '@angular/router';
import { Home } from './home/home';
import { About } from './about/about';
import { Products } from './products/products';
import { Temporizator } from './temporizator/temporizator';

export const routes: Routes = [
    {
        path: 'home',
        component: Home,
    },
    {
        path: 'about',
        component: About,
    },
    {
        path: 'products',
        component: Products,
    }, 
    {
        path: 'temporizador',
        component: Temporizator,
    },
    {
        path: '**',
        redirectTo: '/home',
    }
];
