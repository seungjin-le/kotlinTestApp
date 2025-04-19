package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.components.buttons.DefaultBtn
import com.example.kotlintestapp.ui.components.inputs.CheckBox
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h2
import com.example.kotlintestapp.ui.theme.TextSizes.h3
import com.example.kotlintestapp.ui.theme.TextSizes.h4
import com.example.kotlintestapp.ui.theme.TextSizes.m1
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.TextSizes.xs2

data class NumPadEmus(val label: String, val value: String)


@Composable
fun waitingPhone() {

  val numPad = listOf<NumPadEmus>(
    NumPadEmus(
      label = "1", value = "1"
    ),
    NumPadEmus(
      label = "2", value = "2"
    ),
    NumPadEmus(
      label = "3", value = "3"
    ),
    NumPadEmus(
      label = "4", value = "4"
    ),
    NumPadEmus(
      label = "5", value = "5"
    ),
    NumPadEmus(
      label = "6", value = "6"
    ),
    NumPadEmus(
      label = "7", value = "7"
    ),
    NumPadEmus(
      label = "8", value = "8"
    ),
    NumPadEmus(
      label = "9", value = "9"
    ),
    NumPadEmus(
      label = "010", value = "010"
    ),
    NumPadEmus(
      label = "0", value = "0"
    ),
    NumPadEmus(
      label = "-1", value = "-1"
    ),
  )
  var phoneNum by rememberSaveable { mutableStateOf("") }
  var termsChecked by rememberSaveable { mutableStateOf(false) }


  fun handleOnClick(emu: NumPadEmus) {
    if (emu.value == "-1") {
      phoneNum = phoneNum.dropLast(1)

    } else {
      phoneNum += emu.value
    }
  }

  fun formatPhoneNum(): String {
    val len = phoneNum.length
    if (len > 11) phoneNum = phoneNum.substring(0, 11)
    return when {
      len < 4 -> phoneNum
      len < 8 -> "${phoneNum.substring(0, 3)}-${phoneNum.substring(3, len)}"
      len <= 11 -> "${phoneNum.substring(0, 3)}-${phoneNum.substring(3, 7)}-${phoneNum.substring(7, len)}"
      len > 11 -> "${phoneNum.substring(0, 3)}-${phoneNum.substring(3, 7)}-${phoneNum.substring(7, 11)}"
      else -> phoneNum // 또는 11자리 이상인 경우 특별 처리
    }
  }

  Column(
    modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 36.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Bottom,
  ) {

    Box(
      modifier = Modifier.fillMaxSize().weight(1f),
      contentAlignment = Alignment.Center,
    ) {
      if (phoneNum.isEmpty()) Text("휴대폰 번호를 입력해 주세요.", style = h3, color = N60)
      else Text(formatPhoneNum(), style = h2, color = N80)
    }
    LazyVerticalGrid(
      columns = GridCells.Fixed(3),
      horizontalArrangement = Arrangement.spacedBy(10.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

      items(numPad.size) { index ->
        Box(
          modifier = Modifier.weight(1f).height(60.dp).clip(shape = RoundedCornerShape(8.dp))
            .border(1.dp, color = N20, shape = RoundedCornerShape(8.dp))
            .clickable(enabled = (phoneNum.length < 11 || numPad[index].value == "-1")) { handleOnClick(numPad[index]) },
          contentAlignment = Alignment.Center
        ) {
          if (numPad[index].value == "-1") Image(
            painter = painterResource(id = R.drawable.text_remove),
            modifier = Modifier.size(26.dp),
            contentDescription = "remove",

            )
          else Text(text = numPad[index].label, style = h4, color = N80)
        }
      }

    }
    Spacer(modifier = Modifier.height(53.dp))
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      CheckBox(termsChecked, { termsChecked = !termsChecked }, 32)
      Spacer(modifier = Modifier.width(6.dp))
      Text("개인정보 수집 및 이용동의 (필수)", style = s2, color = N80)
      Spacer(modifier = Modifier.width(6.dp))
      Text(
        "자세히 보기",
        style = xs2,
        color = N60,
        modifier = Modifier.clickable { },
        textDecoration = TextDecoration.Underline
      )
    }
    Spacer(modifier = Modifier.height(16.dp))


    DefaultBtn("확인", {}, phoneNum.length == 11 && termsChecked)
    Dialog(onDismissRequest = {}) {
      Column(
        modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)).width(428.dp)
          .background(White)
          .padding(vertical = 30.dp, horizontal = 24.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("개인정보 수집 및 이용동의 약관", style = m1, color = N90)
          Text("X")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
          "모든 국민은 양심의 자유를 가진다. 대한민국의 국민이 되는 요건은 법률로 정한다. 국회는 국민의 보통·평등·직접·비밀선거에 의하여 선출된 국회의원으로 구성한다.\n" +
            "\n" +
            "정당은 법률이 정하는 바에 의하여 국가의 보호를 받으며, 국가는 법률이 정하는 바에 의하여 정당운영에 필요한 자금을 보조할 수 있다. 국무회의는 정부의 권한에 속하는 중요한 정책을 심의한다.\n" +
            "\n" +
            "헌법재판소의 장은 국회의 동의를 얻어 재판관중에서 대통령이 임명한다. 대통령은 국회에 출석하여 발언하거나 서한으로 의견을 표시할 수 있다. 국회의원은 현행범인인 경우를 제외하고는 회기중 국회의 동의없이 체포 또는 구금되지 아니한다.\n" +
            "\n" +
            "모든 국민은 근로의 권리를 가진다. 국가는 사회적·경제적 방법으로 근로자의 고용의 증진과 적정임금의 보장에 노력하여야 하며, 법률이 정하는 바에 의하여 최저임금제를 시행하여야 한다.\n" +
            "\n" +
            "대통령은 제3항과 제4항의 사유를 지체없이 공포하여야 한다. 대통령의 임기연장 또는 중임변경을 위한 헌법개정은 그 헌법개정 제안 당시의 대통령에 대하여는 효력이 없다.\n" +
            "\n" +
            "대통령은 법률안의 일부에 대하여 또는 법률안을 수정하여 재의를 요구할 수 없다. 제안된 헌법개정안은 대통령이 20일 이상의 기간 이를 공고하여야 한다.\n" +
            "\n" +
            "국회의원은 법률이 정하는 직을 겸할 수 없다. 모든 국민은 거주·이전의 자유를 가진다. 국회가 재적의원 과반수의 찬성으로 계엄의 해제를 요구한 때에는 대통령은 이를 해제하여야 한다.",
          style = s2,
          color = N70
        )
      }
    }

  }

}