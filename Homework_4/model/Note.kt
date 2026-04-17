package hr.ferit.emanuelflorijan.myapplication.model

import java.time.LocalDateTime

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)