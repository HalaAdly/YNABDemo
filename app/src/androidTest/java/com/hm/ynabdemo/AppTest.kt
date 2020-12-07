package com.hm.ynabdemo

import com.hm.ynabdemo.di.DaggerTestAppComponent

class AppTest : App() {
    override fun initDagger() {
        DaggerTestAppComponent.builder().application(this).build().inject(this)
    }
}
