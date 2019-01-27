describe('Home', function () {
    it('title should be "React App"', async function () {
        browser.get('/');

        expect(browser.getTitle()).toEqual('React App');

        const message = element(by.css('.message'));

        expect(message.getText()).toBe("Hello, World!");
    });
});