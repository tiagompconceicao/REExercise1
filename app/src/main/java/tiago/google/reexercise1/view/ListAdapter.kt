package tiago.google.reexercise1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tiago.google.reexercise1.R
import tiago.google.reexercise1.model.Item

class ListAdapter(itemList: List<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList = itemList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: Item = itemList[position]
        return (holder as ContactHolder?)!!.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    private inner class ContactHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var userId: TextView = itemView.findViewById(R.id.userId)
        var id: TextView = itemView.findViewById(R.id.id)
        var title: TextView = itemView.findViewById(R.id.title)
        var completed: TextView = itemView.findViewById(R.id.completed)


        fun bind(item: Item) {
            userId.text = item.userId.toString()
            id.text = item.id.toString()
            title.text = item.title
            completed.text = item.completed.toString()

        }
    }
}