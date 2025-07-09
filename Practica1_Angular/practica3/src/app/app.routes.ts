import { Routes } from '@angular/router';
import { Alarm } from './components/pages/alarm/alarm';
import { Home } from './components/pages/home/home';
import { Stopwatch } from './components/pages/stopwatch/stopwatch';
import { Timer } from './components/pages/timer/timer';
import { Clock } from './components/pages/clock/clock';
import { World } from './components/pages/clock/world/world';


export const routes: Routes = [
    {
        path: '',
        component: Home,    
    },
    {
        path: 'alarm',
        component: Alarm,
    },
    {
        path: 'stopwatch',
        component: Stopwatch,
    },
    {
        path: 'timer',
        component: Timer,
    },
    {
        path: 'clock',
        component: Clock,
    },
    {
        path: 'clock/world/:zona',
        component: World,
    },
    {
        path: '**',
        redirectTo: '',
    }
];
