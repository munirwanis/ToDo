package com.example.munirwanis.todo

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


/**
 * Created by munirwanis on 05/01/17.
 */

object Utility

fun getToDo(context: Context): MutableList<String> {
    var toDoList: MutableList<String> = ArrayList()
    val sharedPref = context.getSharedPreferences("ToDoTable", Context.MODE_PRIVATE)
    val json = sharedPref.getString("ToDoList", null)
    val collectionType = object : TypeToken<Collection<String>>() {}.type
    if (json == null) return toDoList
    toDoList = Gson().fromJson(json, collectionType)
    return toDoList
}

fun saveToDo(context: Context, itemToDo: String) {
    val toDoList: MutableList<String> = getToDo(context)
    toDoList.add(itemToDo)
    val sharedPref = context.getSharedPreferences("ToDoTable", Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    editor.putString("ToDoList", Gson().toJson(toDoList))
    editor.apply()
}

fun saveToDo(context: Context, itemList: MutableList<String>) {
    val sharedPref = context.getSharedPreferences("ToDoTable", Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    editor.putString("ToDoList", Gson().toJson(itemList))
    editor.apply()
}

fun deleteToDo(context: Context, position: Int) {
    var toDoList = getToDo(context)
    toDoList.removeAt(position)
    saveToDo(context, toDoList)
}