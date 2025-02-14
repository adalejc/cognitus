package com.cognitus.copnitus1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cognitus.copnitus1.adapter.RecyclerNewsAdapter
import com.cognitus.copnitus1.databinding.ActivityListNewsBinding
import com.cognitus.copnitus1.model.News

class ListNewsActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityListNewsBinding>(this, R.layout.activity_list_news)
    }

    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.clickListener = this
        val mAdapter: RecyclerNewsAdapter = RecyclerNewsAdapter()
        mRecyclerView = binding.rvNewList
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerNewsAdapter(getNewsList(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getNewsList(): MutableList<News> {
        var newsList:MutableList<News> = ArrayList()
        newsList.add(News(
            "Body Language Experts Interpreted Donald Trump's \"Bored\" Behavior At His Recent Press Conference With Elon Musk",
            "2025-02-13T23:53:13Z",
            "https://img.buzzfeed.com/buzzfeed-static/static/2025-02/13/23/enhanced/3d2699695785/original-4856-1739488899-8.jpg?crop=2999:1574;0,0%26downsize=1250:*",
            "The president held a joint press conference with Elon Musk, and experts think there's a lot that went unsaid.View Entire Post ›",
            "https://www.huffpost.com/entry/donald-trump-elon-musk-joint-press-conference-doge_l_67acc30fe4b0239406deb06c",

        ))
        newsList.add(News(
            "State Department halts plan to buy $400M worth of armored vehicles from Musk’s Tesla",
            "2025-02-13T23:50:08Z",
            "https://biztoc.com/cdn/809/og.png",
            "State Department halts plan to buy \$400M worth of armored vehicles from Musk’s Tesla\\nFORT LAUDERDALE, Fla. (AP) — The State Department had been in talks with Elon Musk’s Tesla company to buy armored electric vehicles, but the plans have been put on hold by th…",
            "https://biztoc.com/x/96ac7337b119e736"
        ))
        newsList.add(News(
            "Cybertruck crash raises alarm bells about Tesla's self-driving software",
            "2025-02-13T23:17:43Z",
            "https://dam.mediacorp.sg/image/upload/s--NktZW25t--/fl_relative,g_south_east,l_mediacorp:cna:watermark:2024-04:reuters_1,w_0.1/f_auto,q_auto/c_fill,g_auto,h_676,w_1200/v1/one-cms/core/2025-02-13t231743z_1_lynxmpel1c12h_rtroptp_3_tesla-deliveries.jpg?itok=vsMx8YqK",
            "A crash involving a Tesla Cybertruck in self-driving mode this week has sparked worries about the reliability of the company's software that powers the feature, days after CEO Elon Musk said he would roll out a paid robotaxi service this year.The pickup, the …",
            "https://www.channelnewsasia.com/business/cybertruck-crash-raises-alarm-bells-about-teslas-self-driving-software-4937641"
        ))
        newsList.add(News(
            "No hay agua en la colonia",
            "13/02/2025",
            "https://i.ibb.co/0VG12nyR/gallina.jpg",
            "Gallina cruza la calle para comer en el kfc y causa sensación por conductores y clientes del restaurante",
            "https://www.elespanol.com/ciencia/20170726/234227300_0.html"
        ))
        newsList.add(News(
            "Gana el partido rojo las elecciones",
            "13/02/2025",
            "https://i.ibb.co/0VG12nyR/gallina.jpg",
            "Gallina cruza la calle para comer en el kfc y causa sensación por conductores y clientes del restaurante",
            "https://www.elespanol.com/ciencia/20170726/234227300_0.html"
        ))
        newsList.add(News(
            "Exitoso partido amistoso entre la colona centro y occidente",
            "13/02/2025",
            "https://i.ibb.co/0VG12nyR/gallina.jpg",
            "Gallina cruza la calle para comer en el kfc y causa sensación por conductores y clientes del restaurante",
            "https://www.elespanol.com/ciencia/20170726/234227300_0.html"
        ))
        newsList.add(News(
            "Kermes por causa noble: Se casa el piojo y la pulga",
            "13/02/2025",
            "https://i.ibb.co/0VG12nyR/gallina.jpg",
            "Gallina cruza la calle para comer en el kfc y causa sensación por conductores y clientes del restaurante",
            "https://www.elespanol.com/ciencia/20170726/234227300_0.html"
        ))
        newsList.add(News(
            "El consejo titular de almohadas busca nuevos cobertores",
            "13/02/2025",
            "https://i.ibb.co/0VG12nyR/gallina.jpg",
            "Gallina cruza la calle para comer en el kfc y causa sensación por conductores y clientes del restaurante",
            "https://www.elespanol.com/ciencia/20170726/234227300_0.html"
        ))

        return newsList;
    }

    override fun onClick(v: View?) {

    }
}