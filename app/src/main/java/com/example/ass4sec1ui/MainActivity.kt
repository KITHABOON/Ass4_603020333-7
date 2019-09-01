package com.example.ass4sec1ui


import android.app.Activity;
import android.app.DatePickerDialog
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import java.text.SimpleDateFormat

public class MainActivity : AppCompatActivity() {

    var formate = SimpleDateFormat("dd / MM / YYYY",Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()

        btn_pickDate.setOnClickListener{
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    c.set(Calendar.YEAR,year)
                    c.set(Calendar.MONTH,month)
                    c.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                   val date = formate.format(c.time)
                    text_date.setText(date)
               },
                c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH))
                datePicker.show()
        }
//        btn_pickDate.setOnClickListener{
//            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, mYear, mMonth, mDay ->
//                text_date.setText(""+mDay+"/"+mMonth+"/"+mYear)
//            },year, month, day)
//            dpd.show()
//        }
    }
    fun radio_button_click(){
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}", Toast.LENGTH_SHORT).show()
    }

    fun showDetail(){
        try {
            val radio: RadioButton = findViewById(group.checkedRadioButtonId)
            text_show.text =
                "Username: ${edit_id.text}\nPassword: ${edit_name.text}\nGender: ${radio.text}\nEmail: ${edit_email.text} \nDate: ${text_date.text}"
        }catch(e: Exception){
            Toast.makeText(this,"Please Enter",Toast.LENGTH_SHORT).show()
        }
    }
    fun reset(){
        edit_id.text.clear()
        edit_name.text.clear()
        group.clearCheck()
        edit_email.text.clear()
        text_date.text="dd / MM / yyyy"
        text_show.text ="Show detail"
    }
}
