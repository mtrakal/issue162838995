package cz.mtrakal.issue162838995

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vTextView.text = getFileName()
    }

    private fun getFileName(): String? {
        val externalStorageWritable = isExternalStorageWritable()
        val extDir = if (externalStorageWritable) externalCacheDir else cacheDir
        return "Is external: $externalStorageWritable\r\n${extDir?.absolutePath}"

    }

    private fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED && externalCacheDir != null
    }
}