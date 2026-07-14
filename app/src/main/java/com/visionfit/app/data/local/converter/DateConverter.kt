package com.visionfit.app.data.local.converter

import androidx.room.TypeConverter
import java.util.Date

/**
 * DateConverter - Conversor de tipos para Date no Room Database
 *
 * Responsável por:
 * - Converter Date para Long (milissegundos)
 * - Converter Long (milissegundos) para Date
 *
 * @author VisionFit Team
 */
class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}