import { Component } from '@angular/core';
import { computed, Signal } from '@angular/core';
import { input, InputSignal } from '@angular/core';
import { Developer } from '../../model/developer.entity';

@Component({
  selector: 'app-developer-greeting',
  imports: [],
  templateUrl: './developer-greeting.html',
  styleUrl: './developer-greeting.css'
})
export class DeveloperGreeting {
  public developer: InputSignal<Developer> = input.required<Developer>();
  public language =  input.required<string>();

  readonly fullName: Signal<string> = computed((): string => {
    if (this.developer().isEmpty() && this.language().trim() == '')
      return 'Anonymous Developer';
    return `${this.developer().fullName}`;
  });

  readonly isRegistered = computed(() =>
    !this.developer().isEmpty() && this.language().trim() !== ''
  );
}










