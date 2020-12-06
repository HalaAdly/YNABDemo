package com.task.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.hm.ynabdemo.utils.SingleEvent
import com.hm.ynabdemo.utils.setupSnackbar
import com.hm.ynabdemo.utils.showToast
import dagger.android.AndroidInjection

/**
 * Created by HalaAdly
 */


abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun initializeViewModel()
    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewBinding()
        initializeViewModel()
        observeViewModel()
    }
    protected fun observeToast(event: LiveData<SingleEvent<Any>>, binding: ViewBinding) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    protected fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>, binding: ViewBinding) {
        binding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
