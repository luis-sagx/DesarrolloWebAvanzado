import { Component, signal, computed } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './contact.html',
})
export class Contact {
  name = signal('');
  email = signal('');
  message = signal('');

  messageLength = computed(() => this.message().length);

  onSubmit() {
    if (!this.name() || !this.email() || !this.message()) {
      alert('Por favor, completa todos los campos.');
      return;
    }

    console.log('Formulario enviado:', {
      nombre: this.name(),
      correo: this.email(),
      mensaje: this.message(),
    });

    alert('¡Gracias por tu mensaje!');

    this.name.set('');
    this.email.set('');
    this.message.set('');
  }
}
