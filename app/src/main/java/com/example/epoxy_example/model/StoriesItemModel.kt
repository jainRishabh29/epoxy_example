package com.example.epoxy_example.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy_example.R
import com.example.epoxy_example.dataClass.Stories

@EpoxyModelClass(layout = R.layout.view_holder_story_item)
abstract class StoriesItemModel : EpoxyModelWithHolder<StoriesItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var story:Stories

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.profileName.text = story.profileName
    }

    class Holder():EpoxyHolder(){
        lateinit var storyImage:ImageView
        lateinit var profileName: TextView

        override fun bindView(itemView: View) {
          storyImage = itemView.findViewById(R.id.recently_added_story_image)
            profileName = itemView.findViewById(R.id.recently_added_profile_name)

        }

    }
}