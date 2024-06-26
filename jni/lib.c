#include "jni.h"
#include <stdlib.h>
JNIEXPORT jlong JNICALL Java_oop_Oop_malloc(JNIEnv* env, jobject that, jint size){
    
    return (jlong)malloc(size);
    
}

JNIEXPORT jbyte[] Java_oop_Oop_bytes(JNIEnv* env, jobject that, jlong addr){
    jbyte rs[] = {1,3,4};
    return rs;
}

JNIEXPORT void JNICALL Java_oop_Oop_free(JNIEnv* env, jobject that, jlong addr) {

    return free((void*)addr);

}