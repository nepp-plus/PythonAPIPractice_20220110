package com.neppplus.pythonapipractice_20220110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.pythonapipractice_20220110.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_edit_contact.*

class EditContactActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        btnSave.setOnClickListener {

            val inputName = edtName.text.toString()
            val inputPhoneNum = edtPhoneNum.text.toString()
            val inputMemo = edtMemo.text.toString()

            apiList.getRequestAddContact(
                ContextUtil.getUserId(mContext),
                inputName,
                inputPhoneNum,
                inputMemo
            )

        }

    }
}