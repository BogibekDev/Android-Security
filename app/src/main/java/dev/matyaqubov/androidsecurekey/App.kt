package dev.matyaqubov.androidsecurekey

import android.app.Application
import android.util.Log

class App : Application() {
    init {
        System.loadLibrary("keys")
    }

    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate() {
        super.onCreate()
        Log.d("@@@", "App: ${getPublicKey()}")
        Log.d("@@@", "App: ${getPrivateKey()}")
    }
}