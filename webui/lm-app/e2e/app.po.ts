import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/ftp08/');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }

  getRows() {
    const tbody = element(by.tagName('tbody'));
    return tbody.all(by.tagName('tr'));
  }
}
