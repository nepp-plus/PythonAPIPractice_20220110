package com.neppplus.pythonapipractice_20220110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.pythonapipractice_20220110.models.BasicResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSubmit.setOnClickListener {

            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()
            val inputNick = edtNickname.text.toString()

            apiList.getRequestSignUp(
                inputEmail,
                inputPw,
                inputNick
            ).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })

        }

    }
}