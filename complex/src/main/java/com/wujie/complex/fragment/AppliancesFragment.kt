package com.wujie.complex.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wujie.complex.R
import com.wujie.complex.bean.RecyclerInfo
import com.wujie.complex.dapter.ChannelPagerAdapter
import com.wujie.complex.dapter.RecyclerStaggeredAdapter
import com.wujie.complex.widget.SpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_appliances.*

class AppliancesFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var rv_appliances : RecyclerView
    private lateinit var srl_appliances : SwipeRefreshLayout
    private lateinit var adapter : RecyclerStaggeredAdapter
    private var alls = RecyclerInfo.defaultAppi
    private var ctx : Context? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ctx = activity
        val view = inflater.inflate(R.layout.fragment_appliances, container, false)
        rv_appliances = view.findViewById<RecyclerView>(R.id.rv_appliances)
        srl_appliances = view.findViewById(R.id.srl_appliances)
        srl_appliances.setOnRefreshListener(this)
        srl_appliances.setColorSchemeResources(
            R.color.red, R.color.orange, R.color.green, R.color.blue)
        rv_appliances.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        rv_appliances.setHasFixedSize(true)
        adapter = RecyclerStaggeredAdapter(ctx!!, alls)
        rv_appliances.adapter = adapter
        rv_appliances.itemAnimator = DefaultItemAnimator()
        rv_appliances.addItemDecoration(SpacesItemDecoration(3))
        return view
    }

    override fun onRefresh() {
        mHandler.postDelayed(mRefresh, 2000)
    }

    private val mHandler = Handler()
    private val mRefresh = Runnable {
        //下拉刷新结束，要把isRefreshing设置为false，以便从界面上去除转圈图标
        srl_appliances.isRefreshing = false
        val i = alls.size - 1
        var count = 0
        while (count < 5) {
            val item = alls[i]
            alls.removeAt(i)
            alls.add(0, item)
            count++
        }
        //通知循环适配器发生了数据变更
        adapter.notifyDataSetChanged()
        //让循环视图滚动到第0项的位置
        rv_appliances.scrollToPosition(0)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (ctx != null) {
            val intent = Intent(ChannelPagerAdapter.EVENT)
            intent.putExtra("color", ctx!!.resources.getColor(R.color.indigo))
            ctx!!.sendBroadcast(intent)
        }
    }

}