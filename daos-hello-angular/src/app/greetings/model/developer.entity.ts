export class Developer {
  private readonly _firstName: string;
  private readonly _lastName: string;

  constructor(firstName?: string, lastName?: string) {
    this._firstName = firstName?.trim() ?? '';
    this._lastName = lastName?.trim() ?? '';
  }
  get fullName(): string {
    return `${this._firstName} ${this._lastName}`.trim();
  }
  isEmpty(): boolean {
    return this._firstName === '' && this._lastName === '';
  }
}
