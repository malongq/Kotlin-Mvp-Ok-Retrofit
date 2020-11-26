package com.izk.izkkotlin.ui.main.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.izk.izkkotlin.R
import kotlinx.android.synthetic.main.activity_study.*

class StudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)


        var extras = this.intent.extras

        Log.i("mlmlmlml", extras?.get("name").toString())

        tv_study.text = extras?.get("name").toString()

    }
}