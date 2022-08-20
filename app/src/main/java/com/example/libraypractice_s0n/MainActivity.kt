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
//        참고)매니패스트의 <application태그에서 usesCleartextTraffic을 true로 설정해주면 http://...도 가능.
        Glide.with(this).load("https://postfiles.pstatic.net/MjAyMjA4MDhfMjgy/MDAxNjU5OTAxNzE0NzM5.WkF3DuEiaEl_n7WbCgNkq8Jq7_NnrWkPk2mRQw742owg.2hKGR-iLZ7FONiy6dNIQckTrnPNimARBWkb52Yb" +
                "rAhIg.JPEG.bk_s0n/IMG_0592.JPG?type=w580").into(myImg1)

        //전화 걸기 버튼 누르면 -> 권한 확인 하고, 전화 연결

        callBtn.setOnClickListener {

            //라이브러리 활용 -> 전화 권환 확인 -> 실제 전화 연결
        }

    }
}