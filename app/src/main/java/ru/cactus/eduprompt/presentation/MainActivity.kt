package ru.cactus.eduprompt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.cactus.eduprompt.R
import ru.cactus.eduprompt.data.entities.Result
import ru.cactus.eduprompt.presentation.main.MainAdapter
import ru.cactus.eduprompt.presentation.main.MainViewModel
import ru.cactus.eduprompt.util.Status

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel() //Ленивая инит
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        mainViewModel.getLessons().observe(this, Observer {
            it?.let { resource ->
                run {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    retrieveList(resource.result)
                }

//                when (resource.status) {
//                    Status.SUCCESS -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        resource.data?.let { lessons -> retrieveList(lessons.) }
//                    }
//                    Status.ERROR -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//                    }
//                    Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                        recyclerView.visibility = View.GONE
//                    }
//                }
            }
        })
    }

    private fun retrieveList(lessonsList: List<Result>) {
        adapter.apply {
            addUsers(lessonsList)
            notifyDataSetChanged()
        }
    }
}