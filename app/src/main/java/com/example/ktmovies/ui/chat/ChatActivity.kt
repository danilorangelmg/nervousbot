package com.example.ktmovies.ui.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktmovies.KtMovieApplication
import com.example.ktmovies.R
import com.example.ktmovies.contract.ChatContract
import com.example.ktmovies.di.component.DaggerChatComponent
import com.example.ktmovies.di.module.ChatModule
import com.example.ktmovies.domain.BotMessage
import com.example.ktmovies.ui.adapter.BotAdapter
import com.example.ktmovies.ui.view_ext.hideKeyboard
import kotlinx.android.synthetic.main.activity_chat.*
import javax.inject.Inject

class ChatActivity : AppCompatActivity(), ChatContract.View {

    @Inject
    lateinit var mPresenter: ChatContract.Presenter

    private val mAdapter: BotAdapter by lazy {
        BotAdapter()
    }

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
        rvBotList.apply {
            this.layoutManager = LinearLayoutManager(this@ChatActivity).apply { stackFromEnd = true }
            this.adapter = mAdapter
        }

        btnEnviar.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        edtMessage.text.toString().let {
            mAdapter.addMessage(BotMessage(edtMessage.text.toString()))
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
}