package hr.ferit.emanuelflorijan.myapplication.ui.Zadatak_1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Zadatak{

    @Composable
    fun Zadatak3i4(modifier: Modifier = Modifier) {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ){
                var itemList by remember {
                    mutableStateOf(listOf(
                        MyData(1, "Prvi", "Opis 1"),
                        MyData(2, "Drugi", "Opis 2"),
                        MyData(3, "Treći", "Opis 3")
                    ))
                }

                MyItemList(data = itemList, modifier = Modifier.weight(1f))

                Row{
                    CustomButton(text = "Favorite", onClick = { })
                    CustomButton(text = "Save", onClick = { })
                    CustomButton(
                        text = "Promiješaj listu",
                        modifier = Modifier.padding(16.dp),
                        onClick = { itemList = itemList.shuffled() }
                    )
                }

            }
    }
}

    @Composable
    fun MyItemList(modifier: Modifier = Modifier.fillMaxSize(), data: List<MyData>) {
        LazyColumn(modifier = modifier) {
            items(data.size) {
                ItemCard(data = data[it])
            }
        }
    }

}
