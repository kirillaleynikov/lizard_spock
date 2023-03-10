package com.example.lizard_spock
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lizard_spock.databinding.ActivityStatisticBinding

class StatisticActivity : AppCompatActivity() {
    lateinit var binding: ActivityStatisticBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val winCounter = intent.getStringExtra("winCounter")
        val loseCounter = intent.getStringExtra("loseCounter")
        val drawCounter = intent.getStringExtra("drawCounter")
        binding.btnGoBack.setOnClickListener {
            finish()
        }
        binding.winCounter.text = "Количество ваших выигрышей $winCounter"
        binding.loseCounter.text = "Количество выигрышей компьютера $loseCounter"
        binding.drawCounter.text = "Количество ничьих $drawCounter"
    }
}