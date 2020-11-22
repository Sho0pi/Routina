package com.shoopi.routina

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

data class Routine(
    var name: String,
    val description: String,
    var icon: MaterialDrawableBuilder.IconValue,
    var color: Color
)

fun createDummyRoutines(): List<Routine> {

    return listOf(
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            MaterialDrawableBuilder.IconValue.WEB,
            Color.RED
        ),
        Routine(
            "action",
            "takes a video",
            MaterialDrawableBuilder.IconValue.VIDEO,
            Color.MAGENTA
        ),
        Routine(
            "Text me",
            "",
            MaterialDrawableBuilder.IconValue.NOTE_TEXT,
            Color.ORANGE
        ),
        Routine(
            "open android open it and then open it again and again and again and again.",
            "android",
            MaterialDrawableBuilder.IconValue.ANDROID_HEAD,
            Color.YELLOW
        ),
        Routine(
            "Check Weather",
            "",
            MaterialDrawableBuilder.IconValue.WEATHER_SUNNY,
            Color.GREEN
        ),
        Routine(
            "open stream",
            "open Stream on twitch",
            MaterialDrawableBuilder.IconValue.TWITCH,
            Color.TURQUOISE
        ),
        Routine(
            "Change Settings",
            "open developer",
            MaterialDrawableBuilder.IconValue.SETTINGS,
            Color.CYAN
        ),
        Routine(
            "go Home",
            "open navigation and go home",
            MaterialDrawableBuilder.IconValue.HOME_MODERN,
            Color.BLUE
        ),
        Routine(
            "dance",
            "play some music",
            MaterialDrawableBuilder.IconValue.MUSIC_NOTE,
            Color.DARK_BLUE
        ),
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            MaterialDrawableBuilder.IconValue.GOOGLE_CHROME,
            Color.DARK_PURPLE
        ),
        Routine(
            "action",
            "takes a video",
            MaterialDrawableBuilder.IconValue.WEBCAM,
            Color.PURPLE
        ),
        Routine(
            "Text me",
            "",
            MaterialDrawableBuilder.IconValue.TOOLTIP_TEXT,
            Color.PINK
        ),
        Routine(
            "temp",
            "temp",
            MaterialDrawableBuilder.IconValue.BLUETOOTH,
            Color.BLACK
        ),
        Routine(
            "temp",
            "temp",
            MaterialDrawableBuilder.IconValue.YOUTUBE,
            Color.GRAY
        ),
        Routine(
            "temp",
            "temp",
            MaterialDrawableBuilder.IconValue.BRUSH,
            Color.BROWN
        )
    )

}