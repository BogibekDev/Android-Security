package dev.matyaqubov.androidsecurekey.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.matyaqubov.androidsecurekey.model.Post
import dev.matyaqubov.androidsecurekey.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePostViewModel : ViewModel() {
    val updatedPost = MutableLiveData<Post>()

    fun apiUpdatePost(post: Post): LiveData<Post> {
        RetrofitHttp.postService.updatePost(post.id, post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                updatedPost.value = response.body()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                updatedPost.value = null
            }

        })

        return updatedPost
    }
}