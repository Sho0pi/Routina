package com.shoopi.routina.actions.utils

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import com.shoopi.routina.R
import com.shoopi.routina.actions.Action
import com.shoopi.routina.actions.EditableActionGenerator

class ShowToastActionGenerator(private val context: Context) : EditableActionGenerator<Unit> {
    @SuppressLint("InflateParams")
    override fun edit(context: Context) {
        val inflate =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.dialog_show_toast, null
            )
        val alertDialog = AlertDialog.Builder(context).apply {
        }.create().apply {
            setView(inflate)
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(0))
            show()
        }
        val entryText = inflate.findViewById<TextInputEditText>(R.id.toast_edit_text)
        val longDurationSwitch =
            inflate.findViewById<SwitchMaterial>(R.id.long_duration_switch).apply {
                isChecked = isLongDuration
            }

        inflate.findViewById<MaterialButton>(R.id.button_cancel).apply {
            setOnClickListener { alertDialog.dismiss() }
        }
        inflate.findViewById<MaterialButton>(R.id.button_done).apply {
            setOnClickListener {
                if (entryText.text != null) {
                    this@ShowToastActionGenerator.defaultToastMessage = entryText.text.toString()
                    this@ShowToastActionGenerator.isLongDuration = longDurationSwitch.isChecked
                }
                alertDialog.dismiss()
            }
        }
    }

    override val name: String
        get() = "Show Toast"
    override val description: String
        get() = "Show a toast message you choose"
    override val icon: Int
        get() = R.drawable.ic_notification_bell
    override val gradient: Int
        get() = R.drawable.gradient_yellow
    override val isReceiver: Boolean
        get() = true
    override val isSupplier: Boolean
        get() = false

    private var isLongDuration = true
    private var defaultToastMessage: String = "Its a toast!"

    override fun generate(from: Any): Action<Unit> {
        return when (from) {
            is String -> ShowToastAction(from, isLongDuration, context)
            is Unit -> ShowToastAction(defaultToastMessage, isLongDuration, context)
            else -> ShowToastAction(from.toString(), isLongDuration, context)
        }
    }
}