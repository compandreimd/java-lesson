//
// Created by compandreimd on 16.07.2024.
//

#include <cstring>
#include "JString.hpp"

java::lang::JString::JString(){
    this->value = new char[1];
    this->value[0] = 0;
}
java::lang::JString::JString(const char *str) {
    this->value = new char [strlen(str)];
    stpcpy(this->value, str);
}

