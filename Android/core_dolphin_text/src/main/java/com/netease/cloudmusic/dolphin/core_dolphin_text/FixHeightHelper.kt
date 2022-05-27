package com.netease.cloudmusic.dolphin.core_dolphin_text

import android.content.res.Resources
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.widget.TextView
import kotlin.math.roundToInt

class FixHeightHelper(val textView: TextView) {

    var lineHeight: Int = 0
    var textHeight: Int = 0
    private val heightSpan =
        FixHeightLineSpaceSpan()

    private fun getSketchHeight(textSize: Float, resources: Resources): Int {
        val scaledTextSize: Int = (textSize / resources.displayMetrics.density).roundToInt()
        return (scaledTextSize * TEXT_HEIGHT_RATIO).roundToInt().dp(resources)
    }

    fun setSketchLineHeight(lineHeight: Int) {
        if (lineHeight > 0) {
            this.lineHeight = lineHeight
            setFixHeightText(textView.text, lineHeight)
        }
    }

    fun setFixHeightText(text: CharSequence?) {
        if (lineHeight > 0) {
            setFixHeightText(text, lineHeight)
        } else {
            textHeight = getSketchHeight(textView.textSize, textView.resources)
            setFixHeightText(text, textHeight)
        }
    }

    fun setFixHeightText(text: CharSequence?, targetLineHeight: Int) {
        if (text.isNullOrEmpty()) {
            textView.text = text
            return
        }
        if (text is Spannable) {
            text.getSpans(0, text.length, FixHeightLineSpaceSpan::class.java)?.takeIf {
                it.contains(heightSpan)
            }.apply {
                text.removeSpan(heightSpan)
            }
        }
        heightSpan.setHeight(targetLineHeight)
        val ssb: SpannableStringBuilder
        if (text is SpannableStringBuilder) {
            ssb = text
            // 设置LineHeightSpan
            ssb.setSpan(heightSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        } else {
            ssb = SpannableStringBuilder(text)
            // 设置LineHeightSpan
            ssb.setSpan(heightSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        textView.text = ssb
    }

    fun refreshTextSize() {
        setFixHeightText(textView.text, getSketchHeight(textView.textSize, textView.resources))
    }

}