// "use strict";
// single line comment

/* 
    multi
    line
    comment
*/

/**
 * Documentation comments
 * are multi line
 */

/*
    JS Types:
        Primitives:
            - string
            - number
            - bigint
            - boolean
            - symbol
            - undefined
            - null

        Objects:
            - object
            - array
            - function (first-class members)

        
*/

// standard function declaration
function a() {
    console.log('this is a named function declaration');
}

a();
console.log(a);

// anonymous function declaration
let x = function() {
    console.log('this is an anonymous function assigned to a variable named "x".');
}

x();
console.log(x);

// IIFEs (immediately invoked function expressions)
(function() {
    console.log('this is an immediately invoked function expression!')
})();

/*
    Variable declarative keywords
        - var
        - let (introduced in ES6)
        - const (introduced in ES6)

    Variable Scopes:
        - global
        - function/local
        - block
        - lexical (closures)
*/

function varScope() {

    console.log('line 70: ' + greeting);

    if (5 > 4) {
        // the variable "greeting" is hoisted to the top of the function scope
        var greeting = "hello"; 
        console.log('line 74: ' + greeting);
    }

    console.log('line 77: ' + greeting);

}

varScope();

function letScope() {

    // throws a ReferenceError because "greeting" is not hoisted
    // console.log('line 86: ' + greeting); 

    if (5 > 4) {
        // the variable "greeting" is NOT hoisted (because we used let)
        let greeting = "hello"; 
        console.log('line 91: ' + greeting);

        if (4 < 5) {
            console.log('line 94: ' + greeting);
        }
    }

    // "greeting"is not visible here because let/const are scoped to the block in which they are declared
    // console.log('line 98: ' + greeting);

}

letScope();

function constScope() {
    console.log(constantGreeting);
    const constantGreeting = "hola!";
}

// Cannot reference const before declaration, it is not hoisted.
// constScope();


// function hoisting
myFunction()
function myFunction() {
    console.log('this is my function!');
}


// otherFunction();
var otherFunction = function() {
    console.log('this is another function');
}

// more on const
// const y; // you must initialize const variables when declaring them

// const variable 
const y = 42;
// y = 43; // once initialized, const variables can never be reassigned

const immutableMaybe = {
    someValue: 10,
    anotherValue: 'test',
    nestedObj: {
        nestedValue: 100
    }
};

// not allowed, for obvious reasons (reassigning a const variable)
// immutableMaybe = {};

console.log(immutableMaybe);

immutableMaybe.someValue = 11;

console.log(immutableMaybe);

// basic object
let myObject = {
    a: 'a',
    b: 2,
    c: true,
    d: function() {
        console.log('d');
    },
    e() {
        console.log('e');
    },
    'some property': 'some value'
}

myObject.e();
myObject.d();

console.log(myObject.a); // dot notation for accessing object members
console.log(myObject['b']); // bracket notation for accessing object members
console.log(myObject['some property']);


// old-school way of creating a JS "class"
function Car(model) {
    this.model = model;
    this.color = 'silver';
    this.year = '2015';

    // this.toString = function() {
    //     console.log(this.model + ', ' + this.color + ', ' + this.year);
    // }
}

// to properly overwrite the toString method, we need to access the prototype object within our Car "class"
Car.prototype.toString = function() {
    console.log(`${this.model}, ${this.color}, ${this.year}`);
}

let myCar = new Car('Nissan Rogue');
console.log(myCar);
myCar.toString();

Car.prototype.toString = function() {
    console.log(`${this.model}, ${this.color}, ${this.year}`, `${4 + 2 + 3}`); // template literals
}

let yourCar = new Car('Honda Civic');
console.log(yourCar);
yourCar.toString();

// ES6 Class syntax (sugar syntax)
class Truck {

    // only one constructor allow in ES6 class syntax
    constructor(model, year, color = 'silver') {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    that = this;

    squeal() {
        console.log(this == this.that);
        console.log('SQUUUUUUEAK');
    }

    beep = function() {
        console.log(this == this.that);
        console.log("BEEEEEP!");
    }

    honk = () => {
        console.log(this == this.that);
        console.log('HONK!');
    }

}

let myTruck = new Truck('Toyota Tacoma', 2020, 'black');
console.log(myTruck);
myTruck.beep();
myTruck.honk();
myTruck.squeal();

// Arrays
let myArr = [1, 2, 3];
let crazyArray = [1, true, 'hello', new Car(), new Truck(), function () { console.log ('whut?!')}];

console.log(myArr[0]); // 1

// passing a arrow function to another function/method
let squaredValues = myArr.map(val => {
    return Math.pow(val, 2);
});

console.log(squaredValues);

console.log(this); // in Node this = {}, in the browser it would = the Window object

// creates its own 'this', which is the global NodeJS object
function a() {
    console.log(this); // this == Object [global] {...} (provided by NodeJS)
}
a();

// creates its own 'this', which is the global NodeJS object
let b = function() {
    console.log(this); // this == Object [global] {...} (provided by NodeJS)
}
b();

// does not create it own 'this', instead it inherits the 'this' from the outer scope.
let c = () => {
    console.log(this);
}
c();


function D() {
    this.x = 1;
    this.y = 2;
    this.z = 3;
    console.log(this); // this == D {...}
}
let d = new D();

function E() {
    this.x = 1;

    console.log(this); // this == F {...}

    let that = this;

    const b = () => {
        console.log(this == that);
    }

    b();

    const c = function () {
        console.log(this == that);
    }

    c();
}

let e = new E();

/*
    Truthy and Falsy

        - due to type coercion all values in JS can be interpreted as booleans
        - just remember: there are only 6 falsy values:
            - false
            - 0
            - NaN
            - null 
            - undefined
            - "", '', ``
*/

console.log(10 / 0);
console.log('hello ' + 3); // type coercion
console.log('hello' - 3); // NaN
console.log('hello ' * 3); // NaN
console.log(('hello' - 3) == ('hello' - 3)); // surprisingly false, because...
console.log(NaN == NaN); // false
console.log(typeof(NaN)); // not a number is a number!
console.log('2' == 2); // comparison operator that performs type coercion
console.log('2' === 2); // comparison operator that DOES NOT perform type coercion

let username = {};
let password = 'password';

if (username && password) {
    login(username, password);
} else {
    console.log('you provided empty or null values!');
}

function login(un, pw) {
    console.log(`Logging in: ${un} with ${pw}`);
}

console.log(([]+{}+!{}));

console.log(!!"dsgafgkj.usgarfa.hsgfjavf");