import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-temporizator',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './temporizator.html',
  styleUrls: ['./temporizator.css']
})
export class Temporizator {
  time = signal(0);
  chronometer = signal(0);

  private timer: any = null;
  private chrono: any = null;

  startTimer() {
    this.stopAll();
    if (this.time() > 0) {
      this.timer = setInterval(() => {
        if (this.time() > 0) {
          this.time.update(v => v - 1);
        } else {
          this.stopAll();
        }
      }, 1000);
    }
  }

  startChronometer() {
    this.stopAll();
    this.chrono = setInterval(() => {
      this.chronometer.update(v => v + 1);
    }, 1000);
  }

  stopAll() {
    if (this.timer) {
      clearInterval(this.timer);
      this.timer = null;
    }
    if (this.chrono) {
      clearInterval(this.chrono);
      this.chrono = null;
    }
  }

  resetTimer() {
    this.stopAll();
    this.time.set(0);
  }

  resetChronometer() {
    this.stopAll();
    this.chronometer.set(0);
  }
}
