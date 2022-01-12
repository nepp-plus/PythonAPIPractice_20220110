package com.neppplus.pythonapipractice_20220110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.pythonapipractice_20220110.models.BasicResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject
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

                    if (response.isSuccessful) {
                        val br = response.body()!!

                        val signUpUser = br.data.user
                        Toast.makeText(
                            mContext,
                            "${signUpUser.nickname} 님 회원가입을 축하합니다!",
                            Toast.LENGTH_SHORT
                        ).show()

                        finish()
                    }
                    else {
//                        서버가 400 등의 실패 코드를 준 경우.
                        val jsonObj = JSONObject( response.errorBody()!!.string() )

                        val message = jsonObj.getString("message")
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()

                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })

        }

    }
}