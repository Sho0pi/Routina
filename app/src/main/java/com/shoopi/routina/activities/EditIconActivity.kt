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
import com.shoopi.routina.*
import com.shoopi.routina.adapters.SlidePageAdapter
import com.shoopi.routina.adapters.getColorFromAttr
import com.shoopi.routina.fragments.editicon.ColorsFragment
import com.shoopi.routina.fragments.editicon.IconsFragment
import kotlinx.android.synthetic.main.activity_edit_icon.*
import kotlinx.android.synthetic.main.toolbar.*
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class EditIconActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: SlidePageAdapter
    private var routineColor: SharedColor = SharedColor(Color.GREEN)
    private var iconValue: SharedIconValue = SharedIconValue(
        MaterialDrawableBuilder.IconValue.ANDROID_HEAD
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_icon)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            routineColor.color = extras.getSerializable(IntentConstants.EXTRA_COLOR_OBJECT) as Color
            iconValue.icon =
                extras.getSerializable(IntentConstants.EXTRA_ICON_OBJECT) as MaterialDrawableBuilder.IconValue
        }

        initToolbar()
        initEditIconCard()

        val fragments = listOf(
            ColorsFragment().newInstance(icon_view, routineColor),
            IconsFragment().newInstance(icon_view, iconValue)
        )

        pagerAdapter = SlidePageAdapter(supportFragmentManager, fragments)
        pager.adapter = pagerAdapter
        bottom_nav.setupWithViewPager(pager)

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
        icon.setColor(getColorFromAttr(routineColor.color.foreground))
        icon_background.backgroundTintList =
            ColorStateList.valueOf(getColorFromAttr(routineColor.color.background))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_done) {
            val intent = Intent().apply {
                putExtra(IntentConstants.EXTRA_COLOR_OBJECT, routineColor.color)
                putExtra(IntentConstants.EXTRA_ICON_OBJECT, iconValue.icon)
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