import { Language } from './language';

export class VocabularyPair {
  logosA: string;
  logosALanguage: Language;
  logosB: string;
  logosBLanguage: Language;

  constructor(
    logosA: string,
    logosALanguage: Language,
    logosB: string,
    logosBLanguage: Language
  ) {
    this.logosA = logosA;
    this.logosALanguage = logosALanguage;
    this.logosB = logosB;
    this.logosBLanguage = logosBLanguage;
  }
}
