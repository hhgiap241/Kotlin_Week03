package com.example.localizationapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    // Buttons
    var viBtn: Button? = null
    var enBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viBtn = findViewById(R.id.viBtn)
        enBtn = findViewById(R.id.enBtn)

        viBtn?.setOnClickListener {
            // change language to vietnamese
            LocaleUtils.setLocale(this, "vi")

            //and recreate
            recreate()
        }

        enBtn?.setOnClickListener {
            // change language to english
            LocaleUtils.setLocale(this, "en")
            //and recreate
            recreate()
        }

    }

    override fun attachBaseContext(newBase: Context?) {
        var context = newBase

        val savedLocale = LocaleUtils.getLocale(newBase as Context)
        context!!.resources.configuration.setLocale(savedLocale)
        super.attachBaseContext(context)

    }
}

object LocaleUtils {
    private var sLocale: Locale? = null

    fun setLocale(locale: Locale) {
        if (locale != null) {
            Locale.setDefault(sLocale)
        }
    }

    fun setLocale(context: Context, slocale: String) {
        val locale = Locale(slocale)
        sLocale = locale
        Locale.setDefault(sLocale)
        val ref = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
        ref.edit().putString("Lang", slocale).commit()
    }

    fun getLocale(context: Context): Locale?{
        val locale = Locale(context.getSharedPreferences("Settings", Context.MODE_PRIVATE).getString("Lang", "en"))
        return locale
    }

    fun getLocale(): Locale? {
        return sLocale
    }
}