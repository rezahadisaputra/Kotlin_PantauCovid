package com.example.boedoet.pantaucovid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv_data : RecyclerView
    private var list: ArrayList<Covid> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Pantau Covid"


        rv_data = findViewById(R.id.rv_data)
        rv_data.setHasFixedSize(true)

        list.addAll(CovidData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_data.layoutManager = LinearLayoutManager(this)
        val listdataAdapter = ListDataAdapter(list)
        rv_data.adapter = listdataAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_aboutme -> {
                val aboutMe = Intent(this@MainActivity, aboutme::class.java)
                startActivity(aboutMe)
            }
        }
    }
}
