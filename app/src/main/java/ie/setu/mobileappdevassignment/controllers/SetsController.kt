package ie.setu.mobileappdevassignment.controllers

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.models.LegoCollection
import ie.setu.mobileappdevassignment.models.LegoSet
import ie.setu.mobileappdevassignment.utilities.GlobalData
import ie.setu.mobileappdevassignment.utilities.Utils

class SetsController(context: Context) {
    private var globalData = GlobalData
    private val utils = Utils(context)
    private val controller = AddController(context)

    fun getUserSets(): MutableList<LegoSet>{
        val userSets = mutableListOf<LegoSet>()
        for (collection in globalData.loggedUserData.collections){
            for (set in collection.sets){
                userSets.add(set)
            }
        }
        return userSets
    }

    private fun showBottomSheet(context: Context, set: LegoSet, rootContainer: LinearLayout, sets: MutableList<LegoSet>) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_menu, null)

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        view.findViewById<TextView>(R.id.delete_option).setOnClickListener {
            controller.removeSet(set)
            refreshSetViews(context, rootContainer, sets)
            Toast.makeText(context, "Set Removed", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        view.findViewById<TextView>(R.id.edit_option).setOnClickListener {
            Toast.makeText(context, "Editing Set", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        view.findViewById<TextView>(R.id.view_option).setOnClickListener {
            Toast.makeText(context, "Viewing Set", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }
    }

    fun refreshSetViews(context: Context, rootContainer: LinearLayout, sets: MutableList<LegoSet>) {
        rootContainer.removeAllViews()
        addSetView(context, rootContainer, sets)
    }

    fun addSetView(context: Context, rootContainer: LinearLayout, sets: MutableList<LegoSet>) {
        val inflater = LayoutInflater.from(context)

        for (set in sets) {
            val view = inflater.inflate(R.layout.set_card, rootContainer, false)

            val titleText = view.findViewById<TextView>(R.id.title_text)
            val numberText = view.findViewById<TextView>(R.id.id_text)
            val image = view.findViewById<ImageView>(R.id.image)
            val imageButton = view.findViewById<ImageButton>(R.id.imageButton)

            imageButton.setOnClickListener {
                showBottomSheet(context, set, rootContainer, sets)
            }

            view.setOnClickListener {
                Toast.makeText(context, "Clicked Set", Toast.LENGTH_SHORT).show()
            }

            titleText.text = set.name
            numberText.text = set.setNumber.toString()

            rootContainer.addView(view)
            Log.d("added", "set")
        }
    }

}