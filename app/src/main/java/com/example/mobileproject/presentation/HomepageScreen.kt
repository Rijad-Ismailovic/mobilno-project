package com.example.mobileproject.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.mobileproject.R

@Composable
fun HomepageScreen(
    state: FieldState,
    navController: NavController,
    onEvent: (FieldsEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ){
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                IconButton(onClick = { onEvent(FieldsEvent.SortFields) }) {
                    Icon(
                        imageVector = Icons.Rounded.Sort,
                        contentDescription = "Sort fields",
                        modifier = Modifier.size(35.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.title.value = ""
                state.sport.value = ""
                state.city.value = ""
                state.price.value = ""
                state.time.value = ""
                navController.navigate("AddFieldScreen")
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add New Field")
            }
        }
    ) { paddingValues ->

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.fields.size) { index ->
                FieldCard(
                    state = state,
                    index = index,
                    onEvent = onEvent
                )
            }
        }
    }
}

@Composable
fun FieldCardOld(
    state: FieldState,
    index: Int,
    onEvent: (FieldsEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(12.dp)
    ){
        Image(
            painter = painterResource(id = getCardImage(state.fields[index].sport)),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                Text(
                    text = state.fields[index].title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        onEvent(FieldsEvent.DeleteField(state.fields[index]))
                    },
                    modifier = Modifier.size(21.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete Note",
                        modifier = Modifier.size(53.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            Divider(
                color = Color.Black,
                thickness = 0.5.dp,
            )
            Row (modifier = Modifier.padding(top = 15.dp)){
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = getCardSportIcon(state.fields[index].sport), contentDescription = "Sport icon", modifier = Modifier.size(15.dp))
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = state.fields[index].sport,
                        )
                    }
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_location_pin_24), contentDescription = "Location icon", modifier = Modifier.size(15.dp), tint = Color.Red)
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = state.fields[index].city,
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = state.fields[index].price + " KM / " + state.fields[index].time +" min",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun FieldCard(
    state: FieldState,
    index: Int,
    onEvent: (FieldsEvent) -> Unit
){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Card(
        modifier = Modifier
            .size(width = screenWidth - 24.dp, height = 100.dp),
        onClick = { /*TODO*/ },
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = getCardImage(state.fields[index].sport)),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                ) {
                    Text(
                        text = state.fields[index].title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {
                            onEvent(FieldsEvent.DeleteField(state.fields[index]))
                        },
                        modifier = Modifier.size(21.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = "Delete Note",
                            modifier = Modifier.size(53.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
                Divider(
                    color = Color.Black,
                    thickness = 0.5.dp,
                )
                Row {
                    Column {
                        Row (modifier = Modifier.padding(top = 11.dp)){
                            Column(
                                verticalArrangement = Arrangement.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = getCardSportIcon(state.fields[index].sport), contentDescription = "Sport icon", modifier = Modifier.size(15.dp))
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text(
                                        text = state.fields[index].sport,
                                    )
                                }
                                Row (verticalAlignment = Alignment.CenterVertically){
                                    Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_location_pin_24), contentDescription = "Location icon", modifier = Modifier.size(15.dp), tint = Color.Red)
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text(
                                        text = state.fields[index].city,
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = state.fields[index].price + " KM / " + state.fields[index].time +" min",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CardPreview(){
    //FieldCard()
}

fun getCardImage(sport: String): Int {
    val sport = sport.lowercase()
    return when (sport) {
        "football" -> R.drawable.football_img
        "basketball" -> R.drawable.basketball_img
        "volleyball" -> R.drawable.volleyball_img
        "tenis" -> R.drawable.tenis_img
        else -> R.drawable.noimg_img // TODO Attempt fix, ne radi else image
    }
}

@Composable
fun getCardSportIcon(sport: String): ImageVector {
    val sport = sport.lowercase()
    return when (sport) {
        "football" -> ImageVector.vectorResource(id = R.drawable.baseline_sports_soccer_24)
        "basketball" -> ImageVector.vectorResource(id = R.drawable.baseline_sports_basketball_24)
        "volleyball" -> ImageVector.vectorResource(id = R.drawable.baseline_sports_volleyball_24)
        "tenis" -> ImageVector.vectorResource(id = R.drawable.baseline_sports_tennis_24)
        else -> ImageVector.Builder(
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).build()
    }
}

