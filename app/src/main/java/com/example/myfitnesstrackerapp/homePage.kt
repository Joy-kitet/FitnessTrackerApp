package com.example.myfitnesstrackerapp

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(userName: String) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imagelogo),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        ) { append("Hello, ") }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        ) { append(userName) }
                    },
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))

                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier
                                .size(10.dp)
                                .background(Color.Red, shape = CircleShape)
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notification Icon",
                        tint = Color.Black
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Preview
@Composable
fun PreviewCustomTopAppBar() {
    CustomTopAppBar(userName = "John")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomBar() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        containerColor = Color.Black
    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = { /* TODO: Handle click */ },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile Icon"
                    )
                },
                colors = BottomNavigationItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray
                )
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /* TODO: Handle click */ },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Fullscreen,
                        contentDescription = "Fullscreen Icon"
                    )
                },

                colors = BottomNavigationItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray
                )
            )

            BottomNavigationItem(
                selected = false,
                onClick = { /* TODO: Handle click */ },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "Favorite Icon"
                    )
                },
                colors = BottomNavigationItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray
                )
            )

            BottomNavigationItem(
                selected = false,
                onClick = { /* TODO: Handle click */ },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.RadioButtonChecked,
                        contentDescription = "Radio Button Icon"
                    )
                },
                colors = BottomNavigationItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray
                )
            )

        }
    }
}

@Composable
fun BottomNavigationItem(selected: Boolean, onClick: () -> Unit, icon: @Composable () -> Unit, colors: Any) {

}

@Preview
@Composable
fun PreviewCustomBottomBar() {
    CustomBottomBar()
}



@Composable
fun HomeScreen(workOutCategories: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {
        Spacer(modifier = Modifier.size(15.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(workOutCategories) { workout ->
                WorkOutType(workout = workout)
            }
        }
        Spacer(Modifier.size(20.dp))

        Box(Modifier.padding(horizontal =20.dp)
            .clip(RoundedCornerShape(percent 10))
            .background(colorResource(id = R.color.light_purple))
        ){
            Column(
                Modifier.padding(horizontal= 20.dp, vertical =22.dp)


            )
            {
                Row(
                    Modifier.fillmaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Centervertically
                ){
                    Text(text: "loose Belly fat",
                    color =Color.Black,
                    fontWeight =fontWeight.Bold
                        fontSize = 38.sp
                    )
                    Button(
                        shape = RoundCornerShape(20.dp),
                        contentPadding = PaddingValues(6.dp),
                        onClick = {},
                        colors = ButtonDefaults.textButtonColors(
                            backgroudColor = colorResource(id = R.color.purple_200)
                        )
                    )
                    {
                        Text(text: "Middle level", color= Color.White, fontSize= 18.sp)

                    }
                }
                Spacer(Modifier.size(15.dp))
                Box(
                    Modifier.clip(RoundedCornerShape(18.dp)

                    )
                        .background(Color.White)
                )

        }{
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Spacer(modifier=Modifier.weight(0.5))

                Image(
                    painter = painterResource(id = R.drawable.dumbells),contentDescription ="dumbell",
                    modifier = Modifier.size(200.dp)
                )
            }
            }
            Spacer(Modifier.size(12.dp))

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imagevector=Icons.Outlined.Schedule,
                    contentDescription = "timer",
                    tint =color.Black
                    )
                Text("40 minutes",
                    fontSize =14.dp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp))
            }
            Spacer(Modifier.weight(14))

            TextButton[colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Transparent
            ),
            (onclick ={/*TODO*/}){
                    Text("Start",
                fontSize = 20.sp,
                fontWeight.Bold,
                color = Color.Black
                    )
                Icon(
                    imagevector = Icons.filled.Arrowforward,
                    contentDescription = "timer",
                    tint= Color.Black
                )
    }
          Spacer(Modifier.size(20.dp))

          Box(
              Modifier.fillMaxWidth()
                  .padding(horizontal= 20.dp)
                  .clip(RoundedCornerShape(20.dp))
                  .background(ColorResource(if = R.color.orange))
          )
            {
              Row(
                  Modifier.fillMaxWidth()
                      .padding(20.dp)
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
              ){
                  Box(
                      contentAlignment =Alignment.Center,

                  ){
                      CircularProgressIndicator(
                          Modifier.size(75.dp),
                          color =Color.Black,
                          progress = 0.56f,
                          Strokewidth = 8.dp
                      )
                      Text(text = "56%",
                          color = Color.Black,
                          fontWeight = fontWeight.Bold,
                          fontSize = 25.sp)
                  }
              }
               Column{
                   Text(text: "Great!", color =Color.Black,fontWeight= fontWeight.Bold, fontSize = 20.sp)
                   Text(text: "You have lost 70% of your calories intake!", color =Color.Grey, fontSize = 16.sp)
               }
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        modifier = modifier
    )
}

@Composable
fun WorkOutType(workout: String) {
    var selected by remember { mutableStateOf(false) }
    val backgroundColor = if (selected) Color.Black else Color.White
    val textColor = if (selected) Color.White else Color.Black

    OutlinedButton(
        onClick = { selected = !selected },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .background(backgroundColor)
            .padding(6.dp)
    ) {
        Text(text = workout, color = textColor, fontSize=18.sp)
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    val sampleCategories = listOf("Yoga", "Cardio", "Strength", "Pilates")
    HomeScreen(workOutCategories = sampleCategories)
}