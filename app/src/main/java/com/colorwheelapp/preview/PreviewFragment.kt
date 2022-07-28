package com.colorwheelapp.preview

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.colorwheelapp.R
import com.colorwheelapp.databinding.FragmentPreviewBinding
import com.colorwheelapp.extensions.android.getViewModel

class PreviewFragment : Fragment(R.layout.fragment_preview) {

    lateinit var fragmentPreviewBinding: FragmentPreviewBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataBinding(view)
    }

    private fun setupDataBinding(view: View) {
        fragmentPreviewBinding = FragmentPreviewBinding.bind(view)

        fragmentPreviewBinding.colorIndicator.setBackgroundResource(R.drawable.color_indicator)
        fragmentPreviewBinding.viewModel = getViewModel()

        fragmentPreviewBinding.colorWheel.setRgb(0, 194, 163)


        fragmentPreviewBinding.rlTeal.setOnClickListener { changeColor(0) }
      fragmentPreviewBinding.rlGreen.setOnClickListener { changeColor(1) }
      fragmentPreviewBinding.rlOrange.setOnClickListener { changeColor(2) }



    }

    fun changeColor(position:Int){
        when(position){
            0 ->{
                fragmentPreviewBinding.colorWheel.setRgb(0, 194, 163)

                fragmentPreviewBinding.rlTeal.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.selected_color))
                fragmentPreviewBinding.rlGreen.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.eliment_color))
                fragmentPreviewBinding.rlOrange.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.eliment_color))
            }
            1 ->{

                fragmentPreviewBinding.colorWheel.setRgb(75, 165, 79)
                fragmentPreviewBinding.rlTeal.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.eliment_color))
                fragmentPreviewBinding.rlGreen.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.selected_color))
                fragmentPreviewBinding.rlOrange.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.eliment_color))
            }
             2 ->{
                 fragmentPreviewBinding.colorWheel.setRgb(255, 97, 0)
                 fragmentPreviewBinding.rlTeal.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.eliment_color))
                fragmentPreviewBinding.rlGreen.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.eliment_color))
                fragmentPreviewBinding.rlOrange.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.selected_color))
            }
        }
    }
}
