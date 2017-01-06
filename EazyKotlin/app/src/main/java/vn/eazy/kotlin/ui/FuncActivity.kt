package vn.eazy.kotlin.ui

import android.annotation.SuppressLint
import android.app.Notification
import android.content.Context
import android.support.v7.app.AppCompatActivity

/**
 * Created by Harry on 1/6/17.
 */
object FuncActivity {

}

@SuppressLint("NewApi")
inline fun AppCompatActivity.notfication(context: Context, func: Notification.Builder.() -> Unit): Notification {
    val builder = Notification.Builder(context)
    builder.func()
    return builder.build()
}