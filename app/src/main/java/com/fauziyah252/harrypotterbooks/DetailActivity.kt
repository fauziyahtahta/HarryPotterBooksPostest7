package com.fauziyah252.harrypotterbooks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fauziyah252.harrypotterapp.Book
import com.fauziyah252.harrypotterbooks.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Book Detail"

        val book = intent.getParcelableExtra<Book>("BOOK_DATA")

        book?.let {
            with(binding) {
                tvDetailTitle.text = it.title
                tvOriginalTitle.text = it.originalTitle
                tvDetailDate.text = it.releaseDate
                tvDescription.text = it.description
                tvPages.text = "Pages: ${it.pages}"

                Glide.with(this@DetailActivity)
                    .load(it.cover)
                    .into(ivDetailCover)
            }
        }
    }
}