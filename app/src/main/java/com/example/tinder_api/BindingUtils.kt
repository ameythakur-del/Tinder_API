package com.example.tinder_api

import android.content.ContentValues.TAG
import android.provider.Telephony.Mms.Part.TEXT
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.ViewUtils
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.tinder_api.database.room.model.Result
import com.example.tinder_api.util.ACCEPTED
import com.example.tinder_api.util.DECLINED
import com.example.tinder_api.util.UNDECIDED
import org.w3c.dom.Text
import org.xmlpull.v1.XmlPullParser.TEXT


@BindingAdapter("set_status")
fun Button.setStatus(item: Result) {
    item.let {
        text = when (item.status) {
            ACCEPTED, DECLINED -> {
                visibility = View.GONE
                return
            }
            else -> {
                visibility = View.VISIBLE
                return
            }
        }
    }
}

@BindingAdapter("set_text")
fun TextView.setText(item: Result) {
    item.let {
        if(item.status != "null"){
            visibility = View.VISIBLE
            text = item.status
        }
        else{
            visibility = View.GONE
        }
    }
}
