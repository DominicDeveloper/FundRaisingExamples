package com.example.projectworkaprilkumak.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.adapters.ViewPagerAdapter
import com.example.projectworkaprilkumak.databinding.FragmentViewPagerBinding
import com.example.projectworkaprilkumak.datas.ViewPagerData
import kotlinx.coroutines.flow.combine


class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentViewPagerBinding.inflate(inflater, container, false)

       setupViewPager2()

       return binding.root
    }

    fun setupViewPager2() {
        val vlist : MutableList<ViewPagerData> = ArrayList()
        vlist.add(ViewPagerData(R.drawable.intro1pic, "Donate easily, quickly, right on target all over the world", "Lorem ipsum was fjakfja af akfaj afkdafjj conceived as filler text, formatted in a certain way"))
        vlist.add(ViewPagerData(R.drawable.intro2pic, "Create your own fundraising and publish it to the world", "Lorem ipsum was fjakfja af akfaj afkdafjj conceived as filler text, formatted in a certain way"))
        vlist.add(ViewPagerData(R.drawable.intro3, "Trusted, transparent, and effective in sharing kindness", "Lorem ipsum was fjakfja af akfaj afkdafjj conceived as filler text, formatted in a certain way"))

        binding.viewpager.adapter = ViewPagerAdapter(vlist)


    }
}