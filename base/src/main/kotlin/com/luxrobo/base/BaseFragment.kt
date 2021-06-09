package com.luxrobo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.util.*

abstract class BaseFragment<B : ViewDataBinding>(
    @LayoutRes
    private val layoutResId: Int
) : Fragment() {

    protected lateinit var binding: B
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this@BaseFragment

        initializeUI()
    }

    abstract fun initializeUI()

    fun restartTo(cls: Class<*>) {
        (activity as? BaseActivity<*>)?.restartActivity(cls)
    }

    fun goToActivity(cls: Class<*>, args: Bundle?) {
        (activity as? BaseActivity<*>)?.goToActivity(cls, args)
    }

    fun goToFragment(id: Int, cls: Class<*>, args: Bundle?) {
        (activity as? BaseActivity<*>)?.goToFragment(id, cls, args)
    }

    fun goToFragment(id: Int, fragment: Fragment, args: Bundle?) {
        (activity as? BaseActivity<*>)?.goToFragment(id, fragment, args)
    }

    fun removeFragment(fragment: Fragment) {
        (activity as? BaseActivity<*>)?.removeFragment(fragment)
    }
}