package com.shoopi.routina

data class Routine(
    val name: String,
    val description: String,
    val icon: Int,
    val foreground: Int,
    val background: Int
)

fun createDummyRoutines(): List<Routine> {

    return listOf(
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            R.drawable.ic_web,
            R.attr.foreRed,
            R.attr.backRed
        ),
        Routine(
            "action",
            "takes a video",
            R.drawable.ic_videocam,
            R.attr.foreMagenta,
            R.attr.backMagenta
        ),
        Routine(
            "Text me",
            "",
            R.drawable.ic_subject,
            R.attr.foreOrange,
            R.attr.backOrange
        ),
        Routine(
            "open android open it and then open it again and again and again and again.",
            "android",
            R.drawable.ic_android,
            R.attr.foreYellow,
            R.attr.backYellow
        ),
        Routine(
            "Check Weather",
            "",
            R.drawable.ic_sun,
            R.attr.foreGreen,
            R.attr.backGreen
        ),
        Routine(
            "open stream",
            "open Stream on twitch",
            R.drawable.ic_web,
            R.attr.foreTurquoise,
            R.attr.backTurquoise
        ),
        Routine(
            "Change Settings",
            "open developer",
            R.drawable.ic_settings,
            R.attr.foreCyan,
            R.attr.backCyan
        ),
        Routine(
            "go Home",
            "open navigation and go home",
            R.drawable.ic_home_work,
            R.attr.foreBlue,
            R.attr.backBlue
        ),
        Routine(
            "dance",
            "play some music",
            R.drawable.ic_music_note,
            R.attr.foreDarkBlue,
            R.attr.backDarkBlue
        ),
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            R.drawable.ic_web,
            R.attr.foreDarkPurple,
            R.attr.backDarkPurple
        ),
        Routine(
            "action",
            "takes a video",
            R.drawable.ic_videocam,
            R.attr.forePurple,
            R.attr.backPurple
        ),
        Routine(
            "Text me",
            "",
            R.drawable.ic_subject,
            R.attr.forePink,
            R.attr.backPink
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.attr.foreBlack,
            R.attr.backBlack
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.attr.foreGray,
            R.attr.backGray
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.attr.foreBrown,
            R.attr.backBrown
        )
    )

}