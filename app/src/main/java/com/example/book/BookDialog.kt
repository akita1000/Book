package com.example.book

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.book.databinding.EditTextViewBinding

class BookDialog : DialogFragment() {
    private var _binding: EditTextViewBinding? = null
    val binding
        get() = _binding!!
    lateinit var saveBook: SaveBook

    @Override
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = EditTextViewBinding.inflate(LayoutInflater.from(requireContext()))
        saveBook = requireActivity() as SaveBook
        var title = binding.editTextTitle.text.toString()
        var author = binding.editTextAuthor.text.toString()
        var description = binding.editTextDescription.text.toString()
        //var published = binding.editTextPublished.text
        return AlertDialog.Builder(requireContext())
            .setTitle("New book")
            .setMessage("print")
            .setView(binding.root)
            .setPositiveButton("Add Book") { _, _ ->
                saveBook.saveBook(
                    Book(
                        0,
                        title,
                        author,
                        0,
                        description
                    )
                )
            }
            .create()
    }
}
