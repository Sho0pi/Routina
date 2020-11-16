package com.shoopi.routina.activities

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.*
import com.shoopi.routina.actions.utils.ShowToastActionGenerator
import com.shoopi.routina.actionsholders.BasicActionHolder
import com.shoopi.routina.adapters.SlidePageAdapter
import com.shoopi.routina.adapters.getColorFromAttr
import com.shoopi.routina.fragments.editicon.ColorsFragment
import com.shoopi.routina.fragments.editicon.IconsFragment
import kotlinx.android.synthetic.main.activity_edit_icon.*
import kotlinx.android.synthetic.main.toolbar.*
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class EditIconActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: SlidePageAdapter
    private lateinit var actionHolder: BasicActionHolder
    private var iconColor: SharedColor = SharedColor(Color.GREEN)
    private var iconValue: SharedIconValue = SharedIconValue(
        MaterialDrawableBuilder.IconValue.ANDROID_HEAD
    )
    private var routinePosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_icon)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            iconColor.color = extras.getSerializable(IntentConstants.EXTRA_COLOR_OBJECT) as Color
            iconValue.icon =
                extras.getSerializable(IntentConstants.EXTRA_ICON_OBJECT) as MaterialDrawableBuilder.IconValue
            routinePosition = extras.getInt(IntentConstants.EXTRA_ROUTINE_POSITION)
        }

        initToolbar()
        initEditIconCard()

        val fragments = listOf(
            ColorsFragment().newInstance(icon_view, iconColor),
            IconsFragment().newInstance(icon_view, iconValue)
        )

        pagerAdapter = SlidePageAdapter(supportFragmentManager, fragments)
        pager.adapter = pagerAdapter
        bottom_nav.setupWithViewPager(pager)

        actionHolder = BasicActionHolder(this)

        val materialCardView = findViewById<MaterialCardView>(R.id.icon_background)
        materialCardView.setOnClickListener {
            actionHolder.add(ShowToastActionGenerator(this))
            materialCardView.setOnClickListener {
                actionHolder.execute()
            }
        }

    }

    private fun initToolbar() {
        text_toolbar.text = resources.getText(R.string.edit_icon)
        image_toolbar.setOnClickListener {
            finish()
        }
        image_toolbar.setImageResource(R.drawable.ic_menu_back)
        image_toolbar.visibility = ImageView.VISIBLE
        setSupportActionBar(toolbar as Toolbar?)
    }

    private fun initEditIconCard() {
        icon.setIcon(iconValue.icon)
        icon.setColor(getColorFromAttr(iconColor.color.foreground))
        icon_background.backgroundTintList =
            ColorStateList.valueOf(getColorFromAttr(iconColor.color.background))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_done) {
            val intent = Intent().apply {
                putExtra(IntentConstants.EXTRA_COLOR_OBJECT, iconColor.color)
                putExtra(IntentConstants.EXTRA_ICON_OBJECT, iconValue.icon)
                putExtra(IntentConstants.EXTRA_ROUTINE_POSITION, routinePosition)
            }
            Log.d(TAG, "icon data saved: ${intent.extras.toString()}")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val TAG = "EditIconActivity"
    }
}