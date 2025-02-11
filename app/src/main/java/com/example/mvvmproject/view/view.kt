package com.example.mvvmproject.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


import com.example.mvvmproject.model.Item
import com.example.mvvmproject.viewmodel.ItemViewModel
@Composable
fun ItemScreen(viewModel: ItemViewModel = viewModel()) {
    val itemName = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
        // Add Item TextField
        TextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.addItem(Item(id = viewModel.items.size + 1, name = itemName.value))
                    itemName.value = ""
                }
            )
        )

        // Add Button
        Button(
            onClick = {
                if (itemName.value.isNotEmpty()) {
                    viewModel.addItem(Item(id = viewModel.items.size + 1, name = itemName.value))
                    itemName.value = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add Item")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the list of items
        Column {
            for (item in viewModel.items) {
                Text(
                    text = item.name,
                    color = Color.Black,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}
