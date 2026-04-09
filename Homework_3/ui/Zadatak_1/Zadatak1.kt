package hr.ferit.emanuelflorijan.myapplication.ui.Zadatak_1

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(text: String){
    Text(text = text,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
}

@Composable
fun DescriptionText(text: String){
    Text(text = text,
        fontStyle = FontStyle.Italic,
        fontSize = 10.sp,
        maxLines = 3
    )
}

@Composable
fun CustomButton(
    text: String? = null,
    icon: ImageVector? = null,
    initialColor: Color = Color.Blue,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var backgroundColor by remember { mutableStateOf(initialColor) }

    Button(
        modifier = modifier,
        onClick = {
            backgroundColor = if (backgroundColor == Color.Blue) Color.Green else Color.Blue
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        icon?.let {
            Icon(imageVector = it, contentDescription = null)
        }
        text?.let {
            Text(text = it)
        }
    }
}