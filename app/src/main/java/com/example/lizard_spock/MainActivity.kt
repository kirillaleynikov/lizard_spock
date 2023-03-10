package com.example.lizard_spock
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lizard_spock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val tools = arrayOf("камень","бумага","ножницы","ящерица","спок")
    var personchoice = ""
    var winCounter = 0
    var loseCounter = 0
    var drawCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPlay.setOnClickListener(){
            binding.btnPlay.text = "ИГРА"
            binding.rules.visibility = View.VISIBLE
            binding.statistic.visibility = View.INVISIBLE
            binding.choiceTool.visibility = View.VISIBLE
            binding.btnLizard.isEnabled = true
            binding.btnSpock.isEnabled = true
            binding.btnPaper.isEnabled = true
            binding.btnRock.isEnabled = true
            binding.btnScissors.isEnabled = true
            binding.btnPlay.isEnabled = false
            binding.tvResult.text = ""
            binding.tvStatus.text = ""
            binding.tvStatus2.text = ""
            binding.lizardLeft.visibility = View.INVISIBLE
            binding.lizardRight.visibility = View.INVISIBLE
            binding.paperLeft.visibility = View.INVISIBLE
            binding.paperRight.visibility = View.INVISIBLE
            binding.rockLeft.visibility = View.INVISIBLE
            binding.rockRight.visibility = View.INVISIBLE
            binding.scissorsLeft.visibility = View.INVISIBLE
            binding.scissorsRight.visibility = View.INVISIBLE
            binding.spokeLeft.visibility = View.INVISIBLE
            binding.spokeRight.visibility = View.INVISIBLE
        }
        binding.btnRock.setOnClickListener()
        {
            personchoice = "камень"
            checking()
        }
        binding.btnScissors.setOnClickListener()
        {
            personchoice = "ножницы"
            checking()
        }
        binding.btnPaper.setOnClickListener()
        {
            personchoice = "бумага"
            checking()
        }
        binding.btnLizard.setOnClickListener()
        {
            personchoice = "ящерица"
            checking()
        }
        binding.btnSpock.setOnClickListener()
        {
            personchoice = "спок"
            checking()
        }
        binding.statistic.setOnClickListener()
        {
            val intent = Intent(this, StatisticActivity::class.java)
            intent.putExtra("winCounter",winCounter.toString())
            intent.putExtra("loseCounter",loseCounter.toString())
            intent.putExtra("drawCounter",drawCounter.toString())
            startActivity(intent)
        }
    }
    fun checking()
    {
        binding.rules.visibility = View.INVISIBLE
        val compchoice = tools.random()
        binding.choiceTool.visibility = View.INVISIBLE
        when {
                    (personchoice == "камень" && compchoice == "камень") ||
                    (personchoice == "бумага" && compchoice == "бумага") ||
                    (personchoice == "ножницы" && compchoice == "ножницы") ||
                    (personchoice == "ящерица" && compchoice == "ящерица") ||
                    (personchoice == "спок" && compchoice == "спок")-> {
                    binding.tvResult.text = "Ничья!"
                        ++drawCounter
                    binding.tvStatus.text = "Выбор компьютера: $compchoice"
                    binding.tvStatus2.text = "Ваш выбор: $personchoice"
                    images(compchoice)
                    repeat() }
                    (personchoice == "камень" && compchoice == "ящерица") ||
                    (personchoice == "камень" && compchoice == "ножницы") ||
                    (personchoice == "бумага" && compchoice == "камень") ||
                    (personchoice == "бумага" && compchoice == "спок") ||
                    (personchoice == "ножницы" && compchoice == "бумага") ||
                    (personchoice == "ножницы" && compchoice == "ящерица") ||
                    (personchoice == "ящерица" && compchoice == "бумага") ||
                    (personchoice == "ящерица" && compchoice == "спок") ||
                    (personchoice == "спок" && compchoice == "камень") ||
                    (personchoice == "спок" && compchoice == "ножницы")-> {
                    binding.tvResult.text = "Вы выиграли!"
                        ++winCounter
                    binding.tvStatus.text = "Выбор компьютера: $compchoice"
                    binding.tvStatus2.text = "Ваш выбор: $personchoice"
                    images(compchoice)
                    repeat() }
            else -> {
                binding.tvResult.text = "Выиграл компьютер!"
                ++loseCounter
                binding.tvStatus.text = "Выбор компьютера: $compchoice"
                binding.tvStatus2.text = "Ваш выбор: $personchoice"
                images(compchoice)
                repeat()
            }
        }
    }
    fun images(choicecomp:String)
    {
        when (choicecomp){
            "камень" -> binding.rockRight.visibility = View.VISIBLE
            "ножницы" -> binding.scissorsRight.visibility = View.VISIBLE
            "бумага" -> binding.paperRight.visibility = View.VISIBLE
            "ящерица" -> binding.lizardRight.visibility = View.VISIBLE
            "спок" -> binding.spokeRight.visibility = View.VISIBLE
        }
        when (personchoice){
            "камень" -> binding.rockLeft.visibility = View.VISIBLE
            "ножницы" -> binding.scissorsLeft.visibility = View.VISIBLE
            "бумага" -> binding.paperLeft.visibility = View.VISIBLE
            "ящерица" -> binding.lizardLeft.visibility = View.VISIBLE
            "спок" -> binding.spokeLeft.visibility = View.VISIBLE
        }
    }
    fun repeat()
    {
        binding.statistic.visibility = View.VISIBLE
        binding.btnPlay.isEnabled=true
        binding.btnPlay.text = "Повторить"
        binding.btnSpock.isEnabled=false
        binding.btnRock.isEnabled=false
        binding.btnPaper.isEnabled=false
        binding.btnScissors.isEnabled=false
        binding.btnLizard.isEnabled=false
    }
}