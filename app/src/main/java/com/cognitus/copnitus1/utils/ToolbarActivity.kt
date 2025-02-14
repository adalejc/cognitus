package com.cognitus.copnitus1.utils

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cognitus.copnitus1.R
import com.cognitus.copnitus1.databinding.ToolbarBinding

abstract class ToolbarActivity: AppCompatActivity(){

    protected fun initializeToolbar(toolbarBinding: ToolbarBinding,
                                    titulo: String = "", back:Boolean=false, isMain:Boolean=false){
        setSupportActionBar(toolbarBinding.toolbar)
        toolbarBinding.title = titulo
        if(isMain){
            toolbarBinding.ivLogo.visibility= View.GONE

        }else{
            toolbarBinding.ivLogo.visibility= View.VISIBLE
            toolbarBinding.tvTitleBar.visibility= View.VISIBLE
        }

        if(back) {
            toolbarBinding.toolbar.setNavigationOnClickListener {
                finish()
            }
        }
    }
    protected fun initializeToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}