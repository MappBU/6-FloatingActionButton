package com.example.android.floatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.android.floatingactionbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Скрываем Плавающую кнопку при запуске приложения
        binding?.fab?.hide()

        // Назначаем тапы по кнопке (В переопределенном методе)
        // Внутри метода нет this (Поэтому this@MainActivity)
        binding?.apply {
            fab.setOnClickListener(this@MainActivity)
            fabExtended.setOnClickListener(this@MainActivity)
            display.setOnClickListener(this@MainActivity)
            hide.setOnClickListener(this@MainActivity)
        }

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.fab -> supportFragmentManager.beginTransaction().replace(R.id.content, Delivery()).commit()
            R.id.fabExtended -> supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()
            R.id.display -> binding?.fab?.show()
            R.id.hide -> binding?.fab?.hide()
        }

    }

}