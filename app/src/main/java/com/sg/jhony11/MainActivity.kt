package com.sg.jhony11

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.sg.jhony11.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var selectedCtegory = FUNNY
    lateinit var thoughtAtapter: ThoughtsAdapter
    val thoughts = arrayListOf<Thought>()
    val thoughtCollectionRef = FirebaseFirestore.getInstance().collection(THOUGHTS_REF)
    lateinit var thoghtsListener:ListenerRegistration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.fab.setOnClickListener { view ->
            val intent = Intent(this, AddThoughtActivity::class.java)
            startActivity(intent)
        }

        thoughtAtapter = ThoughtsAdapter(thoughts)
        binding.thoughtListView.adapter = thoughtAtapter
        val layoutManager = LinearLayoutManager(this)
        binding.thoughtListView.layoutManager = layoutManager

    }

fun setListener(){
    thoghtsListener=thoughtCollectionRef.addSnapshotListener { snapshot, exception ->
   
        if (exception!=null){
            Log.e("Exception","*** Could not retrive documents because : $exception")
        }
        if (snapshot!=null){
            if (snapshot!=null){
                for (document in snapshot.documents) {
                    val data = document.data
                    if (data!=null) {
                        val name = data[USERNAME] as String
                        val timestamp = data[TIMESTAMP] as Timestamp
                        var thoghtTxt = "No data"
                        if (data[THOUGHT_TXT]!=null) {
                            thoghtTxt = data[THOUGHT_TXT] as String
                        }
                        val numLikes = data[NUM_LIKES] as Long
                        val numComments = data[NUM_COMMENTS] as Long
                        val documentId = document.id
                        val newThought = Thought(
                            name, timestamp, thoghtTxt, numLikes.toInt(),
                            numComments.toInt(), documentId
                        )
                        thoughts.add(newThought)
                    }

                }
            }
            thoughtAtapter.notifyDataSetChanged()
        }
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