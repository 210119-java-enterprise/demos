let drawPoint = (x: number, y: number) => {
    // implementation here...
}

let drawPoint_2 = (point) => {
    //...
}

drawPoint_2({}); // legal, because point is of type "any"
drawPoint_2([]); // legal, because point is of type "any"
drawPoint_2({
    x: 1,
    y: 2,
    hamburger: 'good'
});

// inline type declarations
let drawPoint_3 = (point: {x: number, y: number}) => {
    console.log(point.x);
    console.log(point.y);
}

// illegal; a nor b are not known members of the declared type
// drawPoint_3({
//     a: 1,
//     b: 2
// });

// illegal;z is not a known members of the declared type
// drawPoint_3({
//     x: 1,
//     y: 2,
//     z: 3
// });

// legal
drawPoint_3({
    x: 1,
    y: 2
});

interface Point {
    x: number,
    y: number
}

let drawPoint_4 = (point: Point) => {
    console.log(point.x);
    console.log(point.y);
}

drawPoint_4({
    x: 1,
    y: 2
});