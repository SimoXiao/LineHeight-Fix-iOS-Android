package com.netease.cloudmusic.dolphin.core_dolphin_text

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class FixHeightTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val heightHelper = FixHeightHelper(this)

    init {
        includeFontPadding = false

        attrs?.apply {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.FixHeightTextView, 0, 0)
            val textLineHeight =
                typedArray.getDimensionPixelSize(R.styleable.FixHeightTextView_fixLineHeight, -1)
            if (textLineHeight != -1) {
                setFixLineHeight(textLineHeight)
            }
            val textContent = typedArray.getText(R.styleable.FixHeightTextView_fixContent)
            if (textContent != null) {
                setFixHeightText(textContent)
            }
            typedArray.recycle()
        }
    }

    fun setFixHeightText(text: CharSequence?) {
        heightHelper.setFixHeightText(text)
    }

    fun setFixLineHeight(lineHeight: Int) {
        heightHelper.setSketchLineHeight(lineHeight)
    }

}