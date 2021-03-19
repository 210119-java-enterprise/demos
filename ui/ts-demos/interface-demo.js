var drawPoint = function (x, y) {
    // implementation here...
};
var drawPoint_2 = function (point) {
    //...
};
drawPoint_2({}); // legal, because point is of type "any"
drawPoint_2([]); // legal, because point is of type "any"
drawPoint_2({
    x: 1,
    y: 2,
    hamburger: 'good'
});
// inline type declarations
var drawPoint_3 = function (point) {
    console.log(point.x);
    console.log(point.y);
};
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
var drawPoint_4 = function (point) {
    console.log(point.x);
    console.log(point.y);
};
drawPoint_4({
    x: 1,
    y: 2
});
