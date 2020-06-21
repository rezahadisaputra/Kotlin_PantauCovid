package com.example.boedoet.pantaucovid

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_data.*

class detail_data : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_data)
        val actionbar = supportActionBar
        actionbar!!.title = "Data Covid "
        actionbar.setDisplayHomeAsUpEnabled(true)


        val tvSetnama: TextView = findViewById(R.id.tv_set_nama_provinsi)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetpositive: TextView = findViewById(R.id.tv_set_positive)
        val tvSetSembuh: TextView = findViewById(R.id.tv_set_sembuh)
        val tvsetMeninggal: TextView = findViewById(R.id.tv_set_meninggal)

        val tProvinsi  = intent.getStringExtra(EXTRA_NAMAPROVINSI)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tPositive = intent.getIntExtra(EXTRA_POSITIVE,0)
        val tSembuh = intent.getIntExtra(EXTRA_SEMBUH,0)
        val tMeninggal = intent.getIntExtra(EXTRA_MENINGGAL,0)



        tvSetnama.text = tProvinsi
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetpositive.text = tPositive.toString()
        tvSetSembuh.text = tSembuh.toString()
        tvsetMeninggal.text = tMeninggal.toString()
    }

    companion object {
        const val EXTRA_NAMAPROVINSI = "extra_namaprovinsi"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_POSITIVE = "extra_positive"
        const val EXTRA_SEMBUH = "extra_sembuh"
        const val EXTRA_MENINGGAL = "extra_meninggal"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

