import { Routes } from '@angular/router';
import { Speedometer } from './components/speedometer/speedometer';

export const routes: Routes = [
    {
        path: '',
        component: Speedometer
    },
    {
        path: '**',
        redirectTo: '',
    }
];
