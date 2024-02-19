package com.sandhyagill.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sandhyagill.chatapplication.databinding.ActivityMainBinding
import com.sandhyagill.chatapplication.databinding.CustomDialogBoxBinding

class MainActivity : AppCompatActivity(), FabRecyclerInterface {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ChatAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ChatAdapter(this)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            var dialog = BottomSheetDialog(this)
            var customDialogBoxBinding = CustomDialogBoxBinding.inflate(layoutInflater)
            dialog.setContentView(customDialogBoxBinding.root)

            customDialogBoxBinding.rbFirst.setOnClickListener {}
            customDialogBoxBinding.rbSecond.setOnClickListener {}
        }
    }
}