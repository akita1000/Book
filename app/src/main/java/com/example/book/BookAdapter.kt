package com.example.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.book.databinding.ItemBinding

class BookAdapter(var list: List<Book>, var deleteBook: DeleteBook) :
    RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        var book = list[position]
        holder.itemBinding.textViewId.text = book.id.toString()
        holder.itemBinding.textViewTitle.text = book.title
        holder.itemBinding.textViewAuthor.text = book.author
        holder.itemBinding.textViewPublished.text = book.published.toString()
        holder.itemBinding.textViewDescription.text = book.description
        holder.itemBinding.cl.setOnClickListener {
            println(book)
            deleteBook.delete(book.id)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setBookList(list: List<Book>) {
        this.list = list
        notifyDataSetChanged()
    }

}