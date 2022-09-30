package com.framework.viewbinding.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType
/**
 * @author: xiaxueyi
 * @date: 2022-09-23
 * @time: 15:46
 * @说明:
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    open lateinit var mViewBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val superclass = javaClass.genericSuperclass
        if (superclass != null) {
            val aClass = (superclass as ParameterizedType).actualTypeArguments[0] as Class<*>
            try {
                val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
                mViewBinding = method.invoke(null, layoutInflater) as T
                setContentView(mViewBinding.root)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        initView(window.decorView, savedInstanceState)
    }


    /**
     * activity跳转（无参数）
     * @param className
     */
    open fun startActivity(className: Class<out Activity>) {
        val intent = Intent(this, className)
        startActivity(intent)
    }

    /**
     * activity跳转（有参数）
     * @param className
     */
    open fun startActivity(className: Class<out Activity>, bundle: Bundle) {
        val intent = Intent(this, className)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    /**
     * activity结果跳转（没有参数）
     * @param className
     * @param requestCode
     */
    open fun startActivityForResult(className: Class<out Activity>, requestCode: Int) {
        val intent = Intent(this, className)
        startActivityForResult(intent, requestCode)
    }


    /**
     * activity结果跳转（有参数）
     * @param className
     * @param bundle
     * @param requestCode
     */
    open fun startActivityForResult(className: Class<out Activity>, bundle: Bundle, requestCode: Int) {
        val intent = Intent(this, className)
        intent.putExtras(bundle)
        startActivityForResult(intent, requestCode)
    }


    /**
     * 入口函数
     */
    abstract fun initView(rootView: View, savedInstanceState: Bundle?)
}