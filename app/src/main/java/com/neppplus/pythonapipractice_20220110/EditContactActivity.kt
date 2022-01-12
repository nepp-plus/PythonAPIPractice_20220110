package com.neppplus.pythonapipractice_20220110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.pythonapipractice_20220110.models.BasicResponse
import com.neppplus.pythonapipractice_20220110.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_edit_contact.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            ).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

                    if (response.isSuccessful) {
                        Toast.makeText(mContext, "연락처 추가에 성공했습니다.", Toast.LENGTH_SHORT).show()
                        finish()
                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })

        }

    }
}