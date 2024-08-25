package com.droidcourses.composeui.ui.themechanger

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun RadioGroup(
    items: List<RadioButtonItem>,
    selected: Int,
    onItemSelected:((Int) ->Unit)?,
    modifier: Modifier = Modifier
) {
  Column (
      modifier = modifier.fillMaxSize().padding(16.dp).selectableGroup(),
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      items.forEach { item ->
          RadioGroupItem(
              item,
              item.id == selected,
              onclick = {onItemSelected?.invoke(item.id)},
          )
      }
  }
}


@Composable
fun RadioGroupItem(
    item: RadioButtonItem,
    selected: Boolean,
    onclick:((Int) -> Unit)?,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier.fillMaxWidth().selectable(
            selected= selected,
            role = Role.RadioButton,
            onClick = {onclick?.invoke(item.id)}
        ).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = null)
        Spacer(modifier.width(8.dp))
        Text(text = item.title, style = MaterialTheme.typography.bodyLarge)
    }
}

data class  RadioButtonItem(val id: Int, val title:String)

