package com.shoopi.routina

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

data class Routine(
    val name: String,
    val description: String,
    val icon: MaterialDrawableBuilder.IconValue,
    val foreground: Int,
    val background: Int
)

fun createDummyRoutines(): List<Routine> {

    return listOf(
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            MaterialDrawableBuilder.IconValue.WEB,
            R.attr.foreRed,
            R.attr.backRed
        ),
        Routine(
            "action",
            "takes a video",
            MaterialDrawableBuilder.IconValue.VIDEO,
            R.attr.foreMagenta,
            R.attr.backMagenta
        ),
        Routine(
            "Text me",
            "",
            MaterialDrawableBuilder.IconValue.NOTE_TEXT,
            R.attr.foreOrange,
            R.attr.backOrange
        ),
        Routine(
            "open android open it and then open it again and again and again and again.",
            "android",
            MaterialDrawableBuilder.IconValue.ANDROID_HEAD,
            R.attr.foreYellow,
            R.attr.backYellow
        ),
        Routine(
            "Check Weather",
            "",
            MaterialDrawableBuilder.IconValue.WEATHER_SUNNY,
            R.attr.foreGreen,
            R.attr.backGreen
        ),
        Routine(
            "open stream",
            "open Stream on twitch",
            MaterialDrawableBuilder.IconValue.TWITCH,
            R.attr.foreTurquoise,
            R.attr.backTurquoise
        ),
        Routine(
            "Change Settings",
            "open developer",
            MaterialDrawableBuilder.IconValue.SETTINGS,
            R.attr.foreCyan,
            R.attr.backCyan
        ),
        Routine(
            "go Home",
            "open navigation and go home",
            MaterialDrawableBuilder.IconValue.HOME_MODERN,
            R.attr.foreBlue,
            R.attr.backBlue
        ),
        Routine(
            "dance",
            "play some music",
            MaterialDrawableBuilder.IconValue.MUSIC_NOTE,
            R.attr.foreDarkBlue,
            R.attr.backDarkBlue
        ),
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            MaterialDrawableBuilder.IconValue.GOOGLE_CHROME,
            R.attr.foreDarkPurple,
            R.attr.backDarkPurple
        ),
        Routine(
            "action",
            "takes a video",
            MaterialDrawableBuilder.IconValue.WEBCAM,
            R.attr.forePurple,
            R.attr.backPurple
        ),
        Routine(
            "Text me",
            "",
            MaterialDrawableBuilder.IconValue.TOOLTIP_TEXT,
            R.attr.forePink,
            R.attr.backPink
        ),
        Routine(
            "temp",
            "temp",
            MaterialDrawableBuilder.IconValue.BLUETOOTH,
            R.attr.foreBlack,
            R.attr.backBlack
        ),
        Routine(
            "temp",
            "temp",
            MaterialDrawableBuilder.IconValue.YOUTUBE,
            R.attr.foreGray,
            R.attr.backGray
        ),
        Routine(
            "temp",
            "temp",
            MaterialDrawableBuilder.IconValue.BRUSH,
            R.attr.foreBrown,
            R.attr.backBrown
        )
    )

}