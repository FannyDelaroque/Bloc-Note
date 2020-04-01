package com.example.user.blocnote

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var content = ""
    val SETTINGS_FILE_NAME = "BlocNote"
    val CONTENT_KEY = "content"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myContent = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE)
        textViewNote.text = myContent.getString(CONTENT_KEY,"")


    }

    fun addButtonTouched(button:View){
        var userInput = editTextUser.text.toString()
        val existingText = textViewNote.text.toString()
        textViewNote.text = "$existingText \n $userInput"
        content = textViewNote.text.toString()
        editTextUser.text = null

        saveContent()




    }

    private fun saveContent() {
        val myNoteRecorded = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE).edit()
        myNoteRecorded.putString(CONTENT_KEY,content)
        myNoteRecorded.apply()
    }
}
