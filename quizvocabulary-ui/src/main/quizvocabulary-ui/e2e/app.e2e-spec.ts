import { QuizvocabularyUiPage } from './app.po';

describe('quizvocabulary-ui App', () => {
  let page: QuizvocabularyUiPage;

  beforeEach(() => {
    page = new QuizvocabularyUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
