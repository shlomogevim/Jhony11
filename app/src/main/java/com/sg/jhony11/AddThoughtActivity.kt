package com.sg.jhony11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.sg.jhony11.databinding.ActivityAddThoughtBinding

class AddThoughtActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddThoughtBinding
    var selectedCtegory = FUNNY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddThoughtBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun addPostClick(view: View) {
        val data=HashMap<String,Any>()
        data.put(CATEGORY,selectedCtegory)
        data.put(NUM_COMMENTS,0)
        data.put(NUM_LIKES,0)
        data.put(THOUGHT_TXT,binding.addToughtText.text.toString())
        data.put(TIMESTAMP,FieldValue.serverTimestamp())
        data.put(USERNAME,binding.addUsernameText.text.toString())

        FirebaseFirestore.getInstance().collection(THOUGHTS_REF).add(data)
            .addOnSuccessListener {
                finish()
            }
            .addOnFailureListener { exception->
                Log.e("Exception","*** could not add post because : $exception")

            }

    }

    fun addSeriosClick(view: View) {    //its toggle button every press toggle valuep
        if (selectedCtegory == SERIOUS) {
            binding.addSeriousBtn.isChecked = true
            return
        }
        binding.addFunnyBtn.isChecked = false
        binding.addCreazyBtn.isChecked = false
        // binding.addFunnyBtn.isChecked=true
        selectedCtegory = SERIOUS

    }

    fun addFunnyClick(view: View) {
        if (selectedCtegory == FUNNY) {
            binding.addFunnyBtn.isChecked = true
            return
        }
        binding.addSeriousBtn.isChecked = false
        binding.addCreazyBtn.isChecked = false
        selectedCtegory = FUNNY
    }

    fun addCrazyClick(view: View) {
        if (selectedCtegory == CRAZY) {
            binding.addCreazyBtn.isChecked = true
            return
        }
        binding.addSeriousBtn.isChecked = false
        binding.addFunnyBtn.isChecked = false
        // binding.addFunnyBtn.isChecked=true
        selectedCtegory = CRAZY

    }


}