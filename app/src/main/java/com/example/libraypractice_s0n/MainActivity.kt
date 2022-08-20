package com.example.libraypractice_s0n

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileimg.setOnClickListener {
            // 프로필 크게 보는 액티비티로 이동.

            val myIntent= Intent(this, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

        //인터넷에 있는 이미지 (https:// ...)을 이미지뷰에 바로 대입.
        Glide.with(this).load("https://postfiles.pstatic.net/MjAyMjA4MDhfMjgy/MDAxNjU5OTAxNzE0NzM5.WkF3DuEiaEl_n7WbCgNkq8Jq7_NnrWkPk2mRQw742owg.2hKGR-iLZ7FONiy6dNIQckTrnPNimARBWkb52Yb" +
                "rAhIg.JPEG.bk_s0n/IMG_0592.JPG?type=w580").into(myImg1)


    }
}