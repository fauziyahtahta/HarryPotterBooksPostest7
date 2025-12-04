package com.fauziyah252.harrypotterbooks

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fauziyah252.harrypotterbooks.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ganti judul toolbar biar keren
        supportActionBar?.title = "Harry Potter Books"

        setupRecyclerView()
        fetchBooks()
    }

    private fun setupRecyclerView() {
        // Setup awal adapter kosong
        binding.rvBooks.layoutManager = LinearLayoutManager(this)
    }

    private fun fetchBooks() {
        // Pake Coroutines biar gak freeze UI
        lifecycleScope.launch {
            try {
                // Tembak API
                val books = RetrofitClient.instance.getBooks()

                // Pasang ke adapter kalo sukses
                bookAdapter = BookAdapter(books) { selectedBook ->
                    // Logic kalo diklik -> pindah ke DetailActivity bawa data
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("BOOK_DATA", selectedBook)
                    startActivity(intent)
                }
                binding.rvBooks.adapter = bookAdapter

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Gagal load data: ${e.message}", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
}