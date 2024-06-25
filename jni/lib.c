#include "jni.h"

JNIEXPORT jlong JNICALL Java_oop_Oop_malloc(JNIEnv* env, jobject that, jint size){
    
    return malloc(size);
    
}

JNIEXPORT void JNICALL Java_oop_Oop_free(JNIEnv* env, jobject that, jint size) {

    return free(size);

}