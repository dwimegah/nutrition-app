package com.belajar.submissionbeginnerandroid

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {
    companion object {
        const val key_food = "key_food"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val imgProfile: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDesc: TextView = findViewById(R.id.tv_item_description)
        val tvCategoryFood: TextView = findViewById(R.id.tv_item_category)
        val tvNutrition: TextView = findViewById(R.id.tv_item_gizi)
        val btnShare : Button = findViewById(R.id.action_share)

        btnShare.setOnClickListener() {
            Toast.makeText(this, "Link copied!", Toast.LENGTH_SHORT).show()
        }

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(key_food, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(key_food)
        }
        if (dataHero != null) {
            val name = dataHero.name
            val image = dataHero.photo
            val desc = dataHero.description
            val category = dataHero.category
            val nutrition = dataHero.nutrition
            Glide.with(this@DetailActivity).load(image).into(imgProfile)
            tvName.text = name
            tvDesc.text = desc
            tvCategoryFood.text = category
            tvNutrition.text = nutrition
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}