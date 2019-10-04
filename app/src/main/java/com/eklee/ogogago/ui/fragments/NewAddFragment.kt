package com.eklee.ogogago.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.eklee.ogogago.R
import kotlinx.android.synthetic.main.fragment_new_add.*
import kotlinx.android.synthetic.main.layout_keyboard.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by eklee on 2019-09-24.
 */
class NewAddFragment : Fragment() {

    var cal = Calendar.getInstance()

    companion object {
        fun newInstance() = NewAddFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setDatePicker()
        setSpinner()
    }

    private fun setDatePicker(){

        // create an OnDateSetListener
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

        tv_date?.setOnClickListener {
                DatePickerDialog(activity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateDateInView() {
        val myFormat = "yyyy.MM.dd" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.KOREA)
        tv_date?.text = sdf.format(cal.time)
    }

    private fun setSpinner(){

        // 지출/수입 분류
        ArrayAdapter.createFromResource(activity, R.array.categoryList1, android.R.layout.simple_spinner_item).also {
            arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_field1.adapter = arrayAdapter
        }

        spinner_field1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if( p2 > 0 ){
                    tv_giv_name.text =  "나"
                    tv_rec_name.text = "유정"
                }else if( p2 == 2 ){
                    tv_giv_name.text =  "유정"
                    tv_rec_name.text = "나"
                }
            }
        }

        // 카테고리
        ArrayAdapter.createFromResource(activity, R.array.categoryList2, android.R.layout.simple_spinner_item).also {
            arrayAdapter -> arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_field2.adapter = arrayAdapter
        }
        spinner_field2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }


}

