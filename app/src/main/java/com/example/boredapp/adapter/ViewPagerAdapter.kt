package com.example.boredapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.boredapp.R
import com.example.boredapp.databinding.FragmentViewPagerItemBinding
import com.example.boredapp.ui.fragments.ViewPagerItemFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val images = listOf(
        R.drawable.q1,
        R.drawable.q2,
        R.drawable.a3
    )

    private val texts = listOf(
        "Наш разум нуждается в книгах, как меч - в точильном камне, чтобы не затупиться.\n Джордж Мартин",
        "Лучший в мире кинозал - это мозг, и ты понимаешь это, когда читаешь хорошую книгу.\n Ридли Скотт",
        "Чтение для ума - то же, что физические упражнения для тела.\n Джозеф Аддисон"
    )

    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment {
        return ViewPagerItemFragment().apply {
            arguments = Bundle().apply {
                putInt("imageResId", images[position])
                putString("text", texts[position])
                putBoolean("isLastItem", position == itemCount - 1)
            }
        }
    }
}
