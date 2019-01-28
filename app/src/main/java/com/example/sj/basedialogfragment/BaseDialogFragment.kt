package com.example.sj.basedialogfragment

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*

@SuppressLint("ValidFragment")
open class BaseDialogFragment(layoutId: Int,dialogGravity: Int) : DialogFragment() {

    constructor(layoutId: Int):this(layoutId,0)
    private val layoutId: Int = layoutId
    private val dialogGravity: Int = dialogGravity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = inflater.inflate(layoutId, container)
        return view
    }

    override fun onStart() {
        super.onStart()
        val window = dialog.window
        window.decorView.setPadding(0, 0, 0, 0)
        val lp = window.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = if (dialogGravity==0)Gravity.BOTTOM else dialogGravity
        //从下向上弹出
        lp.windowAnimations = R.style.DialogAnimNormal
        window.attributes = lp
        window.setBackgroundDrawable(ColorDrawable())
        initData()
    }

    protected open fun initData() {}
}