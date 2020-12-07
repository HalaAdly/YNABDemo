package com.hm.ynabdemo.ui.accountDetails

import android.os.Bundle
import com.hm.ynabdemo.ACCOUNT_ITEM_KEY
import com.hm.ynabdemo.data.dto.accounts.AccountItem
import com.hm.ynabdemo.databinding.ActivityAccountDetailsBinding
import com.task.ui.base.BaseActivity
import javax.inject.Inject

class AccountDetailsActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: AccountDetailsViewModel
    lateinit var binding: ActivityAccountDetailsBinding

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityAccountDetailsBinding.inflate(layoutInflater)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.initIntentData(intent.getParcelableExtra(ACCOUNT_ITEM_KEY) ?: AccountItem())
        supportActionBar?.title = viewModel.getName()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.item = viewModel.itemAccount.value
    }
}