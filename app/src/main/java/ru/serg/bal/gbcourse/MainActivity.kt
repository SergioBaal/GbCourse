package ru.serg.bal.gbcourse
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.serg.bal.gbcourse.databinding.ActivityMainBinding
import ru.serg.bal.gbcourse.utils.DEF_VALUE_ONE
import ru.serg.bal.gbcourse.utils.DEF_VALUE_TWO
import ru.serg.bal.gbcourse.utils.DEF_VALUE_ZERO

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(DEF_VALUE_ZERO)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(DEF_VALUE_ONE)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(DEF_VALUE_TWO)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                DEF_VALUE_ZERO -> tvText1.text = counter
                DEF_VALUE_ONE -> tvText2.text = counter
                DEF_VALUE_TWO -> tvText3.text = counter
            }
        }
    }
}