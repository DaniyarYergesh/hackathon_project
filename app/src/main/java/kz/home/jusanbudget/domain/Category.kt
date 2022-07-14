package kz.home.jusanbudget.domain

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Category(

    val id: Int = 1,
    val name: String = "",
    val defaultPercent: Int = 0,
    val maxPercent: Int = 0,
    @DrawableRes val img: Int = 1,
    var spent: Float = 1f,
    var bonuses: Float = 1f,
    var possibleBonus: Float=1f,
    @ColorRes var color: Int =1,
    var proportions: Float=1f

)