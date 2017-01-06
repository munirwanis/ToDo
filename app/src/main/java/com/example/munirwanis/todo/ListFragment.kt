package com.example.munirwanis.todo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    var recycler : RecyclerView?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_list, container, false)
        recycler = view.findViewById(R.id.recycler_view) as RecyclerView
        recycler?.setHasFixedSize(true)
        recycler?.layoutManager = LinearLayoutManager(activity)
        // Inflate the layout for this fragment
        return view
    }

    override fun onStart() {
        super.onStart()
        recycler?.adapter = RecyclerAdapter(activity, getToDo(activity))
        recycler?.adapter?.notifyDataSetChanged()
    }

}// Required empty public constructor
