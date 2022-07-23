#include <jni.h>
JNIEXPORT jstring JNICALL
Java_dev_matyaqubov_androidsecurekey_MainActivity_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->  NewStringUTF(env, "long_public_key");
}
JNIEXPORT jstring JNICALL
Java_dev_matyaqubov_androidsecurekey_MainActivity_getPrivateKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "long_private_key");
}


JNIEXPORT jstring JNICALL
Java_dev_matyaqubov_androidsecurekey_App_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->  NewStringUTF(env, "long_public_key");
}
JNIEXPORT jstring JNICALL
Java_dev_matyaqubov_androidsecurekey_App_getPrivateKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "long_private_key");
}