package com.viewbinding

import android.os.Bundle
import android.view.View
import com.framework.viewbinding.base.BaseActivity
import com.viewbinding.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }


    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mViewBinding.title.text="不用findViewById 了"
    }
}