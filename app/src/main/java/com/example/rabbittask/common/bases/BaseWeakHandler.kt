package com.homyapplication.common.bases

import android.os.Handler
import android.os.Message
import java.lang.ref.WeakReference

abstract class BaseWeakHandler<T>(reference: T) : Handler() {
    private val mReference: WeakReference<T> = WeakReference<T>(reference)
    override fun handleMessage(msg: Message?) {
        if (mReference.get() == null) return
        handleMessage(mReference, msg)
    }

    protected abstract fun handleMessage(reference: WeakReference<T>, msg: Message?)

}