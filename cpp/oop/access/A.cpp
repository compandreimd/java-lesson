//
// Created by compandreimd on 16.07.2024.
//

#include "A.hpp"
namespace  oop {
    namespace access {
        void A::mPub() {
            std::cout << "i AM PUBLIC!";
        }

        void A::mPro() {
            std::cout << "i AM Protected!";
        }

        void A::mPriv() {
            std::cout << "i AM Private!";
        }

        A::A() {
            mPub();
            mPro();
            mPriv();
        }
    }
}