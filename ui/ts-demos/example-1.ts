function log(message: string) {
    console.log(message);
}

let message = 'Hello, TypeScript!';

log(message);

function doSomething() {
    for (let i = 0; i <= 5; i++) {
        console.log(i);
    }

    // console.log(i);
}
doSomething();

class MyClass {

    protected _myVar: string;

    constructor(someVar: string) {
        this._myVar = someVar;
    }

    get myVar() {
        return this._myVar;
    }
}

let myInstance = new MyClass('someValue');
console.log(myInstance.myVar);