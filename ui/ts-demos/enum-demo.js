var Colors;
(function (Colors) {
    Colors[Colors["RED"] = 0] = "RED";
    Colors[Colors["GREEN"] = 1] = "GREEN";
    Colors[Colors["BLUE"] = 2] = "BLUE";
})(Colors || (Colors = {}));
let background = Colors.RED;
console.log(background);
