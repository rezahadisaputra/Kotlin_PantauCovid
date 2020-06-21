package com.example.boedoet.pantaucovid

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListDataAdapter(val listData: ArrayList<Covid>): RecyclerView.Adapter<ListDataAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_data_provinsi,viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val covid = listData[position]

        Glide.with(holder.itemView.context)
            .load(covid.Photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.namaprovinsi.text = covid.Provinsi
        holder.kasuspositive.text = "Kasus Positive:        " + covid.Positive
        holder.jumlahsembuh.text = "Jumlah Sembuh:     " + covid.Sembuh
        holder.jumlahmeninggal.text = "Jumlah Meninggal: " + covid.Meninggal

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_data::class.java)
            moveDetail.putExtra(detail_data.EXTRA_NAMAPROVINSI, covid.Provinsi)
            moveDetail.putExtra(detail_data.EXTRA_PHOTO, covid.Photo )
            moveDetail.putExtra(detail_data.EXTRA_POSITIVE, covid.Positive)
            moveDetail.putExtra(detail_data.EXTRA_SEMBUH, covid.Sembuh)
            moveDetail.putExtra(detail_data.EXTRA_MENINGGAL, covid.Meninggal)
            mContext.startActivity(moveDetail)
        }

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var namaprovinsi: TextView = itemView.findViewById(R.id.tv_nama_provinsi)
        var kasuspositive: TextView = itemView.findViewById(R.id.tv_item_positive)
        var jumlahsembuh: TextView = itemView.findViewById(R.id.tv_item_sembuh)
        var jumlahmeninggal: TextView = itemView.findViewById(R.id.tv_item_meninggal)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }


}
