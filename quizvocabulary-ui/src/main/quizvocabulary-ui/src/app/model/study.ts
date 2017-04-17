import { Board } from './board';
import { Language } from './language';

export class Study {

  id: number;
  studyLanguage: Language;
  profileLanguage: Language;
  defaultBoard: Board;

  constructor(studyLanguage: Language, profileLanguage: Language) {
    this.studyLanguage = studyLanguage;
    this.profileLanguage = profileLanguage;
    this.defaultBoard = new Board('Main Board', studyLanguage, profileLanguage);
  }
}
