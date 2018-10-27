package ru.github.pvtitov.senatapp.main

import java.lang.IndexOutOfBoundsException

val names = arrayOf("января", "февраля", "марта", "апреля", "мая", "июня", "июля",
        "августа", "сентября", "октября", "ноября", "декабря")

fun monthNameOf(number: Int): String {

    if (number < 0 || number > 11) throw IndexOutOfBoundsException("Illegal month number")
    return names[number]
}