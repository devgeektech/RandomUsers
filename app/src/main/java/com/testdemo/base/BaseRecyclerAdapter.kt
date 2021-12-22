package com.testdemo

import android.R
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.StateListDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider
import com.google.android.material.switchmaterial.SwitchMaterial
import javax.inject.Inject


abstract class BaseRecyclerAdapter<VM : RecyclerView.ViewHolder> : RecyclerView.Adapter<VM>() {
    val TAG = javaClass.simpleName

    @Inject
    //switch buttons Theme
    fun setToggleBackgroung(toggleButton: SwitchMaterial, themeColor: String) {
        val states: Array<IntArray> =
            arrayOf<IntArray>(intArrayOf(-R.attr.state_checked), intArrayOf(R.attr.state_checked))

        val thumbColors = intArrayOf(
            Color.WHITE,
            Color.WHITE
        )

        val trackColors = intArrayOf(
            Color.GRAY,
            Color.parseColor(themeColor)
        )
        DrawableCompat.setTintList(
            DrawableCompat.wrap(toggleButton.thumbDrawable),
            ColorStateList(states, thumbColors)
        )
        DrawableCompat.setTintList(
            DrawableCompat.wrap(toggleButton.trackDrawable),
            ColorStateList(states, trackColors)
        )
    }

    fun setIconTint(imageView: ImageView, themeColor: String) {
        imageView.setColorFilter(Color.parseColor(themeColor))
    }

    fun setBackgroundTint(view: View, themeColor: String) {
        view.backgroundTintList = ColorStateList.valueOf(Color.parseColor(themeColor))
    }

    fun setProgressBackground(slider: Slider, themeColor: String) {
        slider.trackActiveTintList = ColorStateList.valueOf(Color.parseColor(themeColor))
    }

    fun setButtonColor(materialButton: MaterialButton, themeColor: String) {
        ColorStateList.valueOf(Color.parseColor(themeColor)).apply {
            materialButton.setTextColor(this)
            materialButton.iconTint = this
            materialButton.rippleColor = this
        }
    }
}