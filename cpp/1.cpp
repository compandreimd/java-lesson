/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>

#define MAIN int main(int argc, char** argv) {
#define END return 0;}
#define PRINTLN(X) std::cout << X << std::endl;
#define PUBLIC public:
namespace start {
class Andrei {
    PUBLIC static void main(int argc, char** argv){
        PRINTLN("Andrei");
    }
} Andrei;
class DemoStart {
    PUBLIC static void main(int argv, char** argv){
        PRINTLN("Prima Lectie!")
    }
} DemoStart;
class Main {
     PUBLIC static void main(int argv, char** argv){
            PRINTLN("Prima Lectie!")
     }
} MAIN;
};
MAIN
    start::Andrei.main(argc, argv);
    PRINTLN("Hello World")
END