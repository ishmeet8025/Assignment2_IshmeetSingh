package com.example.assignment2_ishmeetsingh

import android.content.Context
import android.content.SharedPreferences

object Prefs {
    private const val NAME = "assignment2_prefs"
    private const val KEY_EMAIL = "key_email"
    private const val KEY_FULLNAME = "key_fullname"
    private const val KEY_AGE = "key_age"
    private const val KEY_PROGRAM = "key_program"

    private fun prefs(ctx: Context): SharedPreferences =
        ctx.getSharedPreferences(NAME, Context.MODE_PRIVATE)

    fun saveLoginEmail(ctx: Context, email: String) {
        prefs(ctx).edit().putString(KEY_EMAIL, email).apply()
    }

    fun getEmail(ctx: Context): String? = prefs(ctx).getString(KEY_EMAIL, null)

    fun saveProfile(ctx: Context, fullName: String, email: String, age: Int, program: String) {
        prefs(ctx).edit()
            .putString(KEY_FULLNAME, fullName)
            .putString(KEY_EMAIL, email)
            .putInt(KEY_AGE, age)
            .putString(KEY_PROGRAM, program)
            .apply()
    }

    fun getFullName(ctx: Context): String? = prefs(ctx).getString(KEY_FULLNAME, null)
    fun getAge(ctx: Context): Int = prefs(ctx).getInt(KEY_AGE, 0)
    fun getProgram(ctx: Context): String? = prefs(ctx).getString(KEY_PROGRAM, null)

    fun clearAll(ctx: Context) {
        prefs(ctx).edit().clear().apply()
    }

    fun getAllPrefs(ctx: Context): Map<String, *> = prefs(ctx).all
}
