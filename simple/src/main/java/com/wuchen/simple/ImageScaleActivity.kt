package com.wuchen.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_image_scale.*

/**
 * Time：2019/5/23 11:46
 * Author：WuChen
 * Description：
 * **/
class ImageScaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_scale)
        iv_scale.setImageResource(R.drawable.apple1)
        btn_center.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.CENTER }
        btn_fitCenter.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.FIT_CENTER }
        btn_centerCrop.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.CENTER_CROP }
        btn_centerInside.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.CENTER_INSIDE }
        btn_fitXY.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.FIT_XY }
        btn_fitStart.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.FIT_START }
        btn_fitEnd.setOnClickListener { iv_scale.scaleType = ImageView.ScaleType.FIT_END }
    }

}