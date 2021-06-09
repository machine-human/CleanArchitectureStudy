package com.luxrobo.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.util.*

abstract class BaseActivity<B : ViewDataBinding>(
    @LayoutRes
    private val layoutResId: Int
) : AppCompatActivity() {

    val EXTRA_BUNDLE = "EXTRA_BUNDLE"

    private val uiOption by lazy {
        (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(layoutInflater, layoutResId, null, false)

        binding.lifecycleOwner = this@BaseActivity

        instance = this@BaseActivity

        setContentView(binding.root)

        initializeUI()
    }

    abstract fun initializeUI()

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean img_btn_coding_back_pressed" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = uiOption

        window.decorView.setOnSystemUiVisibilityChangeListener {
            window.decorView.systemUiVisibility = uiOption
        }
    }

    fun restartActivity(cls: Class<*>) {
        val intent = Intent(applicationContext, cls)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
        Runtime.getRuntime().exit(0)
    }

    fun goToActivity(cls: Class<*>, args: Bundle?) {
        val intent = Intent(this, cls)

        args?.let {
            intent.putExtra(EXTRA_BUNDLE, args)
        }

        intent.apply {
            addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION)
        }
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    fun goToFragment(id: Int, cls: Class<*>, args: Bundle?) {
        try {
            val fragment = cls.newInstance() as Fragment
            fragment.arguments = args
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(id, fragment).commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun goToFragment(id: Int, fragment: Fragment, args: Bundle?) {
        try {
            fragment.arguments = args
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(id, fragment).commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun removeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
    }

    companion object {
        private lateinit var instance: Activity
        fun getInstance() = instance
    }
}