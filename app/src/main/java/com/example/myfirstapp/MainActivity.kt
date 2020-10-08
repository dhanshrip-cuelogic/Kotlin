package com.example.myfirstapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // ------------- creating button in view using code ----------------

        //set content view by id
        setContentView(R.layout.fragment_first)

        // get the constraint layput by id
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val set = ConstraintSet()
        set.clone(constraintLayout)


        // create a new button
        val button = Button(this)
        val button2 = Button(this)

        // add properties for the button
        button.id = View.generateViewId()
        button.setText("Click me 1 !")
        button.setBackgroundColor(Color.YELLOW)
        button.setTextColor(Color.BLUE)
        button.setOnClickListener(View.OnClickListener {
            button.setText("Button Clicked")
        })
        button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)


        button2.id = View.generateViewId()
        button2.setText("Click me 2 !")
        button2.setBackgroundColor(Color.YELLOW)
        button2.setTextColor(Color.BLUE)
        button2.setOnClickListener(View.OnClickListener {
            button2.setText("Button Clicked")
        })
        button2.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)


        // connect constraints to button and apply it on the same Constraint layout
        set.connect(button.id, ConstraintSet.START, button2.id, ConstraintSet.END, 50)
        set.connect(button.id, ConstraintSet.TOP, button2.id, ConstraintSet.BOTTOM, 50)
        set.applyTo(constraintLayout)

        // add button view to the respective constraintLayout
        constraintLayout.addView(button)
        constraintLayout.addView(button2)


        // -------------------------------------------------------------------------
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}