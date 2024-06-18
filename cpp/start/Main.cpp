#include <iostream>
#include <string>
#include "Main.hpp"
#include "Andrei.hpp"
#include "DemoStart.hpp"
#include "../vars/DemoVars.hpp"
#include "../oper/Operation.hpp"
#include "../homework/HW1.hpp"

using namespace start;

int Main::main(int argc, char **argv) {
    char *s;
    if(argc > 1){
        s = argv[1];
    }
    else {
        s = new char [256];
        std::cout << "Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1):?";
        std::cin.getline(s, 255);
    }
    if(strcmp(s, "Andrei") == 0){
        Andrei::main(argc, argv);
    }
    else if (strcmp(s,"Vars") == 0) {
//        vars::DemoVars demo;
//        demo.demo();
        vars::DemoVars *demo;
        demo = new vars::DemoVars(); // auto *demo = new vars::DemoVars; C++11
        demo->demo(); //In Java is reference
    }
    else if (strcmp(s,"DemoStart") == 0) {
        DemoStart::main(argc, argv);
    }
    else if (strcmp(s,"Operation") == 0) {
        oper::Operation::calc();
    }
    else if (strcmp(s,"HW1") == 0) {
       homework::HW1::Media();
    }
    else {
        std::cout << ANSI_YELLOW << "Not such class " << s << ANSI_RESET << std::endl;
        homework::HW1::Media();
    }
    return 0;
}

int main(int argc, char **argv){
    start::Main::main(argc, argv);
}