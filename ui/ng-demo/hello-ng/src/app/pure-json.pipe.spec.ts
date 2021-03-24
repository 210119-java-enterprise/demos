import { PureJsonPipe } from './pure-json.pipe';

describe('PureJsonPipe', () => {
  it('create an instance', () => {
    const pipe = new PureJsonPipe();
    expect(pipe).toBeTruthy();
  });
});
