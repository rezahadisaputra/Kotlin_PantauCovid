package com.example.boedoet.pantaucovid

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class aboutme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About Me"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView = findViewById(R.id.img_item_photo)

        val tImg = "https://media-exp1.licdn.com/dms/image/C5603AQH6xTeX2ubkmg/profile-displayphoto-shrink_400_400/0?e=1597276800&v=beta&t=rAr0msB7IAbEPrvED3FvN6XZrwm07fhZT0rBj8I_mvY"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}