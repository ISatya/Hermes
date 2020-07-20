package com.droid.hermes.teams.presentation.teamSearch.itemDecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SearchResultPaddingDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) top = margin
            parent.adapter?.let{
                if (parent.getChildAdapterPosition(view) == it.itemCount - 1) bottom = margin
            }
        }

    }

}