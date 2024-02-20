package com.sandhyagill.chatapplication

import android.app.DatePickerDialog
import java.util.Calendar
import java.util.Date

data class MessageDataClass(
    var id: Int = 0,
    var message: String? = null,
    var dateTime: Calendar = Calendar.getInstance()
)
