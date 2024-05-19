//
// Created by compandreimd on 19.05.2024.
//

#include "Operation.hpp"
#include <iostream>

void oper::Operation::calc() {
    const char *name="Andrei";
    const char *last= "MMM";

    std::cout <<  name << " " << last << " age ?";

    unsigned int age = 0;
//    bool setedAge = false;  !!ERROR INSERT NOT§ NUMBER
//    while (!setedAge) {
       // try {
            std::cin >> age;
        //    setedAge = true;
//        } catch (int a) {
//            std::cout << "Wrong int:";
//        }
//    }

    std::cout << "Varsta mea la anu:"  <<  (age + 1);

}