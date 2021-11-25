package ru19july.bask.pixabayexampl.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru19july.bask.pixabayexampl.api.data.SearchHit
import ru19july.bask.pixabayexample.R
import ru19july.bask.pixabayexample.databinding.ItemHitBinding

class HitsAdapter : RecyclerView.Adapter<HitsAdapter.HitHolder>() {

    private val hits = mutableListOf<SearchHit>()

    class HitHolder(private val itemHitBinding: ItemHitBinding) :
        RecyclerView.ViewHolder(itemHitBinding.root) {

        fun bind(hit: SearchHit) {
            Glide.with(itemView)
                .load(hit.largeImageURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemHitBinding.image)
        }
    }

    fun setData(hits: List<SearchHit>) {
        Log.d("some", "hits: $hits")
        this.hits.clear()
        this.hits.addAll(hits)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HitHolder {
        val itemHitBinding =
            ItemHitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HitHolder(itemHitBinding)
    }

    override fun onBindViewHolder(holder: HitHolder, position: Int) {
        val hit = hits[position]
        holder.bind(hit)
    }

    override fun getItemCount(): Int = hits.size
}