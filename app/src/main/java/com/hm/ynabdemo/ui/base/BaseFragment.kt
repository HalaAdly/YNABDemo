package com.hm.ynabdemo.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.hm.ynabdemo.utils.SingleEvent
import com.hm.ynabdemo.utils.setupSnackbar
import com.hm.ynabdemo.utils.showToast
import dagger.android.support.AndroidSupportInjection

/**
 * Created by HalaAdly
 */


abstract class BaseFragment : Fragment() {

    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewBinding()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    protected fun observeToast(event: LiveData<SingleEvent<Any>>, binding: ViewBinding) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    protected fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>, binding: ViewBinding) {
        binding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }

}
