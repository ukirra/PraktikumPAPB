package com.tifd.tugaspraktikumpapb3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.tifd.tugaspraktikumpapb3.ui.theme.Pink40
import com.tifd.tugaspraktikumpapb3.ui.theme.Pink80
import com.tifd.tugaspraktikumpapb3.ui.theme.PinkGrey40
import com.tifd.tugaspraktikumpapb3.ui.theme.SoftPink40
import com.tifd.tugaspraktikumpapb3.ui.theme.TugasPraktikumPAPB3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasPraktikumPAPB3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    var text by remember { mutableStateOf("") }
    var inputText by remember { mutableStateOf("") }
    var nimInput by remember { mutableStateOf("") }
    var nimText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nama: $text",
            style = MaterialTheme.typography.titleLarge.copy(color = Pink80)
        )
        Text(
            text = "NIM: $nimText",
            style = MaterialTheme.typography.titleLarge.copy(color = Pink80)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Icon Profile",
                tint = Pink80,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Masukkan nama") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = SoftPink40,
                    unfocusedBorderColor = SoftPink40,
                    focusedLabelColor = SoftPink40,
                    unfocusedLabelColor = Pink80
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NimIcon()

            Spacer(modifier = Modifier.width(12.dp))

            OutlinedTextField(
                value = nimInput,
                onValueChange = { nimInput = it },
                label = { Text("Masukkan NIM") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = SoftPink40,
                    unfocusedBorderColor = SoftPink40,
                    focusedLabelColor = SoftPink40,
                    unfocusedLabelColor = Pink80
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                text = inputText
                nimText = nimInput
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = SoftPink40
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                "Submit",
                color = Pink80
            )
        }
    }
}

@Composable
fun NimIcon() {
    val iconTint = Pink80
    Image(
        painter = painterResource(id = R.drawable.nim_vector),
        contentDescription = "NIM Icon",
        modifier = Modifier
            .size(30.dp),
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.tint(iconTint)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TugasPraktikumPAPB3Theme {
        MyScreen()
    }
}
