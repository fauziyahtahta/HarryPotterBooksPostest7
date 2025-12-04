package com.fauziyah252.harrypotterbooks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fauziyah252.harrypotterapp.Book
import com.fauziyah252.harrypotterbooks.databinding.ItemBookBinding

class BookAdapter(
    private val bookList: List<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        with(holder.binding) {
            tvTitle.text = book.title
            tvReleaseDate.text = book.releaseDate

            Glide.with(holder.itemView.context)
                .load(book.cover)
                .into(ivBookCover)

            root.setOnClickListener {
                onClick(book)
            }
        }
    }

    override fun getItemCount() = bookList.size
}