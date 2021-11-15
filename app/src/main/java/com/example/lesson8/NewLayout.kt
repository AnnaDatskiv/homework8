package com.example.lesson8

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class NewLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var text1 = findViewById<TextView>(R.id.text1)
    private var text2 = findViewById<TextView>(R.id.text2)
    private var text3 = findViewById<TextView>(R.id.text3)

    init {
        LayoutInflater.from(context).inflate(R.layout.new_layout, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        text1 = getChildAt(0) as TextView
        text2 = getChildAt(1) as TextView
        text3 = getChildAt(2) as TextView
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val maxWidth3 = MeasureSpec.getSize(widthMeasureSpec)
        val unspec = MeasureSpec.makeMeasureSpec(2, MeasureSpec.UNSPECIFIED)
        super.onMeasure(unspec, heightMeasureSpec)
        val curWidth = text3.measuredWidth
        when {
            curWidth>maxWidth3 -> {
                val newSize3 = text3.textSize * maxWidth3.toFloat()/curWidth
                text3.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize3)
                text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize3)
                text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize3)
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}