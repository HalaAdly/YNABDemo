package com.hm.ynabdemo.ui.addAccount

import android.os.Bundle
import com.hm.ynabdemo.R
import com.hm.ynabdemo.databinding.ActivityAddAccountBinding
import com.task.ui.base.BaseActivity

class AddAccountActivity : BaseActivity() {
    lateinit var binding: ActivityAddAccountBinding
    override fun initializeViewModel() {

    }

    override fun observeViewModel() {
    }

    override fun initViewBinding() {
        binding = ActivityAddAccountBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.create_account)
//        setContentView(R.layout.activity_add_account)
//        binding.
    }
}