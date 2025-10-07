package ie.setu.mobileappdevassignment.controllers

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.activities.CollectionsActivity
import ie.setu.mobileappdevassignment.activities.SetsActivity
import ie.setu.mobileappdevassignment.utilities.GlobalData
import ie.setu.mobileappdevassignment.models.LegoCollection
import ie.setu.mobileappdevassignment.models.LegoSet
import ie.setu.mobileappdevassignment.utilities.Utils


class CollectionsController(context: Context) {
    private var globalData = GlobalData
    private val utils = Utils(context)
    private val controller = AddController(context)

    fun getUserCollections(): MutableList<LegoCollection>{
        return globalData.loggedUserData.collections
    }

    private fun showBottomSheet(context: Context, collection: LegoCollection, rootContainer: LinearLayout, collections: MutableList<LegoCollection>) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_menu, null)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        view.findViewById<TextView>(R.id.delete_option).setOnClickListener {
            controller.removeCollection(collection)
            refreshCollectionsViews(context, rootContainer, collections)
            Toast.makeText(context, "Collection Removed", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        view.findViewById<TextView>(R.id.edit_option).setOnClickListener {
            Toast.makeText(context, "Editing Collection", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        view.findViewById<TextView>(R.id.view_option).setOnClickListener {
            Toast.makeText(context, "Viewing Collection", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }
    }

    fun refreshCollectionsViews(context: Context, rootContainer: LinearLayout, collections: MutableList<LegoCollection>) {
        rootContainer.removeAllViews()
        addCollectionView(context, rootContainer, collections)
    }
    fun addCollectionView(context: Context, rootContainer: LinearLayout, collections: MutableList<LegoCollection>) {
        val inflater = LayoutInflater.from(context)

        for (collection in collections) {
            val view = inflater.inflate(R.layout.collection_card, rootContainer, false)

            val titleText = view.findViewById<TextView>(R.id.title_text)
            val descriptionText = view.findViewById<TextView>(R.id.description_text)
            val dateText = view.findViewById<TextView>(R.id.date_text)
            val numberOfSets = view.findViewById<TextView>(R.id.number_of_sets_text)
            val imageButton = view.findViewById<ImageButton>(R.id.imageButton)

            imageButton.setOnClickListener {
                showBottomSheet(context, collection, rootContainer, collections)
            }

            view.setOnClickListener {
                Toast.makeText(context, "Clicked Collection", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, SetsActivity::class.java)
                intent.putExtra("collection_name", collection.name)

                if (context !is android.app.Activity) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
                if (context is android.app.Activity) {
                    context.finish()
                }
            }



            titleText.text = collection.name
            descriptionText.text = collection.description
            dateText.text = collection.creationDate
            numberOfSets.text = collection.numberOfSets().toString()


            rootContainer.addView(view)
            Log.d("added", "collection")
        }
    }

}