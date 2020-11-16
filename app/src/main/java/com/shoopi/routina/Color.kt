package com.shoopi.routina

enum class Color(
    val foreground: Int,
    val background: Int
) {
    RED(R.attr.foreRed, R.attr.backRed),
    MAGENTA(R.attr.foreMagenta, R.attr.backMagenta),
    ORANGE(R.attr.foreOrange, R.attr.backOrange),
    YELLOW(R.attr.foreYellow, R.attr.backYellow),
    GREEN(R.attr.foreGreen, R.attr.backGreen),
    TURQUOISE(R.attr.foreTurquoise, R.attr.backTurquoise),
    CYAN(R.attr.foreCyan, R.attr.backCyan),
    BLUE(R.attr.foreBlue, R.attr.backBlue),
    DARK_BLUE(R.attr.foreDarkBlue, R.attr.backDarkBlue),
    DARK_PURPLE(R.attr.foreDarkPurple, R.attr.backDarkPurple),
    PURPLE(R.attr.forePurple, R.attr.backPurple),
    PINK(R.attr.forePink, R.attr.backPink),
    BLACK(R.attr.foreBlack, R.attr.backBlack),
    GRAY(R.attr.foreGray, R.attr.backGray),
    BROWN(R.attr.foreBrown, R.attr.backBrown);
}

fun colors(): List<Color> {
    return Color.values().toList()
}

data class SharedColor(var color: Color)
