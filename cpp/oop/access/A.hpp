//
// Created by compandreimd on 16.07.2024.
//

#ifndef J_LESSON_OOP_ACCESS_A_HPP
#define J_LESSON_OOP_ACCESS_A_HPP

#include <iostream>
#include "helper/Macros.hpp"
namespace  oop {
    namespace access {
        class A {
            PUBLIC A();
            PUBLIC void mPub();
            PROTECTED void mPro();
            PRIVATE void mPriv();
        };
    }
}

#endif //J_LESSON_OOP_ACCESS_A_HPP
