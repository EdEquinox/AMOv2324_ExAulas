package pt.edequinox.calculatorinator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pt.edequinox.calculatorinator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root) // set the layout as the activity content

        binding.screen.setOnClickListener(this)

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)

        binding.btnPlus.setOnClickListener(this)
        binding.btnMinus.setOnClickListener(this)
        binding.btnTimes.setOnClickListener(this)
        binding.btnDivide.setOnClickListener(this)
        binding.btnEquals.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}