import { Language } from './language';

export class Profile {
  id: number;
  email: string;
  defaultLanguage: Language;
  languages: Language[];

}
