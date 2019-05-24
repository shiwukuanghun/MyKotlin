package com.wuchen.simple.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Time：2019/5/23 14:07
 * Author：WuChen
 * Description：
 * **/
@Parcelize
data class MessageInfo(val content:String, val send_time:String) :Parcelable {
}