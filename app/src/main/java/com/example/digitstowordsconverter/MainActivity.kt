package com.example.digitstowordsconverter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var converter: Button
    private lateinit var num: EditText
    private lateinit var word: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        converter = findViewById(R.id.converterButton)
        num = findViewById(R.id.num)
        word = findViewById(R.id.word)

        converter.setOnClickListener {
            fun numberToWord(num: Int): String {


                var number = num
                var words = ""
                val unitsArray = arrayOf(
                    "ნული", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი", "ექვსი",
                    "შვიდი", "რვა", "ცხრა", "ათი", "თერთმეტი", "თორმეტი",
                    "ცამეტი", "თოთხმეტი", "თხუთმეტი", "თექსვმეტი", "ჩიდმეტი",
                    "თვრამეტი", "ცხრამეტი"
                )
                val tensArray = arrayOf(
                    "ნული", "ათი", "ოცი", "ოცდაათი", "ორმოცი", "ორმოცდაათი",
                    "სამოცი", "სამოცდაათი", "ოთხმოცი", "ოთხმოცდაათი"
                )
                if (number == 0) {
                    return "ნული"
                }


                if (number < 0) {

                    var numberStr = "" + number
                    numberStr = numberStr.substring(1)
                    return "minus " + numberToWord(numberStr.toInt())
                }




                if (number / 1000 > 0) {
                    words += numberToWord(number / 1000) + " ათას "
                    number %= 1000
                }


                if (number / 100 > 0) {
                    words += numberToWord(number / 100) + " ას "
                    number %= 100
                }

                if (number > 0) {
                    if (number < 20) {
                        words += unitsArray[number]
                    } else {
                        words += tensArray[(number / 10)]
                        if (number % 10 > 0) {
                            words += "-" + unitsArray[(number % 10)]
                        }
                    }
                }



                return words
            }

        }
    }
}

