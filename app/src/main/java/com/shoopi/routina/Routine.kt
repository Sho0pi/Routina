package com.shoopi.routina

data class Routine(
    val name: String,
    val description: String,
    val icon: Int,
    val gradient: Int
)

fun createDummyRoutines(): List<Routine> {

    return listOf(
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            R.drawable.ic_web,
            R.drawable.gradient_blue
        ),
        Routine(
            "action",
            "takes a video",
            R.drawable.ic_videocam,
            R.drawable.gradient_red
        ),
        Routine(
            "Text me",
            "",
            R.drawable.ic_subject,
            R.drawable.gradient_yellow
        ),
        Routine(
            "open android open it and then open it again and again and again and again.",
            "android",
            R.drawable.ic_android,
            R.drawable.gradient_green
        ),
        Routine(
            "Check Weather",
            "",
            R.drawable.ic_sun,
            R.drawable.gradient_orange
        ),
        Routine(
            "open stream",
            "open Stream on twitch",
            R.drawable.ic_web,
            R.drawable.gradient_purple_dark
        ),
        Routine(
            "Change Settings",
            "open developer",
            R.drawable.ic_settings,
            R.drawable.gradient_gray
        ),
        Routine(
            "go Home",
            "open navigation and go home",
            R.drawable.ic_home_work,
            R.drawable.gradient_blue_light
        ),
        Routine(
            "dance",
            "play some music",
            R.drawable.ic_music_note,
            R.drawable.gradient_turquoise
        ),
        Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            R.drawable.ic_web,
            R.drawable.gradient_blue
        ),
        Routine(
            "action",
            "takes a video",
            R.drawable.ic_videocam,
            R.drawable.gradient_red
        ),
        Routine(
            "Text me",
            "",
            R.drawable.ic_subject,
            R.drawable.gradient_yellow
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.drawable.gradient_blue
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.drawable.gradient_blue
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.drawable.gradient_blue
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.drawable.gradient_blue
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.drawable.gradient_blue
        ),
        Routine(
            "temp",
            "temp",
            R.drawable.ic_bluetooth,
            R.drawable.gradient_blue
        ),
    )

}