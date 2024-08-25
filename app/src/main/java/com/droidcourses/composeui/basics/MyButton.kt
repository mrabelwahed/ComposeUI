package com.droidcourses.composeui.basics

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun MyButton(modifier: Modifier = Modifier) {

    Button(
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.Cyan
        ),
        onClick = {}
    ) {
        Icon(imageVector = Icons.Default.Email, contentDescription = null)
        Spacer(modifier.width(20.dp))
        Text(text = "SignUp")
        Spacer(modifier.width(20.dp))
        Icon(imageVector = Icons.Default.Done , contentDescription = null)
    }
}

@Composable
fun Outline(modifier: Modifier = Modifier) {
    OutlinedButton(
        border = BorderStroke(width = 10.dp, color = Color.Magenta),
        onClick = {},
        ) {
        Text(text = "Login")
    }
}

@Composable
fun TextBtn(modifier: Modifier = Modifier) {
    TextButton(onClick = {}) {
        Text(text = "Premium User")
    }
}