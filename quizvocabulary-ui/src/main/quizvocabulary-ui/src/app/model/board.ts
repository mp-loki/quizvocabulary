import { VocabularyPair } from './vocabulary-pair';
import { Language } from './language';

export class Board {

  studyLanguage: Language;
  profileLanguage: Language;
  name: string;
  vocabulary: VocabularyPair[];

  constructor(name: string, studyLanguage: Language, profileLanguage: Language) {
    this.studyLanguage = studyLanguage;
    this.profileLanguage = profileLanguage;
    this.name = name;
  }
}
