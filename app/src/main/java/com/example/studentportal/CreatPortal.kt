package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_creat_portal.*

/**
 * @author Omar Mulla Ibrahim
 * Student Nr 500766035
 */

const val EXTRA_PORTAL = "Extra PORTAL"

class CreatPortal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creat_portal)
        initViews()
    }

    private fun initViews() {
        btnAdd.setOnClickListener { onAddPortalBtn() }
    }

    private fun onAddPortalBtn() {
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            val portal = Portal(etTitle.text.toString(), etUrl.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(
                this, "Pleas full the field"
                , Toast.LENGTH_SHORT
            ).show()

        }
    }
}
