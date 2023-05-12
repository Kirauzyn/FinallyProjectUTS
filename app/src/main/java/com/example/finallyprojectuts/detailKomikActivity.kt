package com.example.finallyprojectuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.finallyprojectuts.fragment.UntukmuFragment

class detailKomikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_komik)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val komik = intent.getParcelableExtra<Komik>(UntukmuFragment.INTENT_PARCELABLE)

        val imgDetail = findViewById<ImageView>(R.id.ivPhoto)
        val nameKomik = findViewById<TextView>(R.id.tvJudul)
//        val descKomik = findViewById<TextView>(R.id.tvDesc)

        imgDetail.setImageResource(komik?.imgDetail!!)
        nameKomik.text = komik.nameKomik
//        descKomik.text = komik.descKomik
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}