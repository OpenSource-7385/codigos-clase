import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DeveloperHome} from './greetings/pages/developer-home/developer-home';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, DeveloperHome],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Developer');
}
