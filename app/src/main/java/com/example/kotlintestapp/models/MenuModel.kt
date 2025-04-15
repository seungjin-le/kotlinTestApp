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

data class OptionDetail(
  @SerializedName("option_detail_id")
  val optionDetailId: String,
  @SerializedName("option_detail_sequence")
  val optionDetailSequence: Number,
  @SerializedName("option_detail_name")
  val optionDetailName: String,
  @SerializedName("option_detail_price")
  val optionDetailPrice: Number
)


data class OptionGroup(
  @SerializedName("option_group_id")
  val optionGroupId: String,
  @SerializedName("option_group_sequence")
  val optionGroupSequence: Number,
  @SerializedName("option_group_type")
  val optionGroupType: String,
  @SerializedName("max_selections")
  val maxSelections: Number,
  @SerializedName("min_selections")
  val minSelections: Number,
  @SerializedName("option_group_name")
  val optionGroupName: String,
  @SerializedName("option_details")
  val optionDetails: List<OptionDetail>
)

data class MenuList(
  @SerializedName("menu_id")
  val menuId: String,
  @SerializedName("menu_sequence")
  val menuSequence: Number,
  @SerializedName("menu_image_url")
  val menuImageUrl: String,
  @SerializedName("menu_name")
  val menuName: String,
  @SerializedName("menu_description")
  val menuDescription: String,
  @SerializedName("menu_price")
  val menuPrice: Number,
  @SerializedName("menu_sold_out")
  val menuSoldOut: Int,
  @SerializedName("is_adult_verification")
  val isAdultVerification: Number,
  @SerializedName("use_discount")
  val useDiscount: Number,
  @SerializedName("discount_price")
  val discountPrice: Number,
  @SerializedName("option_groups")
  val optionGroups: List<OptionGroup>,
)
