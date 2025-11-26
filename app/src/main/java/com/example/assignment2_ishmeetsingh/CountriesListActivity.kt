package com.example.assignment2_ishmeetsingh

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class CountriesListActivity : AppCompatActivity() {
    private val TAG = "CountriesListActivity"
    private lateinit var adapter: CountriesAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        Log.d(TAG, "onCreate")

        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)

        val sample = mutableListOf(
            Country("Canada"), Country("United States"), Country("Mexico"),
            Country("United Kingdom"), Country("Germany"), Country("France"),
            Country("India"), Country("China"), Country("Japan")
        )

        adapter = CountriesAdapter(sample) { country, pos ->
            Snackbar.make(recycler, "Clicked: ${country.name}", Snackbar.LENGTH_SHORT).show()
        }
        recycler.adapter = adapter

        val touchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(rv: RecyclerView, vh: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false
            override fun onSwiped(vh: RecyclerView.ViewHolder, dir: Int) {
                val pos = vh.bindingAdapterPosition
                val removed = adapter.removeAt(pos)
                Snackbar.make(recycler, "${removed.name} removed", Snackbar.LENGTH_LONG)
                    .setAction("UNDO") {
                        adapter.addAt(pos, removed)
                        recycler.scrollToPosition(pos)
                    }.show()
            }
        })
        touchHelper.attachToRecyclerView(recycler)
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
}
