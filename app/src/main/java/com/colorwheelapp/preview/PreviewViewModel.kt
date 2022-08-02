package com.colorwheelapp.preview

import android.graphics.Color
import android.util.Log
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.colorwheelapp.utils.setColorAlpha

class PreviewViewModel : ViewModel() {

    var indicatorColor = ObservableInt(Color.argb(1,0, 194, 163))
    var indicatorColor_first = ObservableInt(Color.rgb(0, 194, 163))
    var indicatorColor_second = ObservableInt(Color.rgb(75, 165, 79))
    var indicatorColor_third = ObservableInt(Color.rgb(255, 97, 0))
    var selected_pos = ObservableInt(0)


    fun onColorChanged(valueGradient: Int, alphaGradientColor: Int) {
        indicatorColor.set(setColorAlpha(valueGradient, alphaGradientColor))

        when(selected_pos.get()){
            0->{
                indicatorColor_first.set(setColorAlpha(valueGradient, alphaGradientColor))
            }
            1->{
                indicatorColor_second.set(setColorAlpha(valueGradient, alphaGradientColor))
            }
            2->{
                indicatorColor_third.set(setColorAlpha(valueGradient, alphaGradientColor))
            }
        }

    }

    fun changeselected_pos(pos:Int){

        when(pos){
            0->{
                indicatorColor.set(indicatorColor_first.get())

            }
            1->{


                indicatorColor.set(indicatorColor_second.get())


            }
            2->{
                indicatorColor.set(indicatorColor_third.get())

            }

        }
        selected_pos.set(pos)

    }



}
