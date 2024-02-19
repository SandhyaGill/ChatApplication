package com.sandhyagill.chatapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatAdapter(var fabClickInterface: FabRecyclerInterface): RecyclerView.Adapter<ChatAdapter.ViewHolderClass>() {
    inner class ViewHolderClass(var view: View): RecyclerView.ViewHolder(view){
        var tvRight = view.findViewById<TextView>(R.id.tvRight)
        var tvRTime = view.findViewById<TextView>(R.id.tvRTime)
        var tvLeft = view.findViewById<TextView>(R.id.tvLeft)
        var tvLTime = view.findViewById<TextView>(R.id.tvLTime)
//        var fab = view.findViewById<FloatingActionButton>(R.id.fab)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolderClass {
         var view = LayoutInflater.from(parent.context).inflate(R.layout.chat,parent,false)//
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolderClass, position: Int) {
        holder.tvRight.setText("Right Side Msg")
        holder.tvLeft.setText("Left Side Msg")
//        holder.fab.setOnClickListener {
//            fabClickInterface.onfabClick()
//        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}