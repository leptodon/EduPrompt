package ru.cactus.eduprompt.ui.main.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.cactus.eduprompt.R
import ru.cactus.eduprompt.data.model.Result

class MainAdapter(private val lessonsList: ArrayList<Result>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(lesson: Result) {
            itemView.apply {
                textViewUserName.text = lesson.name
                textViewUserEmail.text = lesson.org
                Glide.with(imageViewAvatar.context)
                    .load(lesson.media.lesson_image)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = lessonsList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(lessonsList[position])
    }

    fun addUsers(lessonsList: List<Result>) {
        this.lessonsList.apply {
            clear()
            addAll(lessonsList)
        }

    }
}