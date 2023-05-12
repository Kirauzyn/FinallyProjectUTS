package com.example.finallyprojectuts.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finallyprojectuts.R
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finallyprojectuts.Komik
import com.example.finallyprojectuts.detailKomikActivity

class UntukmuFragment : Fragment() {
    private lateinit var adapter:komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, detailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.pura,
            R.drawable.kepulauan,
            R.drawable.taman,
            R.drawable.pantai,
            R.drawable.nusa,
            R.drawable.gunung,
            R.drawable.danau,
            R.drawable.nusapedina,
            R.drawable.tamanlaut,
            R.drawable.wakatobi,
        )

        image = arrayOf(
            R.drawable.pura,
            R.drawable.kepulauan,
            R.drawable.taman,
            R.drawable.pantai,
            R.drawable.nusa,
            R.drawable.gunung,
            R.drawable.danau,
            R.drawable.nusapedina,
            R.drawable.tamanlaut,
            R.drawable.wakatobi,
        )

        title = arrayOf(
            "Pura Besakih",
            "Kepulauan Derawan",
            "Taman Nasional Way Kambas",
            "Pantai Parai Tenggiri (Bangka Belitung)",
            "Nusa Dua (Bali)",
            "Gunung Rinjani (Lombok, NTB)",
            "Danau Toba (Sumatera Utara)",
            "Nusa Penida (Bali)",
            "Taman Laut Bunaken (Sulawesi Utara)",
            "Wakatobi (Sulawesi Tenggara)",
        )

        description = arrayOf(
            "Pura Agung Besakih adalah pura terbesar dan termegah di Bali. Pulau ini terletak di Desa Besakih, Kecamatan Rendang, berada di lereng sebelah barat daya Gunung Agung, gunung tertinggi di Bali",
            "Kepulauan Derawan adalah sebuah kepulauan yang berada di Kabupaten Berau, Kalimantan Timur. Di kepulauan ini terdapat sejumlah objek wisata bahari menawan, salah satunya Taman Bawah Laut yang diminati wisatawan mancanegara terutama para penyelam kelas dunia.",
            "Taman Nasional Way Kambas (TNKW) Lampung ditetapkan sebagai kawasan Taman Warisan ASEAN (ASEAN Heritage Park) yang ke-36, pada tanggal 25 Juli 2016. Artinya, Taman Nasional Way Kambas ini menjadi Taman Warisan ASEAN ke-4 di Indonesia.",
            "Parai Tenggiri memiliki struktur pantai yang landai dengan air laut berwarna hijau toska serta pasir putihnya yang lembut. Ombak di pantai ini juga tenang sehingga menjadi salah satu alasan yang menarik bagi wisatawan yang senang berenang. ",
            "Pulau Seribu Dewa satu ini memang tidak perlu diragukan lagi terkait keindahan dan pesonanya dalam memikat para wisatawan dalam negeri maupun mancanegara. Di Bali, ada satu tempat wisata yang begitu cantik, yakni Nusa Dua.",
            "Selain Gili Trawangan, di Nusa Tenggara Barat juga terdapat wisata yang tak kalah populer dan cocok bagi kamu yang suka mendaki, yakni Gunung Rinjani. Gunung ini adalah gunung berapi tertinggi kedua yang ada di Indonesia.",
            "Danau dengan keindahan yang tidak tertandingi ini merupakan danau vulkanik terbesar di Asia Tenggara dan terbesar kedua di dunia setelah Danau Victoria.",
            "Salah satu objek wisata di Bali yang populer di mata dunia saat ini adalah Nusa Penida. Tempat wisata Indonesia favorit ini adalah pilihan tepat untuk Toppers yang suka melakukan Island Hoping, dan menikmati keindahan bawah laut dengan snorkeling",
            "Destinasi wisata di Indonesia yang populer di mancanegara selanjutnya adalah Taman Laut Bunaken yang berada di Teluk Manado.",
            "Masih di Pulau Sulawesi, Taman Nasional Wakatobi juga merupakan salah satu tujuan wisata bawah laut yang populer dan mendunia.",

            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}