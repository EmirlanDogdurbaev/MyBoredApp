package com.example.boredapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.boredapp.R
import com.example.boredapp.adapter.ViewPagerAdapter

class ViewPagerItemFragment : Fragment() {
    private var imageResId: Int = -1
    private var text: String = ""
    private var isLastItem: Boolean = false

    companion object {
        private const val ARG_IMAGE_RES_ID = "imageResId"
        private const val ARG_TEXT = "text"
        private const val ARG_IS_LAST_ITEM = "isLastItem"

        fun newInstance(imageResId: Int, text: String, isLastItem: Boolean): ViewPagerItemFragment {
            val fragment = ViewPagerItemFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RES_ID, imageResId)
            args.putString(ARG_TEXT, text)
            args.putBoolean(ARG_IS_LAST_ITEM, isLastItem)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(ARG_IMAGE_RES_ID)
            text = it.getString(ARG_TEXT).toString()
            isLastItem = it.getBoolean(ARG_IS_LAST_ITEM, false)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager_item, container, false)
        view.findViewById<ImageView>(R.id.vp_image).setImageResource(imageResId)
        view.findViewById<TextView>(R.id.vp_text).text = text

        view.findViewById<Button>(R.id.vp_btn_start).setOnClickListener {
            findNavController().navigate(R.id.action_ViewPagerFragment_to_MainFragment)
        }
        view.findViewById<Button>(R.id.vp_btn_start).visibility = if (isLastItem) View.VISIBLE else View.INVISIBLE

        return view
    }
}