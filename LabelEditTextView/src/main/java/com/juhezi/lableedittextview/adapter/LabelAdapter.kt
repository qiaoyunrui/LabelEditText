package com.juhezi.lableedittextview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.juhezi.lableedittextview.R
import java.util.*

/**
 * Created by qiao1 on 2017/1/4.
 */
class LabelAdapter : RecyclerView.Adapter<LabelAdapter.LabelHolder>() {

    var labels: ArrayList<String> = ArrayList()

    var max_label_count: Int = 10
        set(value) {
            if (value <= 0) {
                field = 10
            } else {
                field = value
            }
        }

    override fun onBindViewHolder(holder: LabelHolder?, position: Int) {
        holder?.mTvLabel?.text = labels[position]
        holder?.itemView?.setOnClickListener {
            itemClickListener?.invoke(labels[position])
        }
    }

    override fun getItemCount(): Int = if (labels.size > max_label_count) max_label_count else labels.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LabelHolder {
        var item_view = LayoutInflater.from(parent!!.context)!!
                .inflate(R.layout.label_item, parent, false)
        return LabelHolder(item_view)
    }

    class LabelHolder(var view: View?) : RecyclerView.ViewHolder(view) {

        var mTvLabel: TextView? = null

        init {
            mTvLabel = view?.findViewById(R.id.tv_label) as TextView?
        }

    }

    var itemClickListener: ((label: String) -> Unit)? = null

}