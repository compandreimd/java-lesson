const scan = require('readline-sync');
module.exports = 2class HW1 {
    static ANSI_RESET = "\u001B[0m";
    static ANSI_YELLOW = "\u001B[33m";
    static Media() {
        const MAX = +scan.question("Introduceti maximum pe salariu?")
        console.log("Introduceti salariele a 3 luni?");
        let l1, l2, l3;
        l1 = +scan.question("Prima luna?");
        l2 = +scan.question("A doua luna?");
        l3 = +scan.question("A treia luna?");
        let sum = l1 + l2 + l3;
        console.log("Suma:" + sum);
        console.log("Media:" + (sum/3));
        console.log(this.ANSI_YELLOW+"Suma depasit de "+ (MAX)+ ": "+ (sum > MAX));
        console.log("Media depasita de "+ (MAX)+ ": "+ (sum/3 > MAX));
        console.log(this.ANSI_RESET);
    }
}
