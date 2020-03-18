package com.wujie.complex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import com.wujie.complex.bean.GoodsInfo
import kotlinx.android.synthetic.main.activity_fragment_dynamic.*

class FragmentDynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_dynamic)

        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        //碎片适配器需要传入碎片管理器对象supportFragmentManager
        vp_content.adapter = MobilePagerAdapter(supportFragmentManager, GoodsInfo.defaultList)
        vp_content.currentItem = 0
    }

}