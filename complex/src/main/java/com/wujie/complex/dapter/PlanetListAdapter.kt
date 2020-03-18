package com.wujie.complex.dapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.wujie.complex.R
import com.wujie.complex.bean.Planet
import org.jetbrains.anko.toast

//ViewHolder中的属性使用关键字lateinit延迟初始化
class PlanetListAdapter(private val context:Context, private val planetList:MutableList<Planet>, private val background:Int) : BaseAdapter(),
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
        val holder : ViewHolder
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_view, null)
            holder = ViewHolder()
            //先声明视图持有者的实例，再依次获取内部的各个控件对象
            //findViewById后面直接跟上“<视图类型>”，即可起到关键字as强制转换类型的功能
            holder.ll_item =  view.findViewById<LinearLayout>(R.id.ll_item)
            holder.iv_icon = view.findViewById<ImageView>(R.id.iv_icon)
            holder.tv_name = view.findViewById<TextView>(R.id.tv_name)
            holder.tv_desc = view.findViewById<TextView>(R.id.tv_desc)
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

    override fun getCount(): Int= planetList.size

    inner class ViewHolder {
        lateinit var ll_item: LinearLayout
        lateinit var iv_icon: ImageView
        lateinit var tv_name: TextView
        lateinit var tv_desc: TextView
    }

}