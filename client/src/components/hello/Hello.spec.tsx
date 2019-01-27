import * as React from 'react';
import Hello from './Hello';
import {configure, shallow} from 'enzyme';
import * as Adapter from 'enzyme-adapter-react-16';
import helloService from '../../services/hello/HelloService';
import * as sinon from 'sinon';
import {waitUntil} from '../test-helpers/waitUntil.helper';

configure({adapter: new Adapter()});

describe('<Hello />', function () {
    it('should make API call and display results', async function () {
        let expectedMessage = 'My API Message';
        const helloServiceStub = sinon.stub(helloService, 'getMessage')
            .returns(expectedMessage);
        const wrapper = shallow(<Hello/>);

        await waitUntil(() => helloServiceStub.called,
            50,
            'Stub was never called');

        wrapper.update();

        expect(helloServiceStub.called).toBe(true);
        expect(wrapper.find('.message').text()).toBe(expectedMessage);

        helloServiceStub.restore();
    });
});
