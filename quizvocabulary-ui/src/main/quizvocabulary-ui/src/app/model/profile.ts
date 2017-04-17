import { Language } from './language';

export class Profile {
  id: number;
  email: string;
  name: string;
  nativeLanguage: Language;
  languages: Language[];
}
