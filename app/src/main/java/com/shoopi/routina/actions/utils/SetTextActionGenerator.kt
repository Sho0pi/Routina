package com.shoopi.routina.actions.utils

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.shoopi.routina.R
import com.shoopi.routina.actions.Action
import com.shoopi.routina.actions.EditableActionGenerator

class SetTextActionGenerator() : EditableActionGenerator<String> {

    override val name: String
        get() = "Text"
    override val description: String
        get() = "Set the text"
    override val icon: Int
        get() = R.drawable.ic_text
    override val gradient: Int
        get() = R.drawable.gradient_yellow
    override val isReceiver: Boolean
        get() = false
    override val isSupplier: Boolean
        get() = true

    private var text: String = ""

    override fun generate(from: Any): Action<String> {
        return Action { text }
    }

    @SuppressLint("InflateParams")
    override fun edit(context: Context) {
        val inflate =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.dialog_set_text, null
            )
        val alertDialog = AlertDialog.Builder(context).apply {
        }.create().apply {
            setView(inflate)
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(0))
            show()
        }
        val entryText = inflate.findViewById<TextInputEditText>(R.id.edit_text)

        inflate.findViewById<MaterialButton>(R.id.button_cancel).apply {
            setOnClickListener { alertDialog.dismiss() }
        }
        inflate.findViewById<MaterialButton>(R.id.button_done).apply {
            setOnClickListener {
                if (entryText.text.isNullOrEmpty()) {
                    this@SetTextActionGenerator.text = ""
                } else {
                    this@SetTextActionGenerator.text = entryText.text.toString()
                }
                alertDialog.dismiss()
            }
        }
    }
}