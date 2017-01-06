package com.example.munirwanis.todo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import kotlin.jvm.internal.markers.KMutableList

class RecyclerAdapter// Provide a suitable constructor (depends on the kind of dataset)
//todo: change to item array
(private val mContext: Context, var myDataset: MutableList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var mTextView: TextView
            init {
            mTextView = v.findViewById(R.id.text_list) as TextView
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        // create a LayoutInflater to inflate a new view
        val inflater = LayoutInflater.from(mContext)
        // create the new view
        val view = inflater.inflate(R.layout.item_list, parent, false)
        // instanciate the ViewHolder
        val viewHolder = ViewHolder(view)
        // now return it
        return viewHolder
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mTextView.setText(mDataset[position]);
        holder.mTextView.setText(myDataset.get(position))
        holder.mTextView.setOnClickListener { x ->
            deleteToDo(mContext, position)
            notifyDataSetChanged()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return myDataset.size
    }

}