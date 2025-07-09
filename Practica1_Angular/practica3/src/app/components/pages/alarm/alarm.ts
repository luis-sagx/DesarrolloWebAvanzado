import { Component, OnInit, OnDestroy, signal, computed, effect } from '@angular/core';

@Component({
  selector: 'app-alarm',
  standalone: true,
  imports: [],
  templateUrl: './alarm.html',
  styleUrl: './alarm.css'
})
export class Alarm implements OnInit, OnDestroy {

  currentTime = signal(this.getCurrentTime());
  alarmTime = signal('');
  alarmActive = signal(false);
  alarmTriggered = signal(false);

  private intervalId!: number;

  ngOnInit(): void {
    this.intervalId = setInterval(() => {
      this.currentTime.set(this.getCurrentTime());

      if (this.alarmActive() && this.currentTime() === this.alarmTime()) {
        this.alarmTriggered.set(true);
      }
    }, 1000);

    // Optional: Reactive effect for debug
    effect(() => {
      if (this.alarmTriggered()) {
        console.log('⏰ Alarma activada!');
      }
    });
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }

  getCurrentTime(): string {
    const now = new Date();
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    return `${hours}:${minutes}`;
  }

  setAlarm(): void {
    if (this.alarmTime()) {
      this.alarmActive.set(true);
      this.alarmTriggered.set(false);
    }
  }

  clearAlarm(): void {
    this.alarmActive.set(false);
    this.alarmTriggered.set(false);
  }
}