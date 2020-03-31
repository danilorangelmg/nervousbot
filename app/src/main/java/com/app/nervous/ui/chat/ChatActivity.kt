package com.app.nervous.ui.chat

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nervous.KtMovieApplication
import com.app.nervous.R
import com.app.nervous.di.component.DaggerChatComponent
import com.app.nervous.di.module.ChatModule
import com.app.nervous.domain.BotMessage
import com.app.nervous.ui.adapter.BotAdapter
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*
import javax.inject.Inject

class ChatActivity : AppCompatActivity() {

    @Inject
    lateinit var mPresenter: ChatViewModel

    lateinit var mAdapter: BotAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as KtMovieApplication
        DaggerChatComponent.builder().chatModule(ChatModule()).appComponent(app.component).build().inject(this)
        setContentView(R.layout.activity_chat)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        rvBotList.also {
            mAdapter = BotAdapter(LinkedList())
        }.apply {
            this.layoutManager = LinearLayoutManager(this@ChatActivity).apply { stackFromEnd = true }
            this.adapter = mAdapter
        }

        btnEnviar.setOnClickListener {
            sendMessage()
        }

        mPresenter.answersLivedata.observe(this, androidx.lifecycle.Observer {
            mAdapter.addMessage(BotMessage(it, true))
            rvBotList.scrollToPosition(mAdapter.itemCount - 1)
        })
    }

    private fun sendMessage() {
        edtMessage.text.toString().let {
            mAdapter.addMessage(BotMessage(edtMessage.text.toString(), false))
            mPresenter.getAnswers(edtMessage.text.toString())
        }.run {
            rvBotList.scrollToPosition(mAdapter.itemCount - 1)
            edtMessage.text.clear()
            hideKeyboard()
        }
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