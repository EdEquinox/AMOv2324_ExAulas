package pt.edequinox.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import pt.edequinox.aula3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate the layout
        //setContentView(R.layout.activity_main)
        setContentView(binding.root) // set the layout as the activity content

        //val tvMsg1 = findViewById<TextView>(R.id.tvMsg1)
        binding.tvMsg1.text = getString(R.string.hello_cu)

        binding.btnMsg1.setOnClickListener (this)
        binding.btnMsg2.setOnClickListener (ProcBtn2(binding.tvMsg2))
        binding.btnMsg3.setOnClickListener (procBtn3)
        binding.btnMsg4.setOnClickListener (procBtn4)
        binding.btnMsg5.setOnClickListener { binding.tvMsg2.text = "poipoiopi" }
        binding.tvMsg2.setOnClickListener { }
    }

    val procBtn3 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            binding.tvMsg2.text = "dfasdsfasd"
        }
    }

    val procBtn4 = View.OnClickListener { binding.tvMsg2.text = "cdvbcvxbvcbx" }

    class ProcBtn2(val tv:TextView) : View.OnClickListener {
        override fun onClick(v: View?) {
            tv.text = "uiuiuiui"
        }
    }

    override fun onClick(v: View?) {
        val btn = v as TextView
        binding.tvMsg1.text = "aiaiaiai ${btn.text}"
    }

    fun OnTextoClick(view: View) {
        val btn = view as Button
        when (btn.id){
            R.id.btnMsg1 -> binding.tvMsg1.text = "aiaiaiai ${btn.text}"
            R.id.btnMsg2 -> binding.tvMsg2.text = "aiaiaiai ${btn.text}"
            else -> binding.tvMsg1.text = "aiaiaiai ${btn.text}"
        }
    }


}