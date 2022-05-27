package com.netease.cloudmusic.dolphin.core_dolphin_text

import android.graphics.Paint
import android.text.style.LineHeightSpan

class FixHeightLineSpaceSpan : LineHeightSpan {

    private var mHeight: Int = 0

    constructor() {
    }

    constructor(initHeight: Int) {
        setHeight(initHeight)
    }

    fun setHeight(height: Int) {
        if (height > 0) {
            mHeight = height
        }
    }

    fun getHeight(): Int {
        return mHeight
    }

    override fun chooseHeight(
        text: CharSequence?,
        start: Int,
        end: Int,
        spanstartv: Int,
        lineHeight: Int,
        fm: Paint.FontMetricsInt?
    ) {
        if (fm == null) {
            return
        }
        val originHeight = fm.descent - fm.ascent
        if (originHeight <= 0) {
            return
        }
        val diff: Float = (mHeight - originHeight).toFloat()
        fm.ascent = fm.ascent - Math.round(diff / 2)
        fm.descent = mHeight + fm.ascent
    }
}