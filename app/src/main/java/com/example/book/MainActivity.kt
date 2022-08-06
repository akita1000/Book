package com.example.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity(), DeleteBook, SaveBook {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!
    var adapter = BookAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var bookApi: BookApi = RetrofitHelper.getBookApi()
        var bookDao: BookDao = DataBaseHelper.getDatabase(this).bookDao()
        var bookViewModelFactory: BookViewModelFactory =
            BookViewModelFactory(BookRepository(bookDao, bookApi))

        val viewModel =
            ViewModelProvider(this, bookViewModelFactory)
                .get(BookViewModel::class.java)
        binding.recView.adapter = adapter
        binding.recView.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.Main).launch {
            var list: Response<List<Book>> = RetrofitHelper.getBookApi().getBook()
            list.body()?.let { adapter.setBookList(it) }
            var response = viewModel.bookRepository.getBookApi()
//            var response = RetrofitHelper.getBookApi().getBook()
            var book: Book = response.body()?.get(0) ?: Book(0, "", "", 0, "")
//            viewModel.bookRepository.saveBookToDB(book)
        }
        binding.buttonRv.setOnClickListener {
            BookDialog().show(supportFragmentManager, "TAG")
        }
    }

    override fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            RetrofitHelper.getBookApi().deleteBook(id)
        }
    }

    override fun saveBook(book: Book) {
        CoroutineScope(Dispatchers.Main).launch {
            RetrofitHelper.getBookApi().saveBook(book)
            adapter.notifyDataSetChanged()
        }
    }
}
