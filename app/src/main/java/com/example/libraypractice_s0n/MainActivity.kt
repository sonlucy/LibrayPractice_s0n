package com.example.libraypractice_s0n

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
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
            val permissionListener = object:PermissionListener { //권한에 따른 행동방침을 모아둔 책(PermissionListener)을 내(object)가 들고잇을게.
                                                                //그 만들어진 책을 permissionListener라는 공간에다가 집어넣을게
               
                override fun onPermissionGranted() {
                    //권한 승인 -> 실제로 전화 연결 진행.
                    val myUri=Uri.parse("tel:010-2222-3333")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)  //myUri에 CALL
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    //권한 거절 -> 토스트로 권한 없어서 전화 연결 실패했다고 띄워주기
                    Toast.makeText(this@MainActivity, "권한이 없어서 전화연결에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}