package com.example.dinko

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val categoryArray= arrayOf("Home","Health","Sports","Entertainment","Science","Technology")


    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1 -> return HealthFragment()
            2 -> return SportsFragment()
            3 -> return EntertainmentFragment()
            4 -> return ScienceFragment()
            5 -> return TechFragment()
        }
        return HomeFragment()
    }
    override fun getItemCount(): Int {
        return categoryArray.size
    }
}