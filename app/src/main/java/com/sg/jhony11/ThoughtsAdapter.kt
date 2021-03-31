package com.sg.jhony11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sg.jhony11.databinding.ActivityAddThoughtBinding
import com.sg.jhony11.databinding.ThoughtListViewBinding
import java.lang.reflect.Array.get
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ThoughtsAdapter(val thoughts: ArrayList<Thought>) :
    RecyclerView.Adapter<ThoughtsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent?.context).inflate(R.layout.thought_list_view,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindThuoght(thoughts[position])
    }

    override fun getItemCount() = thoughts.count()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView?.findViewById<TextView>(R.id.listViewUsername)
        val timestap =  itemView?.findViewById<TextView>(R.id.listViewTimestamp)
        val thuoghtsText = itemView?.findViewById<TextView>(R.id.listViewToughtTxt)
        val numLikes =  itemView?.findViewById<TextView>(R.id.listViewNumLikes)
        val likesImage =  itemView?.findViewById<ImageView>(R.id.listViewLikesImage)

        fun bindThuoght(thought: Thought) {
            username?.text = thought.userName
            thuoghtsText?.text = thought.thoughtTxt
            numLikes?.text=thought.numLikes.toString()

            /* val dateFormator=SimpleDateFormat("MMM d, h:mm a", Locale.getDefault())
               val dateString=dateFormator.format(thought.timestamp)
               timestap?.text=dateString*/

          /*   val date=thought.timestamp
            val sfd =SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.getDefault())
            val text=sfd.format(date)
            timestap?.text=text*/

         /* val millisecond=thought.timestamp.seconds*1000+thought.timestamp.nanoseconds
            val sfd =SimpleDateFormat("MMM d, h:mm a")
          val timeStamp=sfd.format()
*/
        timestap?.text=thought.timestamp?.toDate().toString()



        }
    }
}