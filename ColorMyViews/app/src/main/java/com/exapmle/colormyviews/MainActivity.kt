package com.exapmle.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    //görsel için önce ImageView'i tanımladık
    lateinit var diceImage: ImageView
    lateinit var diceImage2:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        //image'mizin id'sini burada tanımladık
        diceImage=findViewById(R.id.imageView)
        diceImage2=findViewById(R.id.imageView2)
    }
    private fun setListeners(){
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val green_button = findViewById<Button>(R.id.green_button)


        val clickableViews:List<View> = listOf(boxOneText,boxTwoText,boxThreeText,boxFourText,boxFiveText,constraintLayout
        ,redButton,yellowButton,green_button
        )

        for(item in clickableViews){
            item.setOnClickListener{makeColored(it)}
        }
    }
    private
    fun makeColored(view: View) {
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.BLUE)
           // R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
         //   R.id.box_two_text->view.setBackgroundResource(R.drawable.horse_2)
            R.id.box_two_text-> GlobalScope.launch {
                // Rastgele bir süre beklemek için delay kullanabilirsiniz
               // delay(1000)

                // Şimdi resmi değiştirin
                withContext(Dispatchers.Main) {
                    view.setBackgroundResource(R.drawable.horse_2)
                    delay(1000)
                    view.setBackgroundResource(0)
                }
            }
            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)


            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
          //  boxThreeText.setBackgroundResource(R.color.my_red)
           // R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)
            //red butonuna image_1 atadık

            //biraz gecikmeli olarak bu fotoğraf gelecektir
            R.id.red_button ->  GlobalScope.launch {
                // Rastgele bir süre beklemek için delay kullanabilirsiniz
                delay(2000)

                // Şimdi resmi değiştirin
                withContext(Dispatchers.Main) {
                    diceImage.setImageResource(R.drawable.image_1)
                    delay(2000)
                    diceImage.setImageResource(0)
                }
            }

            R.id.yellow_button->diceImage2.setImageResource(R.drawable.horse_2)
            else -> view.setBackgroundColor(Color.LTGRAY)


        }

    }
}