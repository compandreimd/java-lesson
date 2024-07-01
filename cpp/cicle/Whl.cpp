#include "Whl.hpp"
#include <iostream>

using namespace std;

void Whl::main(int argc, char **argv) {
    char* s;
    do {
        cout << "Hell World!" << endl;
        cout << "Doriti sa printati?";
        cin >> s;
    }
    while (strcmp(s, "y") == 0);

}