import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-message',
  imports: [],
  templateUrl: './message.html',
  styleUrl: './message.css'
})

export class Message {
  @Input() name: string = 'Luis';
  message: string = '¡Bienvenido a Angular!';

  changeMessage() {
    this.message = '¡mensaje cambiado!';
  }

  changeMessageWithTime(){
    const currentTime = new Date();
    this.message = `¡mensaje cambiado a las ${currentTime.getHours()}:${currentTime.getMinutes()}:${currentTime.getSeconds()}!`;
  }
  
  changeMessageWithDate(){
    const currentTime = new Date();
    this.message = `La fecha es ${currentTime.getDate()}/${currentTime.getMonth()+1}/${currentTime.getFullYear()}! 
      La hora es ${currentTime.getHours()}:${currentTime.getMinutes()}:${currentTime.getSeconds()}!`;
  }


}
