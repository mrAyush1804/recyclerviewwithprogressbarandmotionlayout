package com.example.recyclerviewprectice

data class itemmodel(
    val imageprofile:Int,
    val username:String,
    val online:String,
    val secondlist:List<secondlist>,
    var isExpendable:Boolean=false

)
{
}