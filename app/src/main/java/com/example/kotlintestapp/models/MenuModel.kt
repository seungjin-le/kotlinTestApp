package com.example.kotlintestapp.models

import com.google.gson.annotations.SerializedName


data class FirstCategory(
  @SerializedName("parent_category_id")
  val parentCategoryId: String,
  @SerializedName("category_name")
  val categoryName: String,
  @SerializedName("category_sequence")
  val categorySequence: Number,
)

data class ChildCategory(
  @SerializedName("child_category_id")
  val childCategoryId: String,
  @SerializedName("category_name")
  val categoryName: String,
  @SerializedName("category_sequence")
  val categorySequence: Number,
)