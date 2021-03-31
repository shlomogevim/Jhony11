package com.sg.jhony11

import com.google.firebase.Timestamp

class Thought(
    val userName:String,
    val timestamp: Timestamp,
    val thoughtTxt: String?,
    val numLikes:Int,
    val numComments:Int,
    val documentId:String
)