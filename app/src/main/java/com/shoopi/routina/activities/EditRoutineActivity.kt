package com.shoopi.routina.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.shoopi.routina.Color
import com.shoopi.routina.IntentConstants
import com.shoopi.routina.R
import com.shoopi.routina.adapters.SlidePageAdapter
import com.shoopi.routina.fragments.editroutine.BuilderFragment
import com.shoopi.routina.fragments.editroutine.EditRoutineFragment
import kotlinx.android.synthetic.main.activity_edit_routine.*
import kotlinx.android.synthetic.main.toolbar.*
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class EditRoutineActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: SlidePageAdapter
    private var routineName: String = ""
    private var routineIcon: MaterialDrawableBuilder.IconValue =
        MaterialDrawableBuilder.IconValue.SETTINGS
    private var routineColor: Color = Color.GRAY
    private var routinePosition: Int = 0

    private lateinit var editRoutineFragment: EditRoutineFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_routine)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            routineColor = extras.getSerializable(IntentConstants.EXTRA_COLOR_OBJECT) as Color
            routineIcon =
                extras.getSerializable(IntentConstants.EXTRA_ICON_OBJECT) as MaterialDrawableBuilder.IconValue
            routineName = extras.getString(IntentConstants.EXTRA_ROUTINE_NAME_OBJECT, "")
            routinePosition = extras.getInt(IntentConstants.EXTRA_ROUTINE_POSITION)
        }

        initToolbar()

        editRoutineFragment =
            EditRoutineFragment.newInstance(routineColor, routineIcon, routineName)
        val fragments = listOf(
            BuilderFragment(),
            editRoutineFragment
        )

        pagerAdapter = SlidePageAdapter(supportFragmentManager, fragments)
        pager.adapter = pagerAdapter
        bottom_nav.setupWithViewPager(pager)
    }

    private fun initToolbar() {
        text_toolbar.text = resources.getText(R.string.edit_routine)
        image_toolbar.setOnClickListener {
            finish()
        }
        image_toolbar.setImageResource(R.drawable.ic_menu_back)
        image_toolbar.visibility = ImageView.VISIBLE
        setSupportActionBar(toolbar as Toolbar?)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_done) {
            val intent = Intent().apply {
                putExtra(IntentConstants.EXTRA_ROUTINE_POSITION, routinePosition)
                putExtra(IntentConstants.EXTRA_COLOR_OBJECT, editRoutineFragment.getRoutineColor())
                putExtra(IntentConstants.EXTRA_ICON_OBJECT, editRoutineFragment.getRoutineIcon())
                putExtra(
                    IntentConstants.EXTRA_ROUTINE_NAME_OBJECT,
                    editRoutineFragment.getRoutineName()
                )
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}