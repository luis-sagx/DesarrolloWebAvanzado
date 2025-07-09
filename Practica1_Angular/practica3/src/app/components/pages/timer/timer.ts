import { Component, signal, effect, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-timer',
  imports: [],
  templateUrl: './timer.html',
  styleUrl: './timer.css',
})
export class Timer implements OnDestroy {
  inputMinutes = signal(0);
  inputSeconds = signal(0);
  remainingMs = signal(0);
  running = signal(false);
  finished = signal(false);

  private intervalId: any;

  constructor() {
    effect(() => {
      if (this.running()) {
        this.intervalId = setInterval(() => {
          const newTime = this.remainingMs() - 1000;
          if (newTime <= 0) {
            this.remainingMs.set(0);
            this.running.set(false);
            this.finished.set(true);
            clearInterval(this.intervalId);
          } else {
            this.remainingMs.set(newTime);
          }
        }, 1000);
      } else {
        clearInterval(this.intervalId);
      }
    });
  }

  get formattedTime(): string {
    const totalMs = this.remainingMs();
    const minutes = Math.floor(totalMs / 60000).toString().padStart(2, '0');
    const seconds = Math.floor((totalMs % 60000) / 1000).toString().padStart(2, '0');
    return `${minutes}:${seconds}`;
  }

  startTimer(): void {
    const totalMs = (this.inputMinutes() * 60 + this.inputSeconds()) * 1000;
    if (totalMs > 0) {
      this.remainingMs.set(totalMs);
      this.running.set(true);
      this.finished.set(false);
    }
  }

  pauseTimer(): void {
    this.running.set(false);
  }

  resetTimer(): void {
    this.running.set(false);
    this.finished.set(false);
    this.remainingMs.set(0);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }
}