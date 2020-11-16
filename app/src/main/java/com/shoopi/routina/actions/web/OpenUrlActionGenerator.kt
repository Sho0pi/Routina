package com.shoopi.routina.actions.web

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.shoopi.routina.R
import com.shoopi.routina.actions.EditableActionGenerator

class OpenUrlActionGenerator(private val context: Context) : EditableActionGenerator<Unit> {

    override val name: String
        get() = "Open Url"
    override val description: String
        get() = "Opens Url in you default browser"
    override val icon: Int
        get() = R.drawable.ic_web
    override val gradient: Int
        get() = R.drawable.gradient_blue
    override val isReceiver: Boolean
        get() = true
    override val isSupplier: Boolean
        get() = false

    private var defaultUrl: String = "www.google.com"

    override fun generate(from: Any): OpenUrlAction {
        return when (from) {
            is String -> OpenUrlAction(from, context)
            else -> OpenUrlAction(defaultUrl, context)
        }
    }

    @SuppressLint("InflateParams")
    override fun edit(context: Context) {
        val inflate =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.dialog_open_url, null
            )
        val alertDialog = AlertDialog.Builder(context).apply {
        }.create().apply {
            setView(inflate)
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(0))
            show()
        }
        val entryText = inflate.findViewById<TextInputEditText>(R.id.url_edit_text)

        inflate.findViewById<MaterialButton>(R.id.button_cancel).apply {
            setOnClickListener { alertDialog.dismiss() }
        }
        inflate.findViewById<MaterialButton>(R.id.button_done).apply {
            setOnClickListener {
                if (entryText.text != null) {
                    this@OpenUrlActionGenerator.defaultUrl = entryText.text.toString()
                }
                alertDialog.dismiss()
            }
        }
    }
}