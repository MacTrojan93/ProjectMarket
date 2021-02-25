package com.example.breakingbaddk.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbaddk.data.model.DataCharacter
import com.example.breakingbaddk.databinding.ItemBreakingDetailBinding
import com.squareup.picasso.Picasso

class CharacterDetailAdapter:
    RecyclerView.Adapter<CharacterDetailAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val viewBinding: ItemBreakingDetailBinding):
            RecyclerView.ViewHolder(viewBinding.root){
        fun onBind(item: DataCharacter){
            viewBinding.tvCharacterNameDetail.text = item.name
            viewBinding.tvCharacterOccupationDetail.text = item.occupation.toString()
            viewBinding.tvCharacterStatusDetail.text = item.status
            viewBinding.tvCharacterNickDetail.text = item.nickname
            viewBinding.tvCharacterSeasonDetail.text = item.season
            Picasso.get()
                .load(item.image)
                .into(viewBinding.ivCharacterPortraitDetail)
        }
    }

    private var dataSet: List<DataCharacter>? = null

    fun setDatSet(dataSet: List<DataCharacter>){
        this.dataSet = dataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemBreakingDetailBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun getItemCount() = dataSet?.size ?: 0

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        dataSet?.let {
            holder.onBind(it[position])
        }
    }
}