package com.sandhyagill.chatapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sandhyagill.chatapplication.databinding.ActivityMainBinding
import com.sandhyagill.chatapplication.databinding.CustomDialogBoxBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ChatAdapter
    lateinit var layoutManager: LinearLayoutManager
    var messageDataClassArray = arrayListOf<MessageDataClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ChatAdapter(messageDataClassArray)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        binding.ivSend.setOnClickListener {
            if (binding.etSendText.text.toString().trim().isNullOrEmpty()){
                binding.etSendText.error = resources.getString(R.string.enter_text_to_send)
            }else{
                var dialog = Dialog(this)
                var customDialogBinding = CustomDialogBoxBinding.inflate(layoutInflater)
                dialog.setContentView(customDialogBinding.root)
                dialog.show()

                customDialogBinding.btnSend.setOnClickListener {
                    var id = if (customDialogBinding.rbFirst.isChecked){
                        0
                    }else 1
                    messageDataClassArray.add(MessageDataClass(id = id, message = binding.etSendText.text.toString()))
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
    }
}