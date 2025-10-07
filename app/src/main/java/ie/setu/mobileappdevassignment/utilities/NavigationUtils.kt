package ie.setu.mobileappdevassignment.utilities

import android.app.Activity
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.activities.AddActivity
import ie.setu.mobileappdevassignment.activities.CollectionsActivity
import ie.setu.mobileappdevassignment.activities.DiscoverActivity
import ie.setu.mobileappdevassignment.activities.MapActivity
import ie.setu.mobileappdevassignment.activities.SetsActivity

object NavigationUtils {

    fun setupBottomNavigation(activity: Activity, navView: BottomNavigationView) {
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_collections -> {
                    if (activity !is CollectionsActivity) {
                        activity.startActivity(Intent(activity, CollectionsActivity::class.java))
                        activity.finish()
                    }
                    true
                }
                R.id.nav_Sets -> {
                    if (activity !is SetsActivity) {
                        activity.startActivity(Intent(activity, SetsActivity::class.java))
                        activity.finish()
                    }
                    true
                }
                R.id.nav_Add -> {
                    if (activity !is AddActivity) {
                        activity.startActivity(Intent(activity, AddActivity::class.java))
                        activity.finish()
                    }
                    true
                }
                R.id.nav_map -> {
                    if (activity !is MapActivity) {
                        activity.startActivity(Intent(activity, MapActivity::class.java))
                        activity.finish()
                    }
                    true
                }
                R.id.nav_discover -> {
                    if (activity !is DiscoverActivity) {
                        activity.startActivity(Intent(activity, DiscoverActivity::class.java))
                        activity.finish()
                    }
                    true
                }
                else -> false
            }
        }
    }
}