package com.viewbinding

import android.os.Bundle
import android.view.View
import com.framework.viewbinding.base.BaseFragment
import com.viewbinding.databinding.ActivityMainBinding

/**
 * @author: xiaxueyi
 * @date: 2022-09-26
 * @time: 15:12
 * @说明:
 */

class MainFragment :BaseFragment<ActivityMainBinding>() {

    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mViewBinding.title.text="不用findViewById 了"
    }
}