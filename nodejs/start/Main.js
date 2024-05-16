const scan = require('readline-sync');
const args = process.argv;

if(args.length > 2)
    s = args[2];
else
    s = scan.question("Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1):?");
switch (s){
    case "Andrei":
        require("./Andrei");
        break;
    case "Vars":
        const DemoVars = require("../vars/DemoVars");
        const demo = new DemoVars();
        demo.demo();
    case "DemoStart":
        require("./DemoStart");
        break;
    case "Operation":
        require("../oper/Operation").calc();
        break;
    default:
        console.warn("Not such class " + s);
    case "Main":
    case "HW1":
        require("../homework/HW1").Media();
}

