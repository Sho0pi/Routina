package com.shoopi.routina.fragments.editicon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoopi.routina.R
import com.shoopi.routina.SharedIconValue
import com.shoopi.routina.adapters.IconListAdapter
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class IconsFragment : Fragment() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: IconListAdapter
    private lateinit var iconView: LinearLayout
    private lateinit var iconValue: SharedIconValue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_icons, container, false)

        val iconList = view.findViewById<RecyclerView>(R.id.icon_list)

        gridLayoutManager = GridLayoutManager(this.context, 8)
        iconList.layoutManager = gridLayoutManager
        adapter = IconListAdapter(icons(), iconView, iconValue)
        iconList.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    fun newInstance(iconView: LinearLayout, iconValue: SharedIconValue): IconsFragment {
        val fragment = IconsFragment()
        fragment.iconView = iconView
        fragment.iconValue = iconValue
        return fragment
    }

    private fun icons(): List<MaterialDrawableBuilder.IconValue> {
        return listOf(
            MaterialDrawableBuilder.IconValue.CAR,
            MaterialDrawableBuilder.IconValue.CAR_BATTERY,
            MaterialDrawableBuilder.IconValue.CAR_SPORTS,
            MaterialDrawableBuilder.IconValue.BUS,
            MaterialDrawableBuilder.IconValue.TRAIN,
            MaterialDrawableBuilder.IconValue.BIKE,
            MaterialDrawableBuilder.IconValue.MOTORBIKE,
            MaterialDrawableBuilder.IconValue.AMBULANCE,
            MaterialDrawableBuilder.IconValue.AIRPLANE,
            MaterialDrawableBuilder.IconValue.HOME,
            MaterialDrawableBuilder.IconValue.HOSPITAL,
            MaterialDrawableBuilder.IconValue.SHOPPING,
            MaterialDrawableBuilder.IconValue.MEDICAL_BAG,
            MaterialDrawableBuilder.IconValue.SILVERWARE,
            MaterialDrawableBuilder.IconValue.GAS_STATION,
            MaterialDrawableBuilder.IconValue.TEMPERATURE_CELSIUS,
            MaterialDrawableBuilder.IconValue.WHITE_BALANCE_SUNNY,
            MaterialDrawableBuilder.IconValue.WEATHER_NIGHT,
            MaterialDrawableBuilder.IconValue.SNOWFLAKE,
            MaterialDrawableBuilder.IconValue.WEATHER_CLOUDY,
            MaterialDrawableBuilder.IconValue.WEATHER_RAINY,
            MaterialDrawableBuilder.IconValue.UMBRELLA,
            MaterialDrawableBuilder.IconValue.TREE,
            MaterialDrawableBuilder.IconValue.FLOWER,
            MaterialDrawableBuilder.IconValue.FIRE,
            MaterialDrawableBuilder.IconValue.SUNGLASSES,
            MaterialDrawableBuilder.IconValue.COMPASS,
            MaterialDrawableBuilder.IconValue.WEB,
            MaterialDrawableBuilder.IconValue.IMAGE,
            MaterialDrawableBuilder.IconValue.VIDEO,
            MaterialDrawableBuilder.IconValue.CAMERA,
            MaterialDrawableBuilder.IconValue.VIDEO_INPUT_COMPONENT,
            MaterialDrawableBuilder.IconValue.MICROPHONE,
            MaterialDrawableBuilder.IconValue.PLAY_BOX_OUTLINE,
            MaterialDrawableBuilder.IconValue.CONTENT_COPY,
            MaterialDrawableBuilder.IconValue.CALENDAR,
            MaterialDrawableBuilder.IconValue.MESSAGE,
            MaterialDrawableBuilder.IconValue.MESSAGE_TEXT,
            MaterialDrawableBuilder.IconValue.MAILBOX,
            MaterialDrawableBuilder.IconValue.FILE,
            MaterialDrawableBuilder.IconValue.FOLDER,
            MaterialDrawableBuilder.IconValue.PHONE,
            MaterialDrawableBuilder.IconValue.LAPTOP,
            MaterialDrawableBuilder.IconValue.KEYBOARD,
            MaterialDrawableBuilder.IconValue.CALCULATOR,
            MaterialDrawableBuilder.IconValue.DATABASE,
            MaterialDrawableBuilder.IconValue.PRINTER,
            MaterialDrawableBuilder.IconValue.ROUTER_WIRELESS,
            MaterialDrawableBuilder.IconValue.BOX,
            MaterialDrawableBuilder.IconValue.PROJECTOR_SCREEN,
            MaterialDrawableBuilder.IconValue.GOOGLE_CONTROLLER,
            MaterialDrawableBuilder.IconValue.PUZZLE,
            MaterialDrawableBuilder.IconValue.HEADSET,
            MaterialDrawableBuilder.IconValue.HEADSET,
            MaterialDrawableBuilder.IconValue.MUSIC_NOTE,
            MaterialDrawableBuilder.IconValue.MUSIC_NOTE_OFF,
            MaterialDrawableBuilder.IconValue.SPEAKER,
            MaterialDrawableBuilder.IconValue.SPEAKER_OFF,
            MaterialDrawableBuilder.IconValue.LIBRARY,
            MaterialDrawableBuilder.IconValue.LIBRARY_BOOKS,
            MaterialDrawableBuilder.IconValue.BOOK_OPEN,
            MaterialDrawableBuilder.IconValue.BOOK_PLUS,
            MaterialDrawableBuilder.IconValue.GUY_FAWKES_MASK,
            MaterialDrawableBuilder.IconValue.TENNIS,
            MaterialDrawableBuilder.IconValue.BASEBALL,
            MaterialDrawableBuilder.IconValue.FOOTBALL,
            MaterialDrawableBuilder.IconValue.BASKETBALL,
            MaterialDrawableBuilder.IconValue.POKEBALL,
            MaterialDrawableBuilder.IconValue.SOCCER,
            MaterialDrawableBuilder.IconValue.CHESS_BISHOP,
            MaterialDrawableBuilder.IconValue.CLOCK,
            MaterialDrawableBuilder.IconValue.PIANO,
            MaterialDrawableBuilder.IconValue.GUITAR_ACOUSTIC,
            MaterialDrawableBuilder.IconValue.GUITAR_ELECTRIC,
            MaterialDrawableBuilder.IconValue.ALARM,
            MaterialDrawableBuilder.IconValue.CLOCK_END,
            MaterialDrawableBuilder.IconValue.BELL,
            MaterialDrawableBuilder.IconValue.HEART,
            MaterialDrawableBuilder.IconValue.STAR,
            MaterialDrawableBuilder.IconValue.LIGHTBULB,
            MaterialDrawableBuilder.IconValue.WEATHER_LIGHTNING,
            MaterialDrawableBuilder.IconValue.FLAG,
            MaterialDrawableBuilder.IconValue.TICKET,
            MaterialDrawableBuilder.IconValue.KEY,
            MaterialDrawableBuilder.IconValue.LOCK,
            MaterialDrawableBuilder.IconValue.BATTERY,
            MaterialDrawableBuilder.IconValue.BRUSH,
            MaterialDrawableBuilder.IconValue.PENCIL,
            MaterialDrawableBuilder.IconValue.PEN,
            MaterialDrawableBuilder.IconValue.PIN,
            MaterialDrawableBuilder.IconValue.CLIPBOARD,
            MaterialDrawableBuilder.IconValue.PAPER_CUT_VERTICAL,
            MaterialDrawableBuilder.IconValue.HAMMER,
            MaterialDrawableBuilder.IconValue.WRENCH,
            MaterialDrawableBuilder.IconValue.SETTINGS_OUTLINE,
            MaterialDrawableBuilder.IconValue.SETTINGS,
            MaterialDrawableBuilder.IconValue.HAND_POINTING_RIGHT,
            MaterialDrawableBuilder.IconValue.WATER,
            MaterialDrawableBuilder.IconValue.COFFEE,
            MaterialDrawableBuilder.IconValue.GLASS_MUG,
            MaterialDrawableBuilder.IconValue.CARROT,
            MaterialDrawableBuilder.IconValue.FISH,
            MaterialDrawableBuilder.IconValue.CAKE,
            MaterialDrawableBuilder.IconValue.BOTTLE_WINE,
            MaterialDrawableBuilder.IconValue.GLASS_COCKTAIL,
            MaterialDrawableBuilder.IconValue.WASHING_MACHINE,
            MaterialDrawableBuilder.IconValue.TSHIRT_V,
            MaterialDrawableBuilder.IconValue.SCALE_BATHROOM,
            MaterialDrawableBuilder.IconValue.CAT,
            MaterialDrawableBuilder.IconValue.PIG,
            MaterialDrawableBuilder.IconValue.THUMB_UP,
            MaterialDrawableBuilder.IconValue.THUMB_DOWN,
            MaterialDrawableBuilder.IconValue.GIFT,
            MaterialDrawableBuilder.IconValue.ALIEN,
            MaterialDrawableBuilder.IconValue.BED_EMPTY,
            MaterialDrawableBuilder.IconValue.STAIRS,
            MaterialDrawableBuilder.IconValue.ROCKET,
            MaterialDrawableBuilder.IconValue.MAP,
            MaterialDrawableBuilder.IconValue.SPEEDOMETER,
            MaterialDrawableBuilder.IconValue.EARTH,
            MaterialDrawableBuilder.IconValue.MESSAGE_PLUS,
            MaterialDrawableBuilder.IconValue.MESSAGE_REPLY,
            MaterialDrawableBuilder.IconValue.RADIO,
            MaterialDrawableBuilder.IconValue.CELLPHONE_IPHONE,
            MaterialDrawableBuilder.IconValue.CELLPHONE_ANDROID,
            MaterialDrawableBuilder.IconValue.CELLPHONE_TEXT,

            MaterialDrawableBuilder.IconValue.BABY,
            MaterialDrawableBuilder.IconValue.HUMAN_CHILD,
            MaterialDrawableBuilder.IconValue.GENDER_MALE,
            MaterialDrawableBuilder.IconValue.GENDER_FEMALE,
            MaterialDrawableBuilder.IconValue.WHEELCHAIR_ACCESSIBILITY,
            MaterialDrawableBuilder.IconValue.NATURE_PEOPLE,
            MaterialDrawableBuilder.IconValue.HUMAN,
            MaterialDrawableBuilder.IconValue.HUMAN_PREGNANT,
            MaterialDrawableBuilder.IconValue.HUMAN_GREETING,
            MaterialDrawableBuilder.IconValue.HUMAN_HANDSDOWN,
            MaterialDrawableBuilder.IconValue.HUMAN_HANDSDOWN,
            MaterialDrawableBuilder.IconValue.RUN,
            MaterialDrawableBuilder.IconValue.RUN_FAST,
            MaterialDrawableBuilder.IconValue.WALK,

            MaterialDrawableBuilder.IconValue.ALERT_OCTAGON,
            MaterialDrawableBuilder.IconValue.SKIP_PREVIOUS,
            MaterialDrawableBuilder.IconValue.SKIP_NEXT,
            MaterialDrawableBuilder.IconValue.BOOKMARK,
            MaterialDrawableBuilder.IconValue.QRCODE,
            MaterialDrawableBuilder.IconValue.BARCODE,
            MaterialDrawableBuilder.IconValue.PLAY,
            MaterialDrawableBuilder.IconValue.PAUSE,
            MaterialDrawableBuilder.IconValue.PAUSE_OCTAGON_OUTLINE,
            MaterialDrawableBuilder.IconValue.GESTURE_TAP,
            MaterialDrawableBuilder.IconValue.BORDER_LEFT,
            MaterialDrawableBuilder.IconValue.BORDER_RIGHT,
            MaterialDrawableBuilder.IconValue.BORDER_TOP,
            MaterialDrawableBuilder.IconValue.BORDER_BOTTOM,
            MaterialDrawableBuilder.IconValue.BORDER_ALL,
            MaterialDrawableBuilder.IconValue.UPLOAD,
            MaterialDrawableBuilder.IconValue.DOWNLOAD,
            MaterialDrawableBuilder.IconValue.POWER,
            MaterialDrawableBuilder.IconValue.PLAY_CIRCLE_OUTLINE,
            MaterialDrawableBuilder.IconValue.STOP_CIRCLE_OUTLINE,
            MaterialDrawableBuilder.IconValue.COMMENT_QUESTION,
            MaterialDrawableBuilder.IconValue.CHECK,
            MaterialDrawableBuilder.IconValue.CHECK_OUTLINE,
            MaterialDrawableBuilder.IconValue.PLUS,
            MaterialDrawableBuilder.IconValue.PLUS_OUTLINE,
            MaterialDrawableBuilder.IconValue.INFORMATION,
            MaterialDrawableBuilder.IconValue.INFORMATION_OUTLINE,
            MaterialDrawableBuilder.IconValue.PI,
            MaterialDrawableBuilder.IconValue.PI_BOX,
            MaterialDrawableBuilder.IconValue.EMOTICON,
            MaterialDrawableBuilder.IconValue.EMOTICON_POOP,
            MaterialDrawableBuilder.IconValue.COIN,
            MaterialDrawableBuilder.IconValue.COINS,
            MaterialDrawableBuilder.IconValue.SHARE,
            MaterialDrawableBuilder.IconValue.RECYCLE,
            MaterialDrawableBuilder.IconValue.INBOX,
            MaterialDrawableBuilder.IconValue.GOOGLE_MAPS,
            MaterialDrawableBuilder.IconValue.CROP,
            MaterialDrawableBuilder.IconValue.RELOAD,
            MaterialDrawableBuilder.IconValue.EYE_SETTINGS,
            MaterialDrawableBuilder.IconValue.RSS,
            MaterialDrawableBuilder.IconValue.RSS_BOX,
            MaterialDrawableBuilder.IconValue.MUSIC,
            MaterialDrawableBuilder.IconValue.MUSIC_NOTE_HALF,
        )
    }


}