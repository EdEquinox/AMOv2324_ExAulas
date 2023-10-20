package pt.edequinox.aula4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pt.edequinox.aula4.databinding.ActivityMainBinding
import java.util.jar.Attributes
import kotlin.properties.ReadOnlyProperty

class GameViewModel: ViewModel(){

    val winsP1= MutableLiveData<String>()
    val winsP2= MutableLiveData<String>()
    val board =MutableLiveData<Array<Array<TicTacToeModel.Players>>>()

    fun update(){
        winsP1.postValue("P1: ${game.winsP1}")
        winsP2.postValue("P2: ${game.winsP2}")

    }

    val game= TicTacToeModel()

    fun play(){
        game.play(0,0)

    }
    fun start(){
        game.start()
    }

    fun reset(){
        game.reset()
    }

}
class MainActivity : AppCompatActivity() {
    lateinit var ticTacToeView: TicTacToeView

    private val viewModel:GameViewModel by viewModels()

    private fun viewModels(): ReadOnlyProperty<MainActivity, GameViewModel> {
        TODO()
    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ticTacToeView = TicTacToeView(this)
        binding.flgame.addView(ticTacToeView)

        viewModel.winsP1.observe(this){
            binding.tvP1.text=it
        }

        viewModel.winsP2.observe(this){
            binding.tvP1.text=it
        }
        viewModel.board.observe(this){
            ticTacToeView.board =it
        }
    }
}

class TicTacToeView (context: Context,
                     attrs : AttributeSet?=null,
                     defStyleAtrr :Int =0):
    View(context, attrs,defStyleAtrr){
    var board: Array<Array<TicTacToeModel.Players>>? = null
    val paint = Paint(Paint.DITHER_FLAG or Paint.ANTI_ALIAS_FLAG).apply{
        strokeWidth=10f
        color= Color.rgb(0,0,128)
        style=Paint.Style.STROKE
    }
    init{
        setBackgroundColor(Color.rgb(255,224,32))


    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val cellWith=width/3f
        val cellHeight= height/3f
        canvas.drawLine(0f,cellHeight,width.toFloat(),cellHeight,paint)
        canvas.drawLine(0f, 2*cellHeight,width.toFloat(),2*cellHeight,paint)
        canvas.drawLine(cellWith,0f,cellWith,height.toFloat(),paint)
        canvas.drawLine(2*cellWith,0f,2*cellWith,width.toFloat(),paint)

        //TODO: preencher board no ecra

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        event ?:super.onTouchEvent(event)
        if (event!!.action == MotionEvent.ACTION_UP){
            val x = (event.x/width*3).toInt()
            val y = (event.y/height*3).toInt()
            //onPlay?.play(y,x)
        }

        return true
    }
    interface OnPlayListener{
        fun play()
    }
    //var onPlay :onPlayListener? = null
    var onPlay:OnPlayListener? = null
        get()=onPlay
    fun setOnPlayListener(callback: OnPlayListener){
        onPlay = callback
    }


}