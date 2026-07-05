package com.example.simplevideodownloader

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.widget.Toast

class DownloadHelper(private val context: Context) {

fun startDownload(url: String) {
try {
val request = DownloadManager.Request(Uri.parse(url))
request.setTitle("正在下载视频")
request.setDescription("视频下载中...")
request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "video.mp4")

val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
manager.enqueue(request)

Toast.makeText(context, "下载已开始", Toast.LENGTH_SHORT).show()
} catch (e: Exception) {
Toast.makeText(context, "下载失败: ${e.message}", Toast.LENGTH_LONG).show()
}
}
}