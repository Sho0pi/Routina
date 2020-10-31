package com.shoopi.routina

data class Color(
    val foreground: Int,
    val background: Int
)

fun colors(): List<Color> {
    return listOf(
        Color(R.attr.foreRed, R.attr.backRed),
        Color(R.attr.foreMagenta, R.attr.backMagenta),
        Color(R.attr.foreOrange, R.attr.backOrange),
        Color(R.attr.foreYellow, R.attr.backYellow),
        Color(R.attr.foreGreen, R.attr.backGreen),
        Color(R.attr.foreTurquoise, R.attr.backTurquoise),
        Color(R.attr.foreCyan, R.attr.backCyan),
        Color(R.attr.foreBlue, R.attr.backBlue),
        Color(R.attr.foreDarkBlue, R.attr.backDarkBlue),
        Color(R.attr.foreDarkPurple, R.attr.backDarkPurple),
        Color(R.attr.forePurple, R.attr.backPurple),
        Color(R.attr.forePink, R.attr.backPink),
        Color(R.attr.foreBlack, R.attr.backBlack),
        Color(R.attr.foreGray, R.attr.backGray),
        Color(R.attr.foreBrown, R.attr.backBrown)
    )
}