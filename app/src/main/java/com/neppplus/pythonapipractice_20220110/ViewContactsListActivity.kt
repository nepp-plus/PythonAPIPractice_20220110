package com.neppplus.pythonapipractice_20220110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.pythonapipractice_20220110.models.BasicResponse
import com.neppplus.pythonapipractice_20220110.models.ContactData
import com.neppplus.pythonapipractice_20220110.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewContactsListActivity : BaseActivity() {

    val mContactList = ArrayList<ContactData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contacts_list)

        apiList.getRequestContactList(
            ContextUtil.getUserId(mContext)
        ).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful) {

                    val br = response.body()!!

                    mContactList.addAll( br.data.contacts )

                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }
}