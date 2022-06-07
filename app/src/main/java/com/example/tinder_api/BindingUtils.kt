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
fun Button.setStatus(status: String) {
    print("dsewq setStatus Called\n")
    status.let {
        text = when (status) {
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
fun TextView.setText(status: String) {
    print("dsewq setText Called\n")
    status.let {
        if(status != "null"){
            visibility = View.VISIBLE
            text = status
        }
        else{
            visibility = View.GONE
        }
    }
}
