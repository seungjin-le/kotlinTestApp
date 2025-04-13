package com.example.kotlintestapp.models

import com.google.gson.annotations.SerializedName


data class StoreSetting(
  @SerializedName("stores")
  val stores: Store,
  @SerializedName("alarm_settings")
  val alarmSettings: AlarmSettings,
  @SerializedName("charges")
  val charges: Charges,
  @SerializedName("charge_payment_method")
  val chargePaymentMethod: ChargePaymentMethod,
  @SerializedName("waiting")
  val waiting: Waiting,
  @SerializedName("reservation")
  val reservation: Reservation
)

data class Store(
  @SerializedName("store_id")
  val storeId: String,
  @SerializedName("store_name")
  val storeName: String,
  @SerializedName("is_payment_advance")
  val isPaymentAdvance: Int
)

data class AlarmSettings(
  @SerializedName("alarm_setting_id")
  val alarmSettingId: String,
  @SerializedName("alarm_type")
  val alarmType: String,
  @SerializedName("is_payment_advance")
  val isPaymentAdvance: Int,
  @SerializedName("is_lack_money_alarm")
  val isLackMoneyAlarm: Int,
  @SerializedName("is_service_alarm")
  val isServiceAlarm: Int
)


data class Charges(
  @SerializedName("charge_id")
  val chargeId: String,
  @SerializedName("balance")
  val balance: Number,
  @SerializedName("is_payment_failed")
  val isPaymentFailed: Number
)

data class ChargePaymentMethod(
  @SerializedName("created_at")
  val createdAt: String
)

data class Waiting(
  @SerializedName("id")
  val id: String,
  @SerializedName("is_use_status")
  val isUseStatus: Number,
  @SerializedName("is_infant_included")
  val isInfantIncluded: Number,
  @SerializedName("max_people_count")
  val maxPeopleCount: Number,
  @SerializedName("max_team_count")
  val maxTeamCount: Number,
  @SerializedName("time_interval")
  val timeInterval: Number,
  @SerializedName("expired_time")
  val expiredTime: Number,
  @SerializedName("coming_soon_term")
  val comingSoonTerm: Number,
  @SerializedName("is_pre_order_menu")
  val isPreOrderMenu: Number
)


data class days(
  @SerializedName("is_possible")
  val isPossible: Number,
  @SerializedName("start")
  val start: String,
  @SerializedName("end")
  val end: String
)

data class WaitingDaySettings(
  @SerializedName("monday")
  val monday: days,
  @SerializedName("tuesday")
  val tuesday: days,
  @SerializedName("wednesday")
  val wednesday: days,
  @SerializedName("thursday")
  val thursday: days,
  @SerializedName("friday")
  val friday: days,
  @SerializedName("saturday")
  val saturday: days,
  @SerializedName("sunday")
  val sunday: days,
  @SerializedName("holiday")
  val holiday: days
)

data class Reservation(
  @SerializedName("id")
  val id: String,
  @SerializedName("is_use_status")
  val isUseStatus: Number,
  @SerializedName("is_infant_included")
  val isInfantIncluded: Number,
  @SerializedName("max_people_count")
  val maxPeopleCount: Number,
  @SerializedName("max_team_count")
  val maxTeamCount: Number,
  @SerializedName("time_interval")
  val timeInterval: Number,
  @SerializedName("expired_time")
  val expiredTime: Number,
  @SerializedName("is_pre_order_menu")
  val isPreOrderMenu: Number,
  @SerializedName("waiting_day_settings")
  val waitingDaySettings: WaitingDaySettings
)
