package com.luxrobo.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDialog<B : ViewDataBinding>(
    context: Context,
    @LayoutRes
    val layoutResId: Int
) : Dialog(context) {

    lateinit var binding: B
        private set

    private val dimAmount = 0.5f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.inflate(LayoutInflater.from(this.context), layoutResId, null, false)

        window?.apply {
            setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, 0)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setDimAmount(dimAmount)
        }

        this.setCancelable(false)

        hideSystemUI()

        initializeUI()

        setContentView(binding.root)
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean img_btn_coding_back_pressed" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window!!.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    abstract fun initializeUI()

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            show()
        }
    }

    override fun show() {
        // Set the dialog to not focusable.
        window!!.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        )

        // Show the dialog with NavBar hidden.
        window!!.decorView.systemUiVisibility =
            BaseActivity.getInstance().window.decorView.systemUiVisibility
        window!!.decorView.setOnSystemUiVisibilityChangeListener {
            BaseActivity.getInstance().window.decorView.systemUiVisibility
        }
        super.show()

        // Set the dialog to focusable again.
        window!!.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
    }
}