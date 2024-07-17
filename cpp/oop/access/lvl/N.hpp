//
// Created by compandreimd on 16.07.2024.
//

#ifndef J_LESSON_OOP_ACCESS_LVL_N_HPP
#define J_LESSON_OOP_ACCESS_LVL_N_HPP
#include "../A.hpp"
namespace  oop {
    namespace access {
        namespace lvl {
            class N {

                class NA : public A {
                    static void sshow();

                    void show();
                };

                class NB : protected A {
                    static void sshow();

                    void show();
                };

                class NC : private A {
                    static void sshow();

                    void show();
                };

            };

        }
    }
}
#endif //J_LESSON_OOP_ACCESS_LVL_N_HPP
