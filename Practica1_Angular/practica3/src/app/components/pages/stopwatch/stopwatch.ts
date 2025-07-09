import { Component, OnDestroy, signal, effect } from '@angular/core';

@Component({
  selector: 'app-stopwatch',
  standalone: true,
  imports: [],
  templateUrl: './stopwatch.html',
  styleUrl: './stopwatch.css'
})
export class Stopwatch implements OnDestroy {
  elapsedMs = signal(0); // Tiempo transcurrido en milisegundos
  running = signal(false);
  private intervalId: any;

  constructor() {
    effect(() => {
      if (this.running()) {
        this.intervalId = setInterval(() => {
          this.elapsedMs.update(ms => ms + 10); // cada 10 ms
        }, 10);
      } else {
        clearInterval(this.intervalId);
      }
    });
  }

  get formattedTime(): string {
    const ms = this.elapsedMs();
    const minutes = Math.floor(ms / 60000).toString().padStart(2, '0');
    const seconds = Math.floor((ms % 60000) / 1000).toString().padStart(2, '0');
    const centiseconds = Math.floor((ms % 1000) / 10).toString().padStart(2, '0');
    return `${minutes}:${seconds}.${centiseconds}`;
  }

  start() {
    this.running.set(true);
  }

  pause() {
    this.running.set(false);
  }

  reset() {
    this.running.set(false);
    this.elapsedMs.set(0);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }
}