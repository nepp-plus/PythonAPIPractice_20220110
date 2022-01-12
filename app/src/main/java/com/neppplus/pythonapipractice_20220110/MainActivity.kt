package com.neppplus.pythonapipractice_20220110

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddContact.setOnClickListener {
            val myIntent = Intent(mContext, EditContactActivity::class.java)
            startActivity(myIntent)
        }
    }
}