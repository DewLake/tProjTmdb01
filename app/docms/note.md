## 設定
1. 請把 `gradle.properties` 檔案放在專案根目錄下。

## 需求

1. 補完 `PopularListFragment.GetPopular()`

## 說明

1. popularlist item 中, runtime 在 MovieDetail 中, 可由
   popularlist Resopnse.Result 中的 id(movieId) 再去查詢。
   
2. TmdbRepository.GetMovieDetail() 會呼叫 API 取得 Movie Detail,
   但目前沒有回值, 動作須在 onDateReadyCallback 中完成。
fun GetMovieDetail(
               movieId:String,
               onDataReadyCallback: (MovieDetailResponse)->Unit)

## API 網址
https://developers.themoviedb.org/3/movies/get-popular-movies
https://developers.themoviedb.org/3/movies/get-movie-details