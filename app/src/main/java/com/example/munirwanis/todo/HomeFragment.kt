package com.example.munirwanis.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.support.design.widget.Snackbar


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_home, container, false)
        val textView = v.findViewById(R.id.text_view_fragment_home) as TextView
        textView.setOnClickListener { }
        val button = v.findViewById(R.id.add_item_button) as Button
        val editText = v.findViewById(R.id.editText) as EditText

        button.setOnClickListener { v ->
            if (editText.text.toString().isNullOrEmpty()) {
                Snackbar.make(v, getString(R.string.error_fragment), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
            else saveToDo(context, editText.text.toString())
        }
        // Inflate the layout for this fragment
        return v
    }

}// Required empty public constructor
