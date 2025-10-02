package ie.setu.mobileappdevassignment.controllers

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.models.LegoSet
import ie.setu.mobileappdevassignment.utilities.GlobalData
import ie.setu.mobileappdevassignment.utilities.Utils

class SetsController(context: Context) {
    private var globalData = GlobalData
    private val utils = Utils(context)

    fun getUserSets(): MutableList<LegoSet>{
        val userSets = mutableListOf<LegoSet>()
        for (collection in globalData.loggedUserData.collections){
            for (set in collection.sets){
                userSets.add(set)
            }
        }
        userSets.addAll(globalData.loggedUserData.sets)

        return userSets
    }

    fun addSetView(context: Context, rootContainer: LinearLayout) {
        val inflater = LayoutInflater.from(context)
        val sets = getUserSets()

        for (set in sets) {
            val view = inflater.inflate(R.layout.set_card, rootContainer, false)

            val titleText = view.findViewById<TextView>(R.id.title_text)
            val numberText = view.findViewById<TextView>(R.id.id_text)
            val image = view.findViewById<ImageView>(R.id.image)

            titleText.text = set.name
            numberText.text = set.setNumber.toString()

            rootContainer.addView(view)
            Log.d("added", "set")
        }
    }

}