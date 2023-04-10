package com.example.clothing_suggestor.data

data class Timeline(
    val timestep: String,
    val endTime: String,
    val startTime: String,
    val intervals: List<Interval>
)
