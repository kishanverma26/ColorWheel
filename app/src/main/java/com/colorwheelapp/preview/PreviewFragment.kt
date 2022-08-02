package com.colorwheelapp.preview

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.colorwheelapp.R
import com.colorwheelapp.databinding.FragmentPreviewBinding
import com.colorwheelapp.extensions.android.getViewModel

class PreviewFragment : Fragment(R.layout.fragment_preview) {

    lateinit var fragmentPreviewBinding: FragmentPreviewBinding
    lateinit var viewModel: PreviewViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataBinding(view)
    }

    private fun setupDataBinding(view: View) {
        fragmentPreviewBinding = FragmentPreviewBinding.bind(view)

        fragmentPreviewBinding.colorIndicator.setBackgroundResource(R.drawable.color_indicator)
        fragmentPreviewBinding.viewFirst.setBackgroundResource(R.drawable.color_indicator)
        fragmentPreviewBinding.viewSecond.setBackgroundResource(R.drawable.color_indicator)
        fragmentPreviewBinding.viewThird.setBackgroundResource(R.drawable.color_indicator)
        viewModel = getViewModel()
        fragmentPreviewBinding.viewModel = viewModel



        fragmentPreviewBinding.colorWheel.setRgb(0, 194, 163)
        var intvalue_1=Color.rgb(0, 194, 163)
        var intvalue_2=Color.rgb(75, 165, 79)
        var intvalue_3=Color.rgb(255, 97, 0)
        viewModel.indicatorColor.addOnPropertyChangedCallback( object :Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {

                Log.e( "onPropertyChanged: ",viewModel.selected_pos.get().toString() )

                if (viewModel.selected_pos.get()==0){
                    intvalue_1=fragmentPreviewBinding.colorWheel.rgb
                }
                if (viewModel.selected_pos.get()==1){
                    intvalue_2=fragmentPreviewBinding.colorWheel.rgb
                }

                if (viewModel.selected_pos.get()==2){
                    intvalue_3=fragmentPreviewBinding.colorWheel.rgb
                }


            }

        })


        viewModel.selected_pos.addOnPropertyChangedCallback( object :Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {

                Log.e( "onpro selected_pos: ",viewModel.selected_pos.get().toString() )

                if (viewModel.selected_pos.get()==2){
                    fragmentPreviewBinding.colorWheel.rgb = intvalue_3
                }

                if (viewModel.selected_pos.get()==1){
                    fragmentPreviewBinding.colorWheel.rgb = intvalue_2
                }

                if (viewModel.selected_pos.get()==0){
                    fragmentPreviewBinding.colorWheel.rgb = intvalue_1
                }


            }

        })


    }


}
