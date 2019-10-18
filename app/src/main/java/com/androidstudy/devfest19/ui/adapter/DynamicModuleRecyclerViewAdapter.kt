package com.androidstudy.devfest19.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.androidstudy.devfest19.R
import com.androidstudy.devfest19.ui.model.DynamicModule

typealias ClickListener = (Int) -> Unit

internal class DynamicModuleRecyclerViewAdapter(
    private val moduleModelList: List<DynamicModule>,
    private val context: Context,
    val listener: ClickListener
) : RecyclerView.Adapter<DynamicModuleRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_modules, parent, false)
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return moduleModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moduleModelList[position], context, position)
    }

    internal class ViewHolder(itemView: View, private val clickListener: ClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageViewModule)
        private val title: TextView = itemView.findViewById(R.id.textViewModule)

        fun bind(
            moduleModel: DynamicModule,
            context: Context,
            position: Int
        ) {
            image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    moduleModel.dynamicModuleImage
                )
            )
            title.text = moduleModel.dynamicModuleTitle
            itemView.setOnClickListener {
                clickListener(position)
            }
        }
    }
}