import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Contact } from './pages/contact/contact';
import { Tours } from './pages/tours/tours';
import { Testimonials } from './pages/testimonials/testimonials';

export const routes: Routes = [
    {
        path: 'home',
        component: Home,
    },
    {
        path: 'tours',
        component: Tours
    },
    {
        path: 'testimonials',
        component: Testimonials
    },
    {
        path: 'contact',
        component: Contact
    },
    {
        path: '**',
        redirectTo: '/home',
    }
];
