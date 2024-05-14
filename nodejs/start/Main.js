const readline = require('readline');
const scan = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

scan.question('Choose Class (Andrei, DemoStart, Main, DemoVars, Operation, HW1):?', (w) = > {
    console.log(w);
    console.log("Message:"+w)
    console.log("Messagedsd:"+w)
})
//        if(args.length > 0)
//            s = args[0];
//        else {
//            System.out.println("Choose Class (Andrei, DemoStart, Main, DemoVars, Operation, HW1):?");
//            s = scan.nextLine();
//        }
//      //  scan.close();
//
//        switch (s){
//            case "Andrei":
//                Andrei.main(args);
//            case "Vars":
//                var demo = new DemoVars();
//                demo.demo();
//            case "Demo":
//                DemoStart.main(args);
//            break;
//            case "Operation":
//                Operation.calc();
//                break;
//            case "HW1":
//                default:
//                    HW1.Media();
//        }
//        scan.close();
//    }
//}
