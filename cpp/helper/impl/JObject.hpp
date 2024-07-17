//
// Created by compandreimd on 16.07.2024.
//

#ifndef J_LESSON_HELPER_IMPL_JOBJECT_HPP
#define J_LESSON_HELPER_IMPL_JOBJECT_HPP
#include "../Macros.hpp"
namespace java {
    namespace lang {
        class JString;
        class JObject {
            PRIVATE static JObject** _objs;
            PRIVATE static jint _count;
            PRIVATE jint _hashCode;
            PUBLIC JObject();
            PUBLIC ~JObject();
            PUBLIC jint hashCode();
            PUBLIC jboolean equals(JObject obj);
            PUBLIC JString toString();
        };
}}
#endif //J_LESSON_HELPER_IMPL_JOBJECT_HPP
