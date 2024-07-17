//
// Created by compandreimd on 16.07.2024.
//

#ifndef J_LESSON_HELPER_IMPL_JSTRING_HPP
#define J_LESSON_HELPER_IMPL_JSTRING_HPP
#include "JObject.hpp"
namespace java {
    namespace lang {
        class JString : JObject{
            PRIVATE char* value;
            PUBLIC JString();
            PUBLIC JString(const char* str);
        };
    }
}


#endif //J_LESSON_HELPER_IMPL_JSTRING_HPP
