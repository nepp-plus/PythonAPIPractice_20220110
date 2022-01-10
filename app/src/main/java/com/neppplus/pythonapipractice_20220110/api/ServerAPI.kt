package com.neppplus.apipractice_20220106.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {
    
//    서버통신을 하게 도와주는 클래스 (Retrofit) 를 객체로 만들어주는 기능.
    
//    함수 한번만 호출 하면 => 편하게 가져다 쓸 수 있게 함수로 만들어두자.
    
//    클래스이름.기능() => @classmethod 에 대응되는 기능 활용.
    
    companion object {

//        이 { } 안에 적는 변수 / 함수들은 => ServerAPI.변수/함수  로 활용 가능.

        private val BASE_URL = "https://api.gudoc.in"  // 기본 보안 처리는 되어있는 서버. => 이 클래스 내부에서만 사용할예정.
        private var retrofit : Retrofit? = null // 서버 연결 전담 변수. => 기본적으로는 아직 안만든상태 (null)

//        retrofit 변수에 환경설정 + 객체화 => 가져다 쓸 수 있게 하는 기능 (함수)

        fun getRetrofit(context: Context) : Retrofit {

//            retrofit 변수가 null이라면 => 새 객체를 만들어주자.
//            null이 아니라면 => 이미 만들어둔게 있다 => 있는 객체를 사용하게 하자.
//            하나의 객체를 계속 재활용하게 유도 => 디자인패턴 : 싱글톤 패턴 적용

            if (retrofit == null) {

//                토큰의 경우, 여러 API 함수에서 사용해야함 + 매번 같은 토큰값 입력 (ContextUtil.getToken())
//                    => 자동화 하면 편하다.
//                    => 레트로핏 객체 생성 전에, 토큰에 관련된 세팅을 코드로 추가해두자.


//                API 요청이 만들어질때 -> 가로채서, 헤더를 추가해주자.
//                  헤더가 붙여지고 나서 => 나머지 API 요청 실행. (자동으로 헤더 첨부 효과 발생)

                val interceptor = Interceptor {
                    with(it) {

//                        새 리퀘스트를 만들자. => 헤더가 첨부된 리퀘스트

                        val newRequest = request().newBuilder()
                            .addHeader("X-Http-Token", "")
                            .build()

//                        완성된 새 리퀘스트로 작업 이어가게
                        proceed(newRequest)

                    }
                }

//                위에 적은 인터셉터를 적용하는 통신 체계. (클라이언트의 기능을 수정.)
                val myClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

//                실제 레트로핏 객체 생성. => 인터셉터 적용 클라이언트를 이용하도록.
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) // 어느 서버안에서 움직일건지?
                    .addConverterFactory(GsonConverterFactory.create())  // JSON -> 자동 분석 도구 설치.
                    .client(myClient)
                    .build()

            }

//            retrofit이 null 이라면 채워주고 -> 아니라면, 있는 객체 사용.
            return retrofit!!  // 절대 null일 리 없다. 명시.


        }



    }
    
}