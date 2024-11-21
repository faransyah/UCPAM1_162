package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        TampilanHeader()
        MasukkanInput()

    }
}

@Composable
fun TampilanHeader(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxWidth()
        .background(Color.Blue)
        .padding(20.dp)){
        Row {
            Box(contentAlignment = Alignment.TopEnd){
                Image(painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp))

                Icon(Icons.Default.Person, contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .background(color = Color.Blue, shape = CircleShape),
                    tint = Color.White)

                Icon(Icons.Default.Place, contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp)
                        .size(10.dp)
                        .background(color = Color.Blue, shape = CircleShape),
                    tint = Color.White)
            }
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Muhammad Faransyah Hamizan",
                    color = Color.White,
                    fontSize = 5.sp)
                Spacer(modifier = Modifier.padding(20.dp))
                Text("Kabupaten Bantul",
                    color = Color.White,
                    fontSize = 5.sp)
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun MasukkanInput(modifier: Modifier = Modifier){

    var kota by remember { mutableStateOf("") }
    var berangkat by remember { mutableStateOf("") }
    var sampai by remember { mutableStateOf("") }

    var dataKota by remember { mutableStateOf("") }
    var dataBerangkat by remember { mutableStateOf("") }
    var dataSampai by remember { mutableStateOf("") }

    var jenisT by remember { mutableStateOf("")}
    var dataJenisT by remember { mutableStateOf("")}
    val dataJT = listOf("Bus", "Ship", "Train", "Plane")


    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.Start) {
        Text(text = "Plan Your Adventures", fontWeight = FontWeight.Bold,
            fontSize = 5.sp, color = Color.Black)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Let's Plan an exquisite adventure",
            fontSize = 5.sp, color = Color.Black)
        OutlinedTextField(
            value = kota,
            onValueChange = {kota = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Origin")},
            placeholder = {
                Text("Kota Tujuan")}
        )

        Row {
            OutlinedTextField(
                value = berangkat,
                onValueChange = {berangkat = it},
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = {
                    Text("Departure")
                },
                placeholder = {
                    Text("Tanggal Berangkat")}
            )
            OutlinedTextField(
                value = sampai,
                onValueChange = {sampai = it},
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                label = {
                    Text("Arrival")
                },
                placeholder = {
                    Text("Tanggal Sampai")}
            )

        }
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color.Blue)
            .padding(20.dp)) {
            Text("Choose Transportation", color = Color.White, )
        Row {
            dataJT.forEach{selectedJT ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jenisT == selectedJT,
                        onClick ={
                            jenisT = selectedJT
                        } )
                    Text(selectedJT)
                }
            }

        }
        }

        Button(onClick = {
            dataKota = kota
            dataBerangkat = berangkat
            dataSampai = sampai
            dataJenisT = jenisT

        },
            modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Submit")
        }

        Card(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
            Column {
                TampilData(
                    judul = "Origin",
                    isinya = dataKota,
                    )
                TampilData(
                    judul = "Departure",
                    isinya = dataBerangkat
                )

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Column {
                TampilData(
                    judul = "Arrival",
                    isinya = dataSampai
                )
                TampilData(
                    judul = "Transport",
                    isinya = dataJenisT
                )
            }


        }


    }
}

@Composable
fun TampilData(
    judul: String,
    isinya: String
) {
    Row(modifier = Modifier.fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}
