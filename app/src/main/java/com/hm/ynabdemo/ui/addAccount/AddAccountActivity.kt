package com.hm.ynabdemo.ui.addAccount

import android.os.Bundle
import android.widget.Toast
import com.hm.ynabdemo.R
import com.hm.ynabdemo.databinding.ActivityAddAccountBinding
import com.task.ui.base.BaseActivity

class AddAccountActivity : BaseActivity() {
    lateinit var binding: ActivityAddAccountBinding


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
        binding.creteAccountBtn.setOnClickListener {
            Toast.makeText(this, getString(R.string.not_implemented), Toast.LENGTH_LONG).show()
        }
//        setContentView(R.layout.activity_add_account)
//        binding.
    }
}