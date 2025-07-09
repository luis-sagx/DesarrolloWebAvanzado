import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-speed-controls',
  standalone: true,
  imports: [],
  templateUrl: './speed-controls.html',
  styleUrl: './speed-controls.css'
})
export class SpeedControls {
  @Output() accelerate = new EventEmitter<void>();
  @Output() brake = new EventEmitter<void>();
  @Output() reset = new EventEmitter<void>();
}
