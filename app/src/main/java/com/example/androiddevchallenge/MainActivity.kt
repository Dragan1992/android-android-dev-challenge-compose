/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val list = generateDummyData()
                Column() {
                    Toolbar("Cat adopt list")
                    for (item in list) {
                        CatItem(cat = item) {
                            val intent = Intent(applicationContext,DetailsActivity::class.java)
                            intent.putExtra("cat",item)
                            startActivity(intent)
                        }


                    }
                }
            }
        }

    }
    fun createToast(s:String){
        Toast.makeText(applicationContext,s,Toast.LENGTH_SHORT).show()
    }
}
fun generateDummyData():List<Cat>{
    val cats = mutableListOf<Cat>()
    val ragdoll = Cat("Lilly","John Hill",R.drawable.schottish_fold,
       666 ,"Scottish Fold",null,"03/03/2018","female")
    val exoticShorthair = Cat("Leonard","Maria Venia",R.drawable.maine_coon,
        111,"Unknown",null,"05/11/2011","male")
    val britishShorthair = Cat("Garfield","Victor Loriente",R.drawable.abyssinian,
        222,"Exotic Shorthair",null,"02/30/2016","male")
    val persian = Cat("Mia","Ana Stephen",R.drawable.exotic,
        333,"Unknown","Mia is awesome cat, she is very social, love to play, you will never get bored with Mia","12/16/2018","female")
    val maineCoon = Cat("Lara","Igor Rogger",R.drawable.chartruese,
        444,"Chartreux Cat",null,"06/17/2009","female")
    val americanShorhair = Cat("Arabay","Mariana Peric",R.drawable.american_shorthair,
       555,"Unknown",null,"01/02/2018","male")

    cats.add(ragdoll)
    cats.add(exoticShorthair)
    cats.add(britishShorthair)
    cats.add(persian)
    cats.add(maineCoon)
    cats.add(americanShorhair)
    return cats
}
// Start building your app here!
//@Preview("catItem", widthDp = 500, heightDp = 200)

@Composable
fun CatItem(cat:Cat,onClick: (String) -> Unit){

    MaterialTheme{
        val typography=MaterialTheme.typography
    Row(
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
            .padding(3.dp)
            .clickable(onClick = { onClick(cat.name) })
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = cat.imgSrc),
            contentDescription = cat.name,
            modifier = Modifier
                .padding(5.dp)
                .height(50.dp)
                .border(width = 1.dp,color = MaterialTheme.colors.primary,shape = CircleShape)
                .width(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )
        Column(Modifier.fillMaxWidth(0.7f)) {
            Text(text = "Name: ${cat.name}", style = typography.h5)
            Text(text = "Owner: ${cat.owner}",style = typography.body1)
            Text("Breed: ${cat.breed}", style = typography.body1)
            Text(text = "Gender: ${cat.sex}", style = typography.body1)
        }
    }
    }


}
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column {

        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
