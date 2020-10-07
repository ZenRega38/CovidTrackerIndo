package com.regadeveloper.covidtrackerindo.model

import com.google.gson.annotations.SerializedName

data class ResponseProvince(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)

data class DataItem(

	@field:SerializedName("fid")
	val fid: Int? = null,

	@field:SerializedName("provinsi")
	val provinsi: String? = null,

	@field:SerializedName("kasusMeni")
	val kasusMeni: Int? = null,

	@field:SerializedName("kodeProvi")
	val kodeProvi: Int? = null,

	@field:SerializedName("kasusSemb")
	val kasusSemb: Int? = null,

	@field:SerializedName("kasusPosi")
	val kasusPosi: Int? = null
)
