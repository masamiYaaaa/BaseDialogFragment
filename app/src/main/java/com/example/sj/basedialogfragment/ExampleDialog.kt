package com.example.sj.basedialogfragment

import android.widget.Button

class ExampleDialog : BaseDialogFragment(R.layout.dialog_example) {
    override fun initData() {
        super.initData()
        isCancelable = false
        view!!.findViewById<Button>(R.id.btn_cancle).setOnClickListener {
            dismiss()
        }
    }

}