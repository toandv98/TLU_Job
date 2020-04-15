package vn.youthtlu.tlujob.ui.home

import android.os.Bundle
import vn.youthtlu.tlujob.R
import vn.youthtlu.tlujob.ui.base.BaseActivity

class HomeActivity : BaseActivity() {

    override fun getNightMode(): Boolean = false

    override fun getLayoutRes(): Int = R.layout.activity_home

    override fun getToolbarRes(): Int = 0

    override fun getTitleRes(): Int = 0

    override fun initView(instanceState: Bundle?) {
        TODO("Init View")
    }

    override fun initListener() {
        TODO("Init Listener")
    }

    override fun initObserve() {
        TODO("Init observe")
    }
}