import { Component, Input } from '@angular/core';
import { NgClass } from '@angular/common'; 

@Component({
  selector: 'app-speed-display',
  standalone:true,
  imports: [NgClass],
  templateUrl: './speed-display.html',
  styleUrl: './speed-display.css'
})
export class SpeedDisplay {
  @Input() speed: number = 0;
  @Input() speedClass: string = 'low-speed';
}
