//
// Created by compandreimd on 16.07.2024.
//

#include "N.hpp"
namespace  oop {
    namespace access {
        namespace lvl {
            void N::NA::show() {
                this->mPub();
                this->mPro();
            }

            void N::NA::sshow() {
                N::NA a;
                a.mPub();
                //a.mPro();
                N::NB b;
                //b.mPub();
                //b.mPro();
                N::NC c;
                //c.mPub();
                //c.mPro();;
            }

            void N::NB::show() {
                this->mPro();
                this->mPub();
            }

            void N::NB::sshow() {
                N::NA a;
                a.mPub();
                //a.mPro();
                N::NB b;
                b.mPub();
                b.mPro();
            }

            void N::NC::show() {
                this->mPro();
                this->mPub();
            }

            void N::NC::sshow() {
                N::NA a;
                a.mPub();
                //a.mPro();
                N::NB b;
                //b.mPub();
                //b.mPro();
                N::NC c;
                c.mPub();
                c.mPro();
            }
        }
    }
}