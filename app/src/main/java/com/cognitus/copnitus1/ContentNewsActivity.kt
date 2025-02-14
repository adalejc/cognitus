package com.cognitus.copnitus1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.cognitus.copnitus1.databinding.ActivityContentNewsBinding
import com.squareup.picasso.Picasso
import java.net.URL
import kotlin.math.log

class ContentNewsActivity : AppCompatActivity(), View.OnClickListener {
    private var newsUrl: String? = null
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityContentNewsBinding>(this, R.layout.activity_content_news)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.clickListener = this

        val newsTitle = intent.getStringExtra("title")
        val newsDescription = intent.getStringExtra("description")
        val newsPhoto = intent.getStringExtra("photo")
        this.newsUrl = intent.getStringExtra("url")


        binding.titleNews.text = newsTitle
        binding.tvNewsDescription.text = newsDescription
        binding.ivNewsPhoto.loadUrl(newsPhoto.toString())


        Log.i( "binding.titleNews", " binding.titleNews: " + binding.titleNews)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivShare -> {
                Toast.makeText(this, "Click en Compartir", Toast.LENGTH_SHORT).show()

                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, newsUrl)
                    type = "text/plain"
                }
                try {
                    startActivity(sendIntent)
                } catch (e: ActivityNotFoundException) {
                    Log.i("share","error to share new ")
                }
            }
            R.id.ivMore -> {
                Toast.makeText(this, "Click en ver mas", Toast.LENGTH_SHORT).show()
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl))
                startActivity(browserIntent)
            }
        }
    }

    private fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}