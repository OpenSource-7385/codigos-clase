import { Component } from '@angular/core';
import { output, OutputEmitterRef } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Developer } from '../../model/developer.entity';

@Component({
  selector: 'app-developer-registration',
  imports: [ReactiveFormsModule],
  templateUrl: './developer-registration.html',
  styleUrl: './developer-registration.css'
})
export class DeveloperRegistration {
  public registerDeveloper = output<{developer: Developer, language: string}>();
  public dropDeveloper: OutputEmitterRef<void> = output<void>();

  public developerFormGroup = new FormGroup({
    firstNameFC: new FormControl('', [Validators.required, Validators.minLength(2)]),
    lastNameFC: new FormControl('', [Validators.required, Validators.minLength(2)]),
    languageFC: new FormControl('', [Validators.required, Validators.minLength(2)])
  });

  public submitRegistrationRequest(): void {
    if (this.developerFormGroup.valid) {
      const firstName = this.developerFormGroup.value.firstNameFC?.valueOf() ?? '';
      const lastName = this.developerFormGroup.value.lastNameFC?.valueOf() ?? '';
      const language = this.developerFormGroup.value.languageFC?.valueOf() ?? '';
      const developer = new Developer(firstName, lastName);

      this.registerDeveloper.emit({ developer, language });
      this.developerFormGroup.reset();
    }
  }

  public dropRegistration(): void {
    this.dropDeveloper.emit();
    this.developerFormGroup.reset();
  }

  public clearForm(): void {
    this.developerFormGroup.reset();
  }
}
