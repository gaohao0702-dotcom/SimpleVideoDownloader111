package com.example.simplevideodownloader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplevideodownloader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
binding = ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)

binding.downloadButton.setOnClickListener {
val url = binding.urlInput.text.toString()
if (url.isNotEmpty()) {
DownloadHelper(this).startDownload(url)
}
}
}
}