package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //to hold the list of user input
        val texts = arrayListOf<String>()
        val userInput = findViewById<EditText>(R.id.enterText)
        val button = findViewById<Button>(R.id.button)
        val myRv = findViewById<RecyclerView>(R.id.rvMain)
        var myLayout=findViewById<ConstraintLayout>(R.id.clMain)

        button.setOnClickListener {
            //to check if the user did not enter anything
            if (userInput.text.isEmpty()) {
                Snackbar.make(myLayout, "You did not enter a text", Snackbar.LENGTH_LONG).show()
            }
            else{
            /*Add a Button On Click Listener that creates
             a new entry in the Recycler View with the text
              of what the user enters in the Edit Text*/
            texts.add(userInput.text.toString())
            //then clear the Edit Text field.
            userInput.getText().clear();
            myRv.adapter = RecyclerViewAdapter(texts)
            myRv.layoutManager = LinearLayoutManager(this)
               }
            }
       }
}