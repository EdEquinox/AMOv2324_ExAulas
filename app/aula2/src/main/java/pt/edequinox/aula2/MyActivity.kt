package pt.edequinox.aula2

import android.app.Activity
import android.os.Bundle
import android.util.Log

const val TAG = "MyActivity"

class MyActivity : Activity() {

    private var _i = 0
    val i : Int
        get() = _i++

    val app : MyApp by lazy { application as MyApp } // lazy: so e executado quando e necessario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _i = savedInstanceState?.getInt("i") ?: 0 // se a primeira instrucao for null, executa a segunda
        setContentView(R.layout.my_activity)
        Log.i(TAG, "onCreate $i")
        Log.i(TAG, "onCreate: tou cansado")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart $i ${MyObject.value}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart $i")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume $i")
        var xptoapp = app.xpto
        Log.i(TAG, "xpto = $xptoapp")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause $i ${MyObject.value}")
        app.xpto = _i
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop $i")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy $i")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState $i ${MyObject.value}")
        outState.putInt("i", _i)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState $i")
        _i = savedInstanceState.getInt("i")
    }

}