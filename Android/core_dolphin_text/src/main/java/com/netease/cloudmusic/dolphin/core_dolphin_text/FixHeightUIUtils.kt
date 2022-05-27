package com.netease.cloudmusic.dolphin.core_dolphin_text

import android.content.Context
import android.content.res.Resources
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.util.DisplayMetrics
import android.util.TypedValue
import kotlin.math.roundToInt

const val TEXT_HEIGHT_RATIO = 1.193359

/**
 * 设置标准的单行行高
 * 注：字符串isNullOrEmpty则无效，可以设置空白字符
 */
fun warpStandardHeightSpan(
    context: Context,
    text: CharSequence?,
    textSize: Int,
    textUnit: Int = TypedValue.COMPLEX_UNIT_DIP
): CharSequence? {
    if (text.isNullOrEmpty()) {
        return text
    }
    val textHeight = (textSize * TEXT_HEIGHT_RATIO).roundToInt()
    val finalHeight = TypedValue.applyDimension(
        textUnit,
        textHeight.toFloat(), context.resources.displayMetrics
    )
    return wrapHeightSpan(text, (finalHeight + 0.5f).toInt())
}

/**
 * 设置指定的多行行高
 * 注：字符串isNullOrEmpty则无效，可以设置空白字符
 */
fun warpFixHeightSpan(text: CharSequence?, textHeight: Int): CharSequence? {
    if (text.isNullOrEmpty()) {
        return text
    }
    return wrapHeightSpan(text, textHeight)
}

private fun wrapHeightSpan(text: CharSequence, textHeight: Int): CharSequence {
    val heightSpan = FixHeightLineSpaceSpan(textHeight)
    val ssb: SpannableStringBuilder
    if (text is SpannableStringBuilder) {
        ssb = text
        ssb.setSpan(heightSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    } else {
        ssb = SpannableStringBuilder(text)
        ssb.setSpan(heightSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return ssb
}

fun Int.dp(resource: Resources): Int = this.toFloat().dp(resource)
fun Int.dpF(resource: Resources): Float = this.toFloat().dpF(resource)

fun Float.dp(resource: Resources): Int = (TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    resource.displayMetrics
) + 0.5f).toInt()

fun Float.dpF(resource: Resources): Float =
    (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, resource.displayMetrics))