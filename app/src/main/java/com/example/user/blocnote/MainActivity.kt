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

// lorsque l'utilisateur clique sur le bouton "ajouter" le contenu taper s'ajoute au contenu existant
    fun addButtonTouched(button:View){
        var userInput = editTextUser.text.toString()
        val existingText = textViewNote.text.toString()
        textViewNote.text = "$existingText \n $userInput"
        content = textViewNote.text.toString()
        editTextUser.text = null

        saveContent()

    }
// enregistrement du contenu du textview dans un SharedPreferences
    private fun saveContent() {
        val myNoteRecorded = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE).edit()
        myNoteRecorded.putString(CONTENT_KEY,content)
        myNoteRecorded.apply()
    }
}
