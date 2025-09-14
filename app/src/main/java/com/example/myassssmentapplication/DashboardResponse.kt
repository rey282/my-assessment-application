package com.example.myassssmentapplication

import com.google.gson.JsonObject

data class DashboardResponse(
    val entities: List<JsonObject>,
    val entityTotal: Int
)
