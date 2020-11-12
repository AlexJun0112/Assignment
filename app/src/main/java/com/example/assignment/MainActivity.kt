package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.user_profile -> Toast.makeText(applicationContext,"User Profile",Toast.LENGTH_SHORT).show()
                R.id.product -> Toast.makeText(applicationContext,"Product",Toast.LENGTH_SHORT).show()
                R.id.shipment -> Toast.makeText(applicationContext,"Shipment",Toast.LENGTH_SHORT).show()
                R.id.sales_report-> Toast.makeText(applicationContext,"Sales report",Toast.LENGTH_SHORT).show()
                R.id.capacity_report -> Toast.makeText(applicationContext,"Capacity report",Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        when(item.itemId){
            R.id.home -> Toast.makeText(applicationContext,"Home",Toast.LENGTH_SHORT).show()
            R.id.notification -> Toast.makeText(applicationContext,"Notification",Toast.LENGTH_SHORT).show()
            R.id.scanner -> startActivity(Intent(this,Scanner::class.java))


        }
        return super.onOptionsItemSelected(item)
    }
}