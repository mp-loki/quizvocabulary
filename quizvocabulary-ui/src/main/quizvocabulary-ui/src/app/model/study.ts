import { Board } from './board';
import { Language } from './language';

export class Study {

  id: number;
  language: Language;
  profileLanguage: Language;
  defaultBoard: Board;

  constructor(language: Language, profileLanguage: Language) {
    this.language = language;
    this.profileLanguage = profileLanguage;
    this.defaultBoard = new Board('Main Board', language, profileLanguage);
  }
}
