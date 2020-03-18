package com.wujie.complex

import android.os.Bundle
import android.support.v4.widget.Space
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.LinearLayout
import com.wujie.complex.bean.RecyclerInfo
import com.wujie.complex.dapter.RecyclerStaggeredAdapter
import com.wujie.complex.widget.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_recycler_staggere.*

class RecyclerStaggeredActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_staggere)

        rv_staggered.layoutManager = StaggeredGridLayoutManager(3, LinearLayout.VERTICAL)
        val adapter = RecyclerStaggeredAdapter(this, RecyclerInfo.defaultStag)
        rv_staggered.adapter = adapter
        rv_staggered.itemAnimator = DefaultItemAnimator()
        rv_staggered.addItemDecoration(SpacesItemDecoration(3))
    }

}