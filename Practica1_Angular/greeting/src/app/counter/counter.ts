import { Component, signal, ChangeDetectionStrategy, computed, effect } from '@angular/core';

@Component({
  selector: 'app-counter',
  imports: [],
  templateUrl: './counter.html',
  styleUrl: './counter.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class Counter {
  count = 0;

  countSignal = signal(0);

  countComputed = computed(() => {
    return this.countSignal() * 2;
  });

  //explicacion del computed
  //El computed es una función que se ejecuta cada vez que se actualiza el valor
  //de la señal countSignal. En este caso, multiplica el valor de countSignal por 2
  //y devuelve el resultado. Esto permite que el valor de countComputed se actualice

  constructor(){
    effect(() => {
      if(this.countSignal() > 10) {
        console.warn('Count Signal is greater than 10:', this.countSignal());
      }
    });
  }

  add(){
    this.count++;
    this.countSignal.update((actual) => actual + 1);
  }

  subtract(){
    this.count--;
    this.countSignal.update((actual) => actual - 1);
  }

  reset(){
    this.count = 0;
    this.countSignal.set(0);
  }
}
