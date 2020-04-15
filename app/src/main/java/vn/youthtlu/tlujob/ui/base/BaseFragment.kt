package vn.youthtlu.tlujob.ui.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) baseActivity = context as BaseActivity
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        instanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, instanceState)
        val view = inflater.inflate(getLayoutRes(), container, false)
        if (getTitleRes() != 0) baseActivity?.supportActionBar?.setTitle(getTitleRes())
        initView(instanceState)
        initListener()
        initObserve()
        return view
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    @StringRes
    protected abstract fun getTitleRes(): Int
    protected abstract fun initView(savedInstanceState: Bundle?)
    protected abstract fun initListener()
    abstract fun initObserve()

    protected fun showMessage(msg: String?) {
        baseActivity?.toast(msg)
    }

    protected fun showMessage(@StringRes resId: Int) {
        baseActivity?.toast(resId)
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }
}