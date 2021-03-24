import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pureJson',
  pure: true
})
export class PureJsonPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return JSON.stringify(value);
  }

}
