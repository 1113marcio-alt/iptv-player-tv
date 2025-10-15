package com.iptv.player.presentation.main

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.iptv.player.R

class MainFragment : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadMainMenu()
    }

    private fun setupUI() {
        title = getString(R.string.app_name)
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
    }

    private fun loadMainMenu() {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        
        // Menu simples para teste
        val menuItems = listOf("Canais", "Favoritos", "EPG", "Configurações")
        val listRowAdapter = ArrayObjectAdapter(StringPresenter())
        
        menuItems.forEach { item ->
            listRowAdapter.add(item)
        }
        
        val header = HeaderItem(0, getString(R.string.main_menu))
        rowsAdapter.add(ListRow(header, listRowAdapter))
        
        adapter = rowsAdapter
    }
}

// Classe simples para mostrar texto
class StringPresenter : androidx.leanback.widget.Presenter() {
    override fun onCreateViewHolder(parent: android.view.ViewGroup): ViewHolder {
        val textView = android.widget.TextView(parent.context)
        textView.setTextColor(android.graphics.Color.WHITE)
        textView.textSize = 24f
        textView.setPadding(50, 50, 50, 50)
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        (viewHolder.view as android.widget.TextView).text = item.toString()
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {}
}
