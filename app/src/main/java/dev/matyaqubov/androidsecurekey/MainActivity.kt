package dev.matyaqubov.androidsecurekey

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.matyaqubov.androidsecurekey.adapter.PosterAdapter
import dev.matyaqubov.androidsecurekey.model.Post
import dev.matyaqubov.androidsecurekey.utils.SwipeHelper
import dev.matyaqubov.androidsecurekey.viewmodel.MainViewModel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var serverKey = BuildConfig.SERVER_KEY
    var smsKey = BuildConfig.SMS_KEY

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PosterAdapter
    lateinit var viewModel: MainViewModel

    init {
        System.loadLibrary("keys")
    }

    private var ss: String? = null
    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("@@@", "onCreate: $serverKey")
        Log.d("@@@", "onCreate: ${smsKey}")
        Log.d("@@@", "onCreate: ${getPublicKey()}")
        Log.d("@@@", "onCreate: ${getPrivateKey()}")
       initViews()

    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        viewModel.apiPostList().observe(this, {
            refreshAdapter(it)
        })

        val b_add = findViewById<FloatingActionButton>(R.id.f_button).also {
            it.setOnClickListener {
//                callCreatePostActivity()
            }
        }

        SwipeHelper.setSwipeRightToLeft(this, recyclerView)

    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        adapter = PosterAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }
}