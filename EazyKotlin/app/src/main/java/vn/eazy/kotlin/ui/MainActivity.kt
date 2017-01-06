package vn.eazy.kotlin.ui

import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vn.eazy.kotlin.R
import vn.eazy.kotlin.model.Person
import vn.eazy.kotlin.model.User


class MainActivity : AppCompatActivity() {
    private var user: User? = null
    private var users: List<User>? = null
    private var rootView: View? = null
    private var notificationManager: NotificationManager? = null
    private val person : Person? by lazy{ Person("Harry")}

    private val lazyUser : User? by lazy { User("Harry Lazy","longzma13@gmail.com") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user = User("Harry", "harry@vinova.sg")
        Log.i("Kotlin", "User :" + user.toString())
        Log.i("Kotlin", "Name :" + user?.name)
        Log.i("Kotlin", "Company :" + user?.company)
        Toast.makeText(applicationContext, "Name :" + user?.name, Toast.LENGTH_SHORT).show()

        users = arrayListOf(User("Harry", "hrry@gmail.com", "Vinova")
                , User("Long Kim Le", "longzma13@gmail.com", "Eazy Studio"))

        //For
        for (user in 1..5) {
            Log.i("Kotlin", user.toString())
        }

        //When (Switch)
        when (user?.name) {
            "Harry" -> Toast.makeText(applicationContext, "This is Harry", Toast.LENGTH_SHORT).show()
        }

        //filter
        val filterUser = users?.filter { it.name.length > 5 }

        //auto casting
        logUser(user!!)

        //Extension Function
        tvInput.setText("harryle.fit@gmail.com")
        if (tvInput.isEmail()) {
            Log.i("Kotlin", "is Email")
        } else {
            Log.i("Kotlin", "is not Email")
        }

        //Higher - Order Functions
        runOnLollipopOrAbove {
            Log.i("Kotlin", "Lollipop Or Above")
        }

        //Excersice:  combine extension function and higher-order function
        val sharePreference: SharedPreferences = applicationContext.getSharedPreferences("demo", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePreference.edit()
        editor.putInt("data", 1)
        editor.apply()

        //inline function ...
        notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager?.notify(1, notfication(applicationContext, {
            setContentTitle("Test Inline function")
            setContentText("Hello Kotlin")
            setSmallIcon(R.mipmap.ic_launcher)
        }))
    }

    fun logUser(obj: Any) {
        if (obj is User) {
            Log.i("Kotlin", "Auto Casting Name:" + obj.name)
        }
    }

    fun EditText.isEmail(): Boolean {
        if (text.toString().contains("@")) {
            return true
        }
        return false
    }

    fun runOnLollipopOrAbove(func: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            func()
        }
    }
}
