package ca.allanwang.kau.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun <T : View> T.visible(): T {
    visibility = View.VISIBLE
    return this
}

fun <T : View> T.invisible(): T {
    visibility = View.INVISIBLE
    return this
}

fun <T : View> T.gone(): T {
    visibility = View.GONE
    return this
}

fun <T : View> T.invisibleIf(invisible: Boolean): T =
    if (invisible) invisible() else visible()

fun <T : View> T.visibleIf(visible: Boolean): T = if (visible) visible() else gone()

fun <T : View> T.goneIf(gone: Boolean): T = visibleIf(!gone)

inline val View.isVisible: Boolean get() = visibility == View.VISIBLE

inline val View.isInvisible: Boolean get() = visibility == View.INVISIBLE

inline val View.isGone: Boolean get() = visibility == View.GONE

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)