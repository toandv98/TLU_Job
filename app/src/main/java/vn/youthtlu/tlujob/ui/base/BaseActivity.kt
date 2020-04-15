package vn.youthtlu.tlujob.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import vn.youthtlu.tlujob.R

abstract class BaseActivity : AppCompatActivity() {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getNightMode()) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContentView(getLayoutRes())
        if (getToolbarRes() != 0) {
            val toolbar = findViewById<Toolbar>(getToolbarRes())
            setSupportActionBar(toolbar)
        }
        if (getTitleRes() != 0) supportActionBar?.setTitle(getTitleRes())
        initView(savedInstanceState)
        initListener()
        initObserve()
    }

    protected abstract fun getNightMode(): Boolean

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    @IdRes
    protected abstract fun getToolbarRes(): Int

    @StringRes
    protected abstract fun getTitleRes(): Int
    protected abstract fun initView(instanceState: Bundle?)
    protected abstract fun initListener()
    protected abstract fun initObserve()

    fun toast(msg: String?) = when {
        msg != null -> Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        else -> Toast.makeText(this, R.string.msg_null_message, Toast.LENGTH_SHORT).show()
    }

    fun toast(@StringRes resId: Int) {
        toast(getString(resId))
    }
}