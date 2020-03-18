package com.wujie.complex.dapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.wujie.complex.R
import com.wujie.complex.bean.Planet
import org.jetbrains.anko.toast

class PlanetGridAdapter(private val context: Context, private val planetList: MutableList<Planet>, private val background: Int) : BaseAdapter(),
    AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        val desc = "您长按了第${position+1}个行星，它的名字是${planetList[position].name}"
        context.toast(desc)
        return true
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val desc = "您点击了第${position+1}个行星，它的名字是${planetList[position].name}"
        context.toast(desc)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var holder : ViewHolder
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_grid_view, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else{
            holder = view.tag as ViewHolder
        }
        val planet = planetList[position]
        holder.ll_item.setBackgroundColor(background)
        holder.iv_icon.setImageResource(planet.image)
        holder.tv_name.text = planet.name
        holder.tv_desc.text = planet.desc
        return view!!
    }

    override fun getItem(position: Int): Any = planetList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = planetList.size

    inner class ViewHolder(val view :View) {
        //findViewById后面直接跟上“<视图类型>”，即可起到关键字as强制转换类型的功能
        val ll_item: LinearLayout = view.findViewById<LinearLayout>(R.id.ll_item)
        val iv_icon: ImageView = view.findViewById<ImageView>(R.id.iv_icon)
        val tv_name: TextView = view.findViewById<TextView>(R.id.tv_name)
        val tv_desc: TextView = view.findViewById<TextView>(R.id.tv_desc)
    }
}