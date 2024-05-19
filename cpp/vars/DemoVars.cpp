//
// Created by compandreimd on 19.05.2024.
//

#include "DemoVars.hpp"
#include <iostream>
/**
     * boolean = true|false (1 bit)
     * byte = 2^8 (-128 ... 127) = 8 * bits
     * n
     */
const char *vars::DemoVars::demo() {
    const char* name = "My name is Andrei. I am student QA!";
    std::cout << name << std::endl;
    std::cout << name << std::endl;
    std::cout << name << std::endl;
    std::cout << name << std::endl;
    // byte n = -15;
    // -128| 64| 32| 16|  8|  4|  2|  1
    //  1 | 1 | 1 | 1 | 0 | 0 | 0 |  1
    return name;
}