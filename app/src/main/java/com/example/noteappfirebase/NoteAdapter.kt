package com.example.noteappfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val note = noteList[position]
        holder.setNoteData(note)
    }

    fun setData(list: MutableList<Note>) {
        noteList.clear()
        noteList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return noteList.size

    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var titleTextView: TextView = itemView.findViewById(R.id.titletextView)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.descriptiontextview)
        fun setNoteData(data: Note) {
            titleTextView.text = data.title
            descriptionTextView.text = data.description
        }


    }

}