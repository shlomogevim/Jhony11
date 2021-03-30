package com.sg.jhony11

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.sg.jhony11.databinding.ActivityAddThoughtBinding
import com.sg.jhony11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var selectedCtegory = FUNNY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
       //setSupportActionBar(findViewById(R.id.toolbar))
        val tr=1

       binding.fab.setOnClickListener { view ->
            val intent= Intent(this,AddThoughtActivity::class.java)
            startActivity(intent)

        }
    }
    fun mainSeriousClick(view: View) {    //its toggle button every press toggle valuep
        if (selectedCtegory == SERIOUS) {
            binding.mainSeriousBtn.isChecked = true
            return
        }
        binding.mainFunnyBtn.isChecked = false
        binding.mainCrazyBtn.isChecked = false
        binding.mainPopularBtn.isChecked = false
        selectedCtegory = SERIOUS

    }

    fun mainFunnyClick(view: View) {
        if (selectedCtegory == FUNNY) {
            binding.mainFunnyBtn.isChecked = true
            return
        }
        binding.mainSeriousBtn.isChecked = false
        binding.mainCrazyBtn.isChecked = false
        binding.mainPopularBtn.isChecked = false
        selectedCtegory = FUNNY
    }

    fun mainCrazyClick(view: View) {
        if (selectedCtegory == CRAZY) {
            binding.mainCrazyBtn.isChecked = true
            return
        }
        binding.mainSeriousBtn.isChecked = false
        binding.mainFunnyBtn.isChecked = false
        binding.mainPopularBtn.isChecked = false
        selectedCtegory = CRAZY

    }
    fun mainPopularClick(view: View) {
        if (selectedCtegory == POPULAR) {
            binding.mainPopularBtn.isChecked = true
            return
        }
        binding.mainSeriousBtn.isChecked = false
        binding.mainFunnyBtn.isChecked = false
        binding.mainFunnyBtn.isChecked = false
        selectedCtegory = POPULAR

    }

}