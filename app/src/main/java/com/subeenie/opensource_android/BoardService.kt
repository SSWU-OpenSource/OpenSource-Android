package com.subeenie.opensource_android

import com.subeenie.opensource_android.data.remote.request.RequestBoard
import com.subeenie.opensource_android.data.remote.response.ResponseBoard
import com.subeenie.opensource_android.data.remote.response.ResponseScrap
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BoardService {

    // 전체 게시글 조회
    //@GET("api/post")
    // fun getPostInfo(): Call<List<ResponseBoard>>

    //게시글 작성
    //@POST("api/post")
    // fun postBoard(
    //     @Body body: RequestBoard
    //): Call<ResponseBoard>

    // 상세보기
    /* @GET("api/post/{postId}")
     fun getReadInfo(
         @Path("postId") postId: Int
     ): Call<ResponseDetail>*/

    //스크랩 게시글
    //@GET("api/scrap")
    // fun getScrapBoardInfo(): Call<List<ResponseBoard>>

    //스크랩 하기
    //@POST("api/scrap")
    //fun postScrap(
    //    @Body body: ResponseScrap
    //): Call <ResponseScrap>

    //스크랩 여부
    //@GET("api/scrap/{postId}")
    // fun getScrapInfo(
    //   @Path("postId") postId:Int
    //   ): Call<List<ResponseScrap>>


}