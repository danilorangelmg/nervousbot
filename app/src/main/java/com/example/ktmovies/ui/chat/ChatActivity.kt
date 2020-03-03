package com.example.ktmovies.ui.chat

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktmovies.KtMovieApplication
import com.example.ktmovies.R
import com.example.ktmovies.contract.ChatContract
import com.example.ktmovies.di.component.DaggerChatComponent
import com.example.ktmovies.di.module.ChatModule
import com.example.ktmovies.domain.BotMessage
import com.example.ktmovies.ui.adapter.BotAdapter
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*
import javax.inject.Inject


class ChatActivity : AppCompatActivity(), ChatContract.View {

    @Inject
    lateinit var mPresenter: ChatContract.Presenter

    lateinit var mAdapter: BotAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as KtMovieApplication
        DaggerChatComponent.builder().chatModule(ChatModule(this)).appComponent(app.component).build().inject(this)
        setContentView(R.layout.activity_chat)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setupView()
    }

    override fun setupView() {
        rvBotList.also {
            mAdapter = BotAdapter(LinkedList())
        }.apply {
            this.layoutManager = LinearLayoutManager(this@ChatActivity).apply { stackFromEnd = true }
            this.adapter = mAdapter
        }

        btnEnviar.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        edtMessage.text.toString().let {
            mAdapter.addMessage(BotMessage(edtMessage.text.toString(), false))
            mPresenter.sendAnswer(edtMessage.text.toString())
        }.run {
            rvBotList.scrollToPosition(mAdapter.itemCount - 1)
            edtMessage.text.clear()
            hideKeyboard()
        }
    }

    override fun setAnswer(answer: String) {
        mAdapter.addMessage(BotMessage(answer, true))
        rvBotList.scrollToPosition(mAdapter.itemCount - 1)
    }

    private fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = this.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}