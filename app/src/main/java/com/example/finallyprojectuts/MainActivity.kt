package com.example.finallyprojectuts
import com.example.finallyprojectuts.fragment.LainyaFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.finallyprojectuts.fragment.FavoritFragment
import com.example.finallyprojectuts.fragment.UntukmuFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lainnyaFragment = LainyaFragment()
        val untukmuFragment = UntukmuFragment()
        val favoritFragment = FavoritFragment()

        makeCurrentFragment (untukmuFragment)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(untukmuFragment)
                R.id.menu_profile -> makeCurrentFragment(lainnyaFragment)
            }
            true
        }
//
//        var pengaturan = PengaturanFragment()
//        pengaturan.onCreateView().switchBtn
    }



    fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }

}