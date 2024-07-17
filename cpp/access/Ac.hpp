//
// Created by compandreimd on 16.07.2024.
//
#include "../helper/Macros.hpp"
#include "oop/access/A.hpp"
#ifndef J_LESSON_ACCESS_AC_HPP
#define J_LESSON_ACCESS_AC_HPP
using namespace oop::access;

class Ac {

    class NA : A {
        PUBLIC static void sshow(){
            A* a = new A();
            a->mPub();
            NA* n = new NA();
            n->mPub();
            n->mPro();
        }
        PUBLIC void show(){
            mPub();
            mPro();
        }
    };

    PUBLIC static void main(){
        A a;
        a.mPub();
        NA::sshow();
    }

};



#endif //J_LESSON_ACCESS_AC_HPP
