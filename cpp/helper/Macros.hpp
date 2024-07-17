//
// Created by compandreimd on 19.05.2024.
//

#ifndef J_LESSON_MACROS_HPP
#define J_LESSON_MACROS_HPP
#define ANSI_RESET "\033[0m"
#define ANSI_YELLOW "\033[0;33m"
#define PUBLIC public:
#define PROTECTED protected:
#define PRIVATE private:
typedef int jint;
#ifdef _LP64
    typedef long jlong;
#else
    typedef long long jlong;
#endif
typedef signed char jbyte;
typedef unsigned char   jboolean;
typedef unsigned short  jchar;
typedef short           jshort;
typedef float           jfloat;
typedef double          jdouble;
typedef jint            jsize;

typedef union jvalue {
    jboolean z;
    jbyte    b;
    jchar    c;
    jshort   s;
    jint     i;
    jlong    j;
    jfloat   f;
    jdouble  d;
    //  l;
} jvalue;

#define JNI_FALSE 0
#define JNI_TRUE 1


#endif //J_LESSON_MACROS_HPP
