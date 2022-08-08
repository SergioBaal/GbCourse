package ru.serg.bal.gbcourse

import ru.serg.bal.gbcourse.utils.DEF_VALUE_ONE
import ru.serg.bal.gbcourse.utils.DEF_VALUE_TWO
import ru.serg.bal.gbcourse.utils.DEF_VALUE_ZERO

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when (id) {
            DEF_VALUE_ZERO -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            DEF_VALUE_ONE -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            DEF_VALUE_TWO -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}