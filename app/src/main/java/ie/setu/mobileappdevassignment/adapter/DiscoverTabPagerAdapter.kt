package ie.setu.mobileappdevassignment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ie.setu.mobileappdevassignment.fragment.DiscoverCollectionFragment
import ie.setu.mobileappdevassignment.fragment.DiscoverSetFragment

class DiscoverTabPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DiscoverCollectionFragment()
            1 -> DiscoverSetFragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}
