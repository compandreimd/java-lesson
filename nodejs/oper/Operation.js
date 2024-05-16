const scan = require('readline-sync');
module.exports = class Operation {

     static calc(){
        //int year_sum = years[0] +years[1] + years[2] +years[3];
        let name="Andrei";
        let last= "MMM";

        console.log(name + " " + last + " age ?");

        let age = 0;
        let setedAge = false;
        while (!setedAge) {
            try {
                age = +scan.question("Get Age?");
                setedAge = true;
            } catch (ex) {
                console.log("Wrong int:");
            }
        }

        console.log("Varsta mea la anu:" + (age + 1));

    }
}
