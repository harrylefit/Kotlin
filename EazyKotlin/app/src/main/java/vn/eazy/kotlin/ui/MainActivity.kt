package vn.eazy.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import vn.eazy.kotlin.R
import vn.eazy.kotlin.model.User

class MainActivity : AppCompatActivity() {
    private var user: User? = null
    private var users: List<User>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user = User("Harry", "harry@vinova.sg", "Vinova")
        Log.i("Kotlin", "User :" + user.toString())
        Log.i("Kotlin", "Name :" + user?.name)
        Toast.makeText(applicationContext, "Name :" + user?.name, Toast.LENGTH_SHORT).show()

        users = arrayListOf(User("Harry", "hrry@gmail.com", "Vinova")
                , User("Long Kim Le", "longzma13@gmail.com", "Eazy Studio"))

        //For

        //When (Switch)

        for(user in 1..5){
            Log.i("Kotlin",user.toString())
        }
    }
}
