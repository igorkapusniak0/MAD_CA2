package ie.setu.mobileappdevassignment.activities

import com.google.android.material.bottomnavigation.BottomNavigationView
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.controllers.AddController
import ie.setu.mobileappdevassignment.controllers.SetsController
import ie.setu.mobileappdevassignment.databinding.ActivityListBinding
import ie.setu.mobileappdevassignment.utilities.NavigationUtils

class SetsActivity : ListActivity<ActivityListBinding>() {

    private lateinit var controller: SetsController
    private lateinit var addController: AddController

    override fun inflateBinding() = ActivityListBinding.inflate(layoutInflater)

    override fun setupContent() {
        val navView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUtils.setupBottomNavigation(this, navView)

        controller = SetsController(this)
        addController = AddController(this)
        val collectionName = intent.getStringExtra("collection_name")
        val sets = if (collectionName == null){
            controller.getUserSets()
        } else{
            addController.getSetsFromCollectionName(collectionName).sets
        }
        controller.addSetView(this, rootContainer, sets)
    }
}
