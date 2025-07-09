import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { signal } from '@angular/core';

@Component({
  selector: 'app-world',
  imports: [],
  templateUrl: './world.html',
  styleUrl: './world.css'
})
export class World implements OnInit {
  zona = signal('');
  hora = signal('');
  diferencia = signal('');

  private WORLD_CLOCKS = [
    { name: 'Nueva York', offset: -4 },
    { name: 'Londres', offset: 0 },
    { name: 'Tokio', offset: 9 },
    { name: 'Buenos Aires', offset: -3 }
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const param = this.route.snapshot.paramMap.get('zona');

    const zonaInfo = this.WORLD_CLOCKS.find(z => z.name.toLowerCase() === param?.toLowerCase());

    if (zonaInfo) {
      this.zona.set(zonaInfo.name);
      this.hora.set(this.getHoraEnZona(zonaInfo.offset));
      this.diferencia.set(this.getDiferencia(zonaInfo.offset));

      setInterval(() => {
        this.hora.set(this.getHoraEnZona(zonaInfo.offset));
      }, 1000);
    }
  }

  getHoraEnZona(offset: number): string {
    const localDate = new Date();
    const utc = localDate.getTime() + localDate.getTimezoneOffset() * 60000;
    const ciudadDate = new Date(utc + 3600000 * offset);
    return ciudadDate.toLocaleTimeString();
  }

  getDiferencia(offset: number): string {
    const localOffset = -new Date().getTimezoneOffset() / 60;
    const diff = offset - localOffset;
    const signo = diff >= 0 ? '+' : '-';
    return `${signo}${Math.abs(diff)} horas`;
  }
}
