package com.example.androiddevchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val cat = intent.getParcelableExtra<Cat>("cat")
        Toast.makeText(applicationContext,cat.toString(),Toast.LENGTH_SHORT).show()
        setContent {
            MyTheme() {
                LazyColumn(
                ) {
                    item {
                        Toolbar(title = "Details: ${cat?.name}")
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = cat!!.imgSrc),
                                contentDescription = "", contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = MaterialTheme.colors.primary
                                    )
                                    .padding(8.dp)
                                    .width(300.dp)
                                    .height(300.dp), alignment = Alignment.Center
                            )
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(modifier = Modifier.padding(8.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "name: ", style = MaterialTheme.typography.body2)
                                Text(text = cat!!.name, style = MaterialTheme.typography.h6)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "gender: ", style = MaterialTheme.typography.body2)
                                Text(text = cat!!.sex, style = MaterialTheme.typography.h6)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "breed: ", style = MaterialTheme.typography.body2)
                                Text(text = cat!!.breed, style = MaterialTheme.typography.h6)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "owner: ", style = MaterialTheme.typography.body2)
                                Text(text = cat!!.owner, style = MaterialTheme.typography.h6)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "date of birth: ",
                                    style = MaterialTheme.typography.body2
                                )
                                Text(
                                    text = cat!!.dateOfBirth,
                                    style = MaterialTheme.typography.h6
                                )
                            }
                            Column(verticalArrangement = Arrangement.Center) {
                                Spacer(modifier = Modifier.padding(5.dp))
                                Text(
                                    text = "Description: ",
                                    style = MaterialTheme.typography.caption
                                )
                                Text(
                                    text = cat!!.description.toString(),
                                    style = MaterialTheme.typography.h6
                                )
                            }
                            Spacer(modifier = Modifier.padding(15.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(onClick = { }, contentPadding = PaddingValues(5.dp)) {
                                    Text(text = "Apply")
                                }
                            }
                        }

                    }
                }

            }
        }

    }
}