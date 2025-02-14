package com.cognitus.copnitus1.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.cognitus.copnitus1.R
import com.cognitus.copnitus1.databinding.DialogAlertBinding

object AlertDialogCustom {
    enum class OptionDialog {
        POSITIVE,NEGATIVE;
    }
    fun interface ClickOptionDialogListener{
        fun inAction(option: OptionDialog)
    }

    private fun createAlert(context: Context,
                            title: String?,
                            message: String,
                            actionPositive: String,
                            listenerPositive: ClickOptionDialogListener?,
                            actionNegative: String?,
                            listenerNegative: ClickOptionDialogListener?,
                            logoInferior: Boolean) {
        val builder = AlertDialog.Builder(context)

        val binding = DialogAlertBinding.inflate(LayoutInflater.from(context))
        binding.titulo = title
        binding.texto = message
        binding.logoInferior = logoInferior
        builder.setView(binding.root)
        val d = builder.create()
        d.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (actionPositive!=null) {
            binding.accionPositiva = actionPositive
            binding.clickListenerPositivo = View.OnClickListener {
                listenerPositive?.inAction(OptionDialog.POSITIVE)
                d.dismiss()
            }
        }
        if (actionNegative!=null) {
            binding.accionNegativa = actionNegative
            binding.clickListenerNegativo = View.OnClickListener {
                listenerNegative?.inAction(OptionDialog.NEGATIVE)
                d.dismiss()
            }
        }
        d.setCancelable(false)
        d.setCanceledOnTouchOutside(false)
        d.show()
    }

    fun createOptionalAlert(
        context: Context,
        title: String,
        message: String,
        logoInferior: Boolean = false,
        @StringRes idPositiveAction: Int = R.string.txtBtnAcepted,
        @StringRes idNegativeAction: Int = R.string.txtBtnCancel,
        listenerPositive: ClickOptionDialogListener? = null,
        listenerNegative: ClickOptionDialogListener? = null
    ) {
        createAlert(
            context, title, message,
            context.getString(idPositiveAction), listenerPositive,
            context.getString(idNegativeAction), listenerNegative,
            logoInferior
        )
    }

    fun createSimpleAlert(
        context: Context,
        title: String,
        message: String,
        logoInferior: Boolean = false,
        @StringRes idPositiveAction: Int = R.string.txtBtnAcepted,
        listener: ClickOptionDialogListener? = null

    ) {
        createAlert(
            context, title, message,
            context.getString(idPositiveAction), listener, null, null, logoInferior
        )
    }
}