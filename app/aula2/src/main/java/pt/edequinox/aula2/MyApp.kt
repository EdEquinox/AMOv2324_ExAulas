package pt.edequinox.aula2

import android.app.Application
import android.util.Log

class MyApp : Application() {
    var xpto: Int = 1234
    var _i = 0
    val i : Int
        get() = _i++
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
    }

    override fun onLowMemory() {    // quando a memoria esta baixa
        super.onLowMemory()
        Log.i(TAG, "onLowMemory")
    }

    override fun onTrimMemory(level: Int) {  // libertar memoria
        super.onTrimMemory(level)
        Log.i(TAG, "onTrimMemory $i")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.i(TAG, "onTerminate $i")
    }
}