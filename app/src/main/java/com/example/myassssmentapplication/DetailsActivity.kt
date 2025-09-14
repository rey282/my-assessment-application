package com.example.myassssmentapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonParser
import com.google.gson.JsonElement

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val jsonString = intent.getStringExtra("entityJson")
        val tvDetails = findViewById<TextView>(R.id.tvDetails)

        if (jsonString.isNullOrBlank()) {
            tvDetails.text = "No details to display."
            return
        }

        val entity = JsonParser.parseString(jsonString).asJsonObject

        fun JsonElement.pretty(): String = when {
            isJsonNull -> "null"
            isJsonPrimitive -> {
                val p = asJsonPrimitive
                when {
                    p.isBoolean -> p.asBoolean.toString()
                    p.isNumber  -> p.asNumber.toString()
                    else        -> p.asString
                }
            }
            else -> toString()
        }

        val lines = buildString {
            for ((key, value) in entity.entrySet()) {
                appendLine("$key: ${value.pretty()}")
            }
        }

        tvDetails.text = lines
    }
}
