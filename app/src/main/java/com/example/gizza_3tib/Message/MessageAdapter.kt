package com.example.gizza_3tib.Message

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.gizza_3tib.Message.MessageActivity
import com.example.gizza_3tib.Message.MessageModel
import com.example.gizza_3tib.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        val view = binding.root
        val data = messages[position]

        // Muat gambar dari URL ke ImageView
        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        view.setOnClickListener {
            val i = Intent(context, MessageActivity::class.java)
            i.putExtra("SENDER", data.senderName)
            i.putExtra("PESAN", data.messageText)
            context.startActivity(i)
        }

        return view
    }
}
