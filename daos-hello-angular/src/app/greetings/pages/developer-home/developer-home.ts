import { Component } from '@angular/core';
import { signal, WritableSignal } from '@angular/core';
import { DeveloperRegistration } from '../../components/developer-registration/developer-registration';
import { DeveloperGreeting } from '../../components/developer-greeting/developer-greeting';
import { Developer } from '../../model/developer.entity';

@Component({
  selector: 'app-developer-home',
  imports: [DeveloperRegistration, DeveloperGreeting],
  templateUrl: './developer-home.html',
  styleUrl: './developer-home.css'
})
export class DeveloperHome {
  public developer: WritableSignal<Developer>;
  public language: WritableSignal<string>;

  constructor() {
    this.developer = signal(new Developer());
    this.language = signal('');
  }

  public updateRegisteredDeveloper(developer: Developer, language: string): void {
    this.developer.set(developer);
    this.language.set(language);
  }
  public resetRegisteredDeveloper(): void {
    /*this.developer = signal(new Developer());
    this.language = signal('');*/
    this.developer.set(new Developer());
    this.language.set('');
  }

}









