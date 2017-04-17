import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Study } from '../model/study';
import { Language } from '../model/language';
import { Quiz } from '../model/quiz';
import { QuizQuestion } from '../model/quiz-question';
import { VocabularyPair } from '../model/vocabulary-pair';

@Injectable()
export class StudyService {

  studies: Study[] = [];
  constructor(private http: Http) { }

  getStudy(studyLanguage: Language, profileLanguage: Language): Study {
    let study = this.studies.find(st => st.studyLanguage === studyLanguage && st.profileLanguage === profileLanguage);
    if (typeof study === 'undefined') {
      study = this.getNewStudy(studyLanguage, profileLanguage);
    }
    this.studies.push(study);
    return study;
  }

  saveStudy(study: Study): void {
    // TODO: save study to server
    console.log('Here the study will be saved');
  }

  getQuiz(study: Study): Quiz {
    // TODO: get quiz from server
    return this.getDefaultQuiz(study);
  }

  private getDefaultQuiz(study: Study): Quiz {
    let quiz: Quiz = new Quiz;
    for (let pair of study.defaultBoard.vocabulary) {
      let question: QuizQuestion = this.getQuizQuestion(pair, study.defaultBoard.vocabulary);
      quiz.questions.push(question);
    }
    this.shuffle(quiz.questions);
    return quiz;
  }

  private getQuizQuestion(pair: VocabularyPair, vocabulary: VocabularyPair[]): QuizQuestion {
    let vocabularyCopy = vocabulary.slice(0);
    let question: QuizQuestion = new QuizQuestion();
    question.question = pair;

    let idx = vocabularyCopy.indexOf(pair);
    vocabularyCopy.splice(idx, 1);
    this.shuffle(vocabularyCopy);
    let options = vocabularyCopy.slice(0, 3);
    options.push(pair);
    this.shuffle(options);

    question.options = options;
    return question;
  }

  private shuffle(a): void {
    let j, x, i;
    for (i = a.length; i; i--) {
      j = Math.floor(Math.random() * i);
      x = a[i - 1];
      a[i - 1] = a[j];
      a[j] = x;
    }
  }

  private getNewStudy(studyLanguage: Language, profileLanguage: Language): Study {
    let study: Study = new Study(studyLanguage, profileLanguage);
    study.defaultBoard.vocabulary = this.getDefaultVocabulary(studyLanguage, profileLanguage);
    return study;
  }

  private getDefaultVocabulary(studyLanguage: Language, profileLanguage: Language): VocabularyPair[] {
    if (studyLanguage.code === 'fr' && profileLanguage.code === 'en') {
      return this.getDefaultFrenchVocabulary(studyLanguage, profileLanguage);
    };
    if (studyLanguage.code === 'de' && profileLanguage.code === 'en') {
      return this.getDefaultGermanVocabulary(studyLanguage, profileLanguage);
    };
    if (studyLanguage.code === 'ua' && profileLanguage.code === 'en') {
      return this.getDefaultUkrainianVocabulary(studyLanguage, profileLanguage);
    };
    if (studyLanguage.code === 'jp' && profileLanguage.code === 'en') {
      return this.getDefaultJapaneseVocabulary(studyLanguage, profileLanguage);
    };
    return [];
  }

  private getDefaultFrenchVocabulary(studyLanguage: Language, profileLanguage: Language): VocabularyPair[] {
    return [
      { logosA: 'être', logosALanguage: studyLanguage, logosB: 'be', logosBLanguage: profileLanguage },
      { logosA: 'avoir', logosALanguage: studyLanguage, logosB: 'have', logosBLanguage: profileLanguage },
      { logosA: 'faire', logosALanguage: studyLanguage, logosB: 'do', logosBLanguage: profileLanguage },
      { logosA: 'aller', logosALanguage: studyLanguage, logosB: 'go', logosBLanguage: profileLanguage },
      { logosA: 'prendre', logosALanguage: studyLanguage, logosB: 'take', logosBLanguage: profileLanguage },
      { logosA: 'écrire', logosALanguage: studyLanguage, logosB: 'write', logosBLanguage: profileLanguage },
      { logosA: 'lire', logosALanguage: studyLanguage, logosB: 'read', logosBLanguage: profileLanguage },
    ];
  }

  private getDefaultGermanVocabulary(studyLanguage: Language, profileLanguage: Language): VocabularyPair[] {
    return [
      { logosA: 'sein', logosALanguage: studyLanguage, logosB: 'be', logosBLanguage: profileLanguage },
      { logosA: 'begegnen', logosALanguage: studyLanguage, logosB: 'encounter', logosBLanguage: profileLanguage },
      { logosA: 'haben', logosALanguage: studyLanguage, logosB: 'have', logosBLanguage: profileLanguage },
      { logosA: 'machen', logosALanguage: studyLanguage, logosB: 'do', logosBLanguage: profileLanguage },
      { logosA: 'gehen', logosALanguage: studyLanguage, logosB: 'go', logosBLanguage: profileLanguage },
      { logosA: 'nehmen', logosALanguage: studyLanguage, logosB: 'take', logosBLanguage: profileLanguage },
      { logosA: 'schreiben', logosALanguage: studyLanguage, logosB: 'write', logosBLanguage: profileLanguage },
      { logosA: 'lesen', logosALanguage: studyLanguage, logosB: 'read', logosBLanguage: profileLanguage },
    ];
  }
  private getDefaultUkrainianVocabulary(studyLanguage: Language, profileLanguage: Language): VocabularyPair[] {
    return [
      { logosA: 'бути', logosALanguage: studyLanguage, logosB: 'be', logosBLanguage: profileLanguage },
      { logosA: 'мати', logosALanguage: studyLanguage, logosB: 'have', logosBLanguage: profileLanguage },
    ];
  }
  private getDefaultJapaneseVocabulary(studyLanguage: Language, profileLanguage: Language): VocabularyPair[] {
        return [
      { logosA: 'ア', logosALanguage: studyLanguage, logosB: 'a', logosBLanguage: profileLanguage },
      { logosA: 'イ', logosALanguage: studyLanguage, logosB: 'i', logosBLanguage: profileLanguage },
      { logosA: 'ウ', logosALanguage: studyLanguage, logosB: 'u', logosBLanguage: profileLanguage },
      { logosA: 'エ', logosALanguage: studyLanguage, logosB: 'e', logosBLanguage: profileLanguage },
      { logosA: 'オ', logosALanguage: studyLanguage, logosB: 'o', logosBLanguage: profileLanguage },
    ];
      }  
}
