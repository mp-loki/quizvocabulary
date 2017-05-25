export class Language {
  name: string;
  code: string;

  public toString = (): string => {
    return JSON.stringify(this);
  }
}
