package com.framework.viewbinding.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import androidx.fragment.app.Fragment
import java.lang.Exception
import java.lang.reflect.ParameterizedType
/**
 * @author: xiaxueyi
 * @date: 2022-09-23
 * @time: 16:20
 * @说明:
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {
    open lateinit var mViewBinding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val superclass = javaClass.genericSuperclass
        if (superclass != null) {
            val aClass = (superclass as ParameterizedType).actualTypeArguments[0] as Class<*>
            try {
                val method = aClass.getDeclaredMethod(
                    "inflate",
                    LayoutInflater::class.java,
                    ViewGroup::class.java,
                    Boolean::class.javaPrimitiveType
                )
                mViewBinding = method.invoke(null, layoutInflater, container, false) as T
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(mViewBinding.root, savedInstanceState)
    }

    /**
     * 入口函数
     */
    abstract fun initView(rootView: View, savedInstanceState: Bundle?)
}