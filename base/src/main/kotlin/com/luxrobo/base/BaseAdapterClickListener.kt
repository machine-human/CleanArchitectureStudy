package com.luxrobo.base

import android.view.View

interface BaseAdapterClickListener {
    fun onItemSelected(view: View, position: Int)
}