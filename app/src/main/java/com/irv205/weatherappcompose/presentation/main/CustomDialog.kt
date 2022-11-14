package com.irv205.weatherappcompose.presentation.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DisplayContent(modifier: Modifier, title: String, body: String, action: () -> Unit){

    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        Dialog(onDismissRequest = {
            openDialog.value = true
        }) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
                elevation = 8.dp
            ) {
                Column(
                    modifier
                        .background(Color.White)
                        .border(BorderStroke(0.5.dp, Color.Gray))) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = title,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.h6,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = body,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.body2
                        )
                    }
                    Column(
                        Modifier.border(BorderStroke(0.5.dp, Color.Gray))
                            .fillMaxWidth()
                            .clickable{
                                action.invoke()
                            }
                            .padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = "OK"
                        )
                    }
                }
            }
        }
    }

}