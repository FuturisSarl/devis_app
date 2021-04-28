package com.itverse.futuris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itverse.futuris.ui.main.TestFragment

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TestFragment.newInstance())
                .commitNow()
        }
    }
}