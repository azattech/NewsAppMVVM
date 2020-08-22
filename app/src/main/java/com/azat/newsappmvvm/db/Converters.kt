package com.azat.newsappmvvm.db

import androidx.room.TypeConverter
import com.azat.newsappmvvm.model.Source

/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 22/08/2020 - 7:04 PM  *
 ************************/
class Converters {

    @TypeConverter
    fun fromSource(source: Source) = source.name

    @TypeConverter
    fun toSource(name: String) = Source(name, name)
}