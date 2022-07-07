package com.example.epoxy_example.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy_example.R
import com.example.epoxy_example.dataClass.Recents

@EpoxyModelClass(layout = R.layout.view_holder_recently_active_item)
abstract class RecentlyActiveItemModel : EpoxyModelWithHolder<RecentlyActiveItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var recent: Recents

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(recent) {
            holder.profileName.text = name
            holder.lastSeen.text = lastSeen
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var profileName: TextView
        lateinit var lastSeen: TextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.recently_added_profile_image)
            profileName = itemView.findViewById(R.id.recently_added_profile_name)
            lastSeen = itemView.findViewById(R.id.recently_added_last_seen)
        }
    }
}