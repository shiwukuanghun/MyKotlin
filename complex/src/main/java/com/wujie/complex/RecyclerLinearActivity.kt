package com.wujie.complex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.wujie.complex.bean.RecyclerInfo
import com.wujie.complex.dapter.RecyclerLinearAdapter
import com.wujie.complex.widget.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_recycler_linear.*

class RecyclerLinearActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_linear)

        rv_linear.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerLinearAdapter(this, RecyclerInfo.defaultList)
        adapter.setOnItemClickListener(adapter)
        adapter.setOnItemLongClickListener(adapter)
        rv_linear.adapter = adapter
        rv_linear.itemAnimator = DefaultItemAnimator()
        rv_linear.addItemDecoration(SpacesItemDecoration(1))
    }

}