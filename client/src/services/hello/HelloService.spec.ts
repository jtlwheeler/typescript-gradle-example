import helloService from './HelloService';
import axios from 'axios';
import * as sinon from 'sinon';

describe('auth service', function () {

    describe('login', function () {
        it('should call login', async function (done: jest.DoneCallback) {
            const axiosStub = sinon.stub(axios, 'request');
            let expectedMessage = 'My super awesome message';
            const response = {
                data: {
                    message: expectedMessage
                }
            };

            axiosStub.returns(response);

            const message = await helloService.getMessage();

            expect(message).toBe(expectedMessage);
            expect(axiosStub.called).toBe(true);

            axiosStub.restore();
            done();
        });
    });
});