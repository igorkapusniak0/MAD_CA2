package ie.setu.mobileappdevassignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.adapter.AddTabPagerAdapter
import ie.setu.mobileappdevassignment.utilities.NavigationUtils

class AddActivity: AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val navView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUtils.setupBottomNavigation(this, navView)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        val adapter = AddTabPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.add_collection)
                1 -> getString(R.string.add_set)
                else -> null
            }
        }.attach()


    }
}