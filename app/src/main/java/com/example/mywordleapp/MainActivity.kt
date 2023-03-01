package com.example.mywordleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.mywordleapp.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //obtain 4 letter word to match against
        var wordToGuess = getRandomFourLetterWord()

        //variables
        var mybutton=findViewById<Button>(R.id.button)
        var guessinput = findViewById<EditText>(R.id.input)
        var guess1 = findViewById<TextView>(R.id.guess1)
        var guess1checklabel = findViewById<TextView>(R.id.guess1checklabel)
        var guesscheck1 = findViewById<TextView>(R.id.guess1check)
        var guess2label= findViewById<TextView>(R.id.guess2label)
        var guess2=findViewById<TextView>(R.id.guess2)
        var guess2checklabel=findViewById<TextView>(R.id.guess2checklabel)
        var guess2check=findViewById<TextView>(R.id.guess2check)
        var count=0;
        var guess3=findViewById<TextView>(R.id.guess3)
        var guess3label=findViewById<TextView>(R.id.guess3label)
        var guess3checklabel=findViewById<TextView>(R.id.guess3checklabel)
        var guess3check=findViewById<TextView>(R.id.guess3check)
        var myanswer=findViewById<TextView>(R.id.answer)
        var testvar=4

//test channge for github


        mybutton.setOnClickListener{
            Toast.makeText(getApplicationContext(),"Good Guess!",Toast.LENGTH_SHORT).show()
            count++
            if(count==1) {
                // guessinput.setText(guessinput.toString())
                guess1.text=guessinput.text.toString().uppercase()
                guess1.visibility = View.VISIBLE
                var checkstring1=guess1.text
                var check1result = checkGuess(checkstring1.toString(), wordToGuess)
                guess1checklabel.visibility = View.VISIBLE
                guesscheck1.text = check1result
                guesscheck1.visibility = View.VISIBLE
                if(wordToGuess==checkstring1.toString()){
                    Toast.makeText(getApplicationContext(),"Your Correct!", Toast.LENGTH_LONG).show()
                    mybutton.visibility=View.INVISIBLE
                    guessinput.visibility=View.INVISIBLE
                    myanswer.text = "YOU WIN!"
                    myanswer.visibility=View.VISIBLE
                }
                Toast.makeText(getApplicationContext(), "Guess Again!", Toast.LENGTH_SHORT).show()
            }

            if(count==2) {
                //guessinput.setText(guessinput.toString())
                guess2.text = guessinput.text.toString().uppercase()
                guess2label.visibility=View.VISIBLE
                guess2.visibility = View.VISIBLE
                var checkstring2=guess2.text
                var check2result = checkGuess(checkstring2.toString(), wordToGuess)
                guess2checklabel.visibility = View.VISIBLE
                guess2check.text = check2result
                guess2check.visibility = View.VISIBLE
                if(wordToGuess==checkstring2.toString()){
                    Toast.makeText(getApplicationContext(),"Your Correct!", Toast.LENGTH_LONG).show()
                    mybutton.visibility=View.INVISIBLE
                    guessinput.visibility=View.INVISIBLE
                    myanswer.text = "YOU WIN!"
                    myanswer.visibility=View.VISIBLE
                }
                Toast.makeText(getApplicationContext(), "Guess Again!", Toast.LENGTH_SHORT).show()
            }
            if(count==3){
                guess3.text=guessinput.text.toString().uppercase()
                guess3label.visibility=View.VISIBLE
                guess3.visibility=View.VISIBLE
                var checkstring3=guess3.text
                var check3result=checkGuess(checkstring3.toString(),wordToGuess)
                guess3checklabel.visibility=View.VISIBLE
                guess3check.text=check3result
                guess3check.visibility=View.VISIBLE
                if(wordToGuess==checkstring3.toString()){
                    mybutton.visibility=View.INVISIBLE
                    guessinput.visibility=View.INVISIBLE
                    myanswer.text = "YOU WIN!"
                    myanswer.visibility=View.VISIBLE
                    Toast.makeText(getApplicationContext(),"Your Correct!", Toast.LENGTH_LONG).show()

                }


                else{
                    guessinput.hint="Your Out of Guesses"
                    guessinput.visibility=View.INVISIBLE
                    mybutton.text="Reveal"
                    mybutton.setOnClickListener {
                        myanswer.text = wordToGuess
                        myanswer.visibility = View.VISIBLE
                        Toast.makeText(getApplicationContext(), "Thanks for Playing!", Toast.LENGTH_LONG).show()
                    }
                }

            }


        }

    }


    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}