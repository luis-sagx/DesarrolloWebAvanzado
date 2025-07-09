import { Component, signal, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clock',
  imports: [],
  templateUrl: './clock.html',
  styleUrl: './clock.css'
})
export class Clock implements OnInit, OnDestroy {
  localTime = signal(this.getCurrentTime());
  private intervalId: any;

  worldClocks = [
    { name: 'Nueva York', offset: -4 },
    { name: 'Londres', offset: 0 },
    { name: 'Tokio', offset: 9 },
    { name: 'Buenos Aires', offset: -3 }
  ];

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.intervalId = setInterval(() => {
      this.localTime.set(this.getCurrentTime());
    }, 1000);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }

  getCurrentTime(): string {
    const now = new Date();
    return now.toLocaleTimeString();
  }

  verZona(zona: string): void {
    this.router.navigate(['/clock/world', zona.toLowerCase()]);
  }
}