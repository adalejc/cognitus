package com.cognitus.copnitus1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cognitus.copnitus1.R
import com.cognitus.copnitus1.model.News
import com.squareup.picasso.Picasso

class RecyclerNewsAdapter: RecyclerView.Adapter<RecyclerNewsAdapter.ViewNewsHolder>() {
    var news: MutableList<News> = ArrayList()
    lateinit var context: Context

    fun RecyclerNewsAdapter(news: MutableList<News>, context: Context) {
        this.news = news
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewNewsHolder, position: Int) {
        val item = news.get(position)
        holder.bin(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewNewsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewNewsHolder(layoutInflater.inflate(R.layout.item_news_list, parent, false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    class ViewNewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.tvTitle) as TextView
        val date = view.findViewById(R.id.tvDate) as TextView
        val photo = view.findViewById(R.id.ivNewsPhoto) as ImageView

        fun bin(news: News, context: Context) {
            title.text = news.title
            date.text = news.date
            photo.loadUrl(news.photo)
            itemView.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, news.title, Toast.LENGTH_SHORT).show()
            })
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}