package ie.setu.mobileappdevassignment.activities

import com.google.android.material.bottomnavigation.BottomNavigationView
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.controllers.CollectionsController
import ie.setu.mobileappdevassignment.databinding.ActivityListBinding
import ie.setu.mobileappdevassignment.utilities.NavigationUtils

class CollectionsActivity : ListActivity<ActivityListBinding>() {

    private lateinit var controller: CollectionsController

    override fun inflateBinding() = ActivityListBinding.inflate(layoutInflater)

    override fun setupContent() {
        val navView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUtils.setupBottomNavigation(this, navView)

        controller = CollectionsController(this)
        val collections = controller.getUserCollections()
        controller.addCollectionView(this, rootContainer, collections)

    }
}
