package com.example.epoxy_example.controller

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.example.epoxy_example.dataClass.Messages
import com.example.epoxy_example.dataClass.Recents
import com.example.epoxy_example.dataClass.Stories
import com.example.epoxy_example.model.RecentlyActiveItemModel_
import com.example.epoxy_example.model.StoriesItemModel_
import com.example.epoxy_example.model.headerItem
import com.example.epoxy_example.model.messageItem


class EpoxyController : AsyncEpoxyController() {

    var allMessages: List<Messages> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allStories: List<Stories> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allRecents: List<Recents> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {

        headerItem {
            id("all stories")
            title("Stories")
        }

        val model1 = allStories.map {
            StoriesItemModel_()
                .id(it.id)
                .story(it)
        }
        carousel {
            id("story")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            hasFixedSize(true)
            models(model1)
        }

        headerItem {
            id("all messages")
            title("All Messages")
        }
        allMessages.forEach {
            messageItem {
                id(it.id)
                message(it)
            }
        }
        headerItem {
            id("recently_active")
            title("Recently Active")
        }
        val models = allRecents.map {
            RecentlyActiveItemModel_()
                .id(it.id)
                .recent(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            hasFixedSize(true)
            models(models)
        }

    }
}