package com.example.project.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.R
import com.example.project.ui.theme.ProjectTheme


@Composable
fun RegistrationScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.sportfieldlogo),
            contentDescription = "",
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )
        Text(
            text = stringResource(id = R.string.sport_field),
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = "",
            onValueChange = { /* TODO */ },
            enabled = true,
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "example@exmaple.com")
            },
            isError = false
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = "",
            onValueChange = { /* TODO */},
            label = {
                Text(text = "username")
            },
            isError = false,
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = "",
            onValueChange = { /* TODO */},
            label = {
                Text(text = "password")
            },
            isError = false,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye_slash_regular),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "") }
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        TextField(
            value = "",
            onValueChange = { /* TODO */},
            label = {
                Text(text = "repeat password")
            },
            isError = false,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye_slash_regular),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "") }
        )

        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

//        TextButton(
//            onClick = { /*TODO*/ },
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text(text = "Already have an account?")
//        }
//
//        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Register",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 0.dp)
            )
        }

        TextButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Already have an account?")
        }

    }
}

@Preview( showBackground = true)
@Composable
fun RegistrationScreenPreview(){
    ProjectTheme {
        RegistrationScreen()
    }
}