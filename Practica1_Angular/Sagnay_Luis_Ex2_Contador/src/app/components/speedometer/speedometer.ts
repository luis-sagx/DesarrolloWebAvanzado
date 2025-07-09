import { Component, signal, computed } from '@angular/core';
import { SpeedControls } from '../ui/speed-controls/speed-controls';
import { SpeedDisplay } from '../ui/speed-display/speed-display';

@Component({
  selector: 'app-speedometer',
  standalone: true,
  imports: [SpeedControls, SpeedDisplay],
  templateUrl: './speedometer.html',
  styleUrl: './speedometer.css'
})
export class Speedometer {
  speed = signal(0);

  speedClass = computed(() => {
    const value = this.speed();
    if (value <= 30) return 'low-speed';
    if (value <= 70) return 'medium-speed';
    if (value <= 120) return 'high-speed';
    return 'danger-speed';
  });

  accelerate() {
    this.speed.update(value => Math.min(400, value + 5));
  }


  brake() {
    this.speed.update(value => Math.max(0, value - 3));
  }

  reset() {
    this.speed.set(0);
  }

  showWarning = computed(() => this.speed() >= 400);
}

