import { QuizQuestion } from './quiz-question';
export class Quiz {
  questions: QuizQuestion[] = [];
  correct: QuizQuestion[] = [];
  incorrect: QuizQuestion[] = [];
}
