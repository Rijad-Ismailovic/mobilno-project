package com.example.sportfieldreservationapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.Dialog
import com.example.sportfieldreservationapp.R
import com.example.sportfieldreservationapp.data.Datasource
import com.example.sportfieldreservationapp.ui.theme.RobotoFamily
import com.example.sportfieldreservationapp.enums.Cities
import com.example.sportfieldreservationapp.enums.Sports
import com.example.sportfieldreservationapp.model.Field
import com.example.sportfieldreservationapp.ui.theme.getDeviceWidth

//this is a change
@OptIn(ExperimentalMaterial3Api::class) // Zbog elevated card
@Composable
fun homepage() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var sportExpanded by remember { mutableStateOf(false) }
    var sportSelectedItem by remember { mutableStateOf("") }
    val sportIcon = if (sportExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    var cityExpanded by remember { mutableStateOf(false) }
    var citySelectedItem by remember { mutableStateOf("") }
    val cityIcon = if (sportExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(
        modifier = Modifier
            .fillMaxSize()       // Ukljuci cijeli screen, ne samo ono unutar columna
            .wrapContentWidth() // Takes up only width of content inside it, not any additional space
            //.verticalScroll()
            .padding(vertical = 25.dp),
        verticalArrangement = Arrangement.Top, // skloni ovo kasnije jer nece vazda biti u sredini
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        searchBar()

        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))

        Row {
            Column() {
                TextField(
                    value = sportSelectedItem,
                    onValueChange = {},
                    label = { Text(text = "Sport") },
                    enabled = false,
                    readOnly = true,
                    textStyle = TextStyle(color = Color.DarkGray),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent
                    ),
                    trailingIcon = {
                        Icon(
                            sportIcon,
                            contentDescription = null,
                            modifier = Modifier.clickable { sportExpanded = !sportExpanded })
                    },
                    modifier = Modifier
                        .width(164.dp)

                        .clickable { sportExpanded = !sportExpanded }
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                )

                DropdownMenu(
                    expanded = sportExpanded,
                    onDismissRequest = { sportExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity) { textFieldSize.width.dp })
                ) {
                    ->
                    Sports.values().map {
                        DropdownMenuItem(
                            text = {
                                Text(text = it.value, textAlign = TextAlign.Center)
                            },
                            onClick = {
                                sportSelectedItem = it.value;
                                sportExpanded = false
                            },
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(width = 16.dp, height = 0.dp))

            Column() {
                TextField(
                    value = citySelectedItem,
                    onValueChange = {},
                    label = { Text(text = "City") },
                    enabled = false,
                    readOnly = true,
                    textStyle = TextStyle(color = Color.DarkGray),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent
                    ),
                    trailingIcon = {
                        Icon(
                            cityIcon,
                            contentDescription = null,
                            modifier = Modifier.clickable { cityExpanded = !cityExpanded })
                    },
                    modifier = Modifier
                        .width(164.dp)

                        .clickable { cityExpanded = !cityExpanded }
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                )

                DropdownMenu(
                    expanded = cityExpanded,
                    onDismissRequest = { cityExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity) { textFieldSize.width.dp })
                ) {
                    ->
                    Cities.values().map {
                        DropdownMenuItem(
                            text = {
                                Text(text = it.value, textAlign = TextAlign.Center)
                            },
                            onClick = {
                                citySelectedItem = it.value;
                                cityExpanded = false
                            },
                        )
                    }
                }
            }

        }

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp),
        )

        //FieldCard(Field(R.string.iusballon_title, R.string.iusballon_sport, R.string.iusballon_city, R.string.iusballon_price, R.string.iusballon_time, R.drawable.iusballon))
        FieldList(fieldList = Datasource().loadCards())

    }
}

@Composable
fun searchBar(){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var searchText by remember{ mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    TextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = { Text(
            text = "Search",
            color = Color.Gray) },
        singleLine = true,
        shape = RoundedCornerShape(30.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            searchText = "Search clicked! Radi!"
        }),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        trailingIcon = {
            if (searchText.isNotEmpty()){
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier.clickable { searchText = "" }
                )
            }
        },
        modifier = Modifier.size(width = screenWidth - 2 * 24.dp, height = 50.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent //removes underline
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldCard(field: Field){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Card(
        modifier = Modifier
            .size(width = screenWidth - 2 * 24.dp, height = 100.dp),
        onClick = { /*TODO*/ },
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = field.imageResourceId),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.size(width = 16.dp, height = 0.dp))
            Column (){
                Text(
                    text = LocalContext.current.getString(field.titleStringResourceId),
                    fontSize = 16.sp,
                    fontFamily = RobotoFamily,
                    fontWeight = FontWeight.Normal,
                )
                Divider(
                    color = Color.Black,
                    thickness = 0.5.dp,
                    modifier = Modifier.padding(horizontal = 0.5.dp, vertical = 2.dp)
                )
                Row (){
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = LocalContext.current.getString(field.sportStringResourceId),
                            fontFamily = RobotoFamily
                        )
                        Text(
                            text = LocalContext.current.getString(field.cityStringResourceId),
                            fontFamily = RobotoFamily
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.End) {
                        Text(
                            text = LocalContext.current.getString(field.priceStringResourceId) + " KM / " + LocalContext.current.getString(field.timeStringResourceId) + " min",
                            fontFamily = RobotoFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
}

@Composable
fun FieldList(fieldList: List<Field>, modifier: Modifier.Companion = Modifier){
    LazyColumn(
        modifier = Modifier
    ) {
        items(fieldList) { field ->
            FieldCard(field = field)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomepagePreview() {
    homepage()
}





