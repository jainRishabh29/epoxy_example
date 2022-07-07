package com.example.epoxy_example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.epoxy_example.R
import com.example.epoxy_example.controller.EpoxyController
import com.example.epoxy_example.dataClass.Data

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val controller = EpoxyController()
        findViewById<EpoxyRecyclerView>(R.id.messagesView).setController(controller)
        controller.allMessages= Data.messages
        controller.allRecents= Data.recentlyActive
        controller.allStories= Data.story
    }
}