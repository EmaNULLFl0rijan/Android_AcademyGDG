package hr.ferit.emanuelflorijan.myapplication.ui.Zadatak_1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hr.ferit.emanuelflorijan.myapplication.R

@Composable
fun ItemCard(data: MyData) {
    Card(Modifier.padding(8.dp)){
        TitleText(text = data.title)
        DescriptionText(text = data.description)

        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
    }
}