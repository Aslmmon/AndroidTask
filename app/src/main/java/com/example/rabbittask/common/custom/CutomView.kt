package com.example.rabbittask.common.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.rabbittask.R

class CustomView(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        inflate(context, R.layout.custom_view, this)

        val imageView: ImageView = findViewById(R.id.iv_hotspot_icon)
        val textView: TextView = findViewById(R.id.tv_title)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.custom_view)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.custom_view_image))
        textView.text = attributes.getString(R.styleable.custom_view_text)
        attributes.recycle()

    }
}