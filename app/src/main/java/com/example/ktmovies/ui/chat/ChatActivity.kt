package com.example.ktmovies.ui.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktmovies.KtMovieApplication
import com.example.ktmovies.R
import com.example.ktmovies.di.component.DaggerChatComponent
import com.example.ktmovies.di.factory.ViewModelProviderFactory
import com.example.ktmovies.di.module.ChatModule
import com.example.ktmovies.domain.BotMessage
import com.example.ktmovies.ui.adapter.BotAdapter
import com.example.ktmovies.ui.view_ext.getViewModel
import com.example.ktmovies.ui.view_ext.hideKeyboard
import kotlinx.android.synthetic.main.activity_chat.*
import javax.inject.Inject

class ChatActivity : AppCompatActivity() {

    @Inject
    lateinit var mFactory: ViewModelProviderFactory

    private val mViewModel: ChatViewModel by lazy {
        getViewModel<ChatViewModel>(mFactory)
    }

    private val mAdapter: BotAdapter by lazy {
        BotAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as KtMovieApplication
        DaggerChatComponent.builder().chatModule(ChatModule()).appComponent(app.component).build().inject(this)
        setContentView(R.layout.activity_chat)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setupView()
        mViewModel.messageLiveDate.observe(this, Observer {
            mAdapter.addMessage(BotMessage(it, true))
            rvBotList.scrollToPosition(mAdapter.itemCount - 1)
        })
    }

    private fun setupView() {
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
            mViewModel.sendAnswer(edtMessage.text.toString())
        }.run {
            rvBotList.scrollToPosition(mAdapter.itemCount - 1)
            edtMessage.text.clear()
            hideKeyboard()
        }
    }
}