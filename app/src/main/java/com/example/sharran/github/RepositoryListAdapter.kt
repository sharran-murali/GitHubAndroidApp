package com.example.sharran.github

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sharran.github.utils.AppContext
import com.example.sharran.github.utils.RepositoryDetail
import kotlinx.android.synthetic.main.repository_list_item.view.*

class RepositoryListAdapter(val context: Context , var repositoryList : List<RepositoryDetail>) :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {
    val appContext = AppContext.instance

    class RepositoryListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.name
        val description = itemView.description
        val language = itemView.language
        val watchers = itemView.watchers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repository_list_item, parent, false)
        return RepositoryListAdapter.RepositoryListViewHolder(view)
    }

    override fun getItemCount(): Int = repositoryList.size


    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        val repository = repositoryList[position]

        holder.name.text = repository.full_name
        holder.description.text = repository.description ?: ""
        holder.language.text = repository.language
        holder.watchers.text = repository.watchers.toString()
        holder.itemView.setOnClickListener {
            appContext.repositoryDetail = repository
            val intent = Intent(context,RepositoryDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

}