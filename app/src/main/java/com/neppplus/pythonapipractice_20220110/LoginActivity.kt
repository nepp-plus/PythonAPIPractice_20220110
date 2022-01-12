package com.neppplus.pythonapipractice_20220110

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.neppplus.pythonapipractice_20220110.models.BasicResponse
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignUp.setOnClickListener {
            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)
        }

        btnLogin.setOnClickListener {

            val inputId = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()

            apiList.getRequestLogin(inputId, inputPw).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

                    if (response.isSuccessful) {

                        val br = response.body()!!

                        Toast.makeText(
                            mContext,
                            "${br.data.user.nickname}님 환영합니다!",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                    else {

                        val jsonObj = JSONObject( response.errorBody()!!.string() )

                        Toast.makeText(mContext, jsonObj.getString("message"), Toast.LENGTH_SHORT).show()

                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })

        }

    }
}