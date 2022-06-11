package br.ucsal.mobile.dogfeed.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "url_table")
data class DogPhoto(@PrimaryKey @ColumnInfo(name = "url") @Json(name = "message") val imgSrcUrl: String)