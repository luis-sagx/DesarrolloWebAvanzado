import { Component } from '@angular/core';
import { Saludo } from './saludo/saludo';
import { Card } from './card/card';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Saludo, Card],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'mi-app';
}
