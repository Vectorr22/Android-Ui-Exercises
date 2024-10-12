package com.vector.ui_day11.ui.components

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vector.ui_day11.R
import com.vector.ui_day11.ui.theme.Purple40
import com.vector.ui_day11.ui.theme.Purple80
import com.vector.ui_day11.ui.theme.PurpleGrey80
import com.vector.ui_day11.ui.theme.Ui_Day11Theme
import java.text.NumberFormat
import java.util.Locale

private val appColor = Color(0xFF8D1FA0)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "TOMORROWLAND",
            color = appColor,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar(currentValue = "", onValueChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.tomorrowland),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .padding(bottom = 8.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Victor's house",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.width(170.dp))
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFE0E0E0)),
                modifier = Modifier
                    .size(32.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.compartir),
                    contentDescription = null,
                    tint = appColor,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
        Text(
            text = "20 W 34th St., New York, NY 10001, Estados Unidos",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.Start)
        )
        RatingAndDataRow(stars = 5.0, totalRaiting = 47000)
        PlaceSchedule(isClosed = true, opens = "10:00", closes = "9:00")
        Spacer(modifier = Modifier.height(20.dp))
        MapButtons()
        Spacer(modifier = Modifier.height(20.dp))
        ImagesGrid(listOfImagesResources = listOf(
            R.drawable.imagen1,
            R.drawable.imagen2,
            R.drawable.imagen3,
            R.drawable.imagen4,
        ))


    }
}

@Composable
private fun SearchBar(
    modifier: Modifier = Modifier,
    currentValue: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = currentValue,
            onValueChange = onValueChange,

            shape = CircleShape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFDFDDDD),
                unfocusedContainerColor = Color(0xFFDFDDDD),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Clear,
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .height(40.dp)
                .weight(0.8f)
                .padding(end = 12.dp)
        )
        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = Color(0xFF474646)
            ),
            modifier = Modifier
                .size(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filtrar),
                contentDescription = null,
                tint = Color.Gray
            )

        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
private fun RatingAndDataRow(
    modifier: Modifier = Modifier,
    stars: Double,
    totalRaiting: Int
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val formattedStars = String.format("%.1f", stars)
        Text(
            text = formattedStars,
            color = Color.Gray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
        StarsRow()
        val formatter = NumberFormat.getNumberInstance(Locale.US)
        val formattedNumber = formatter.format(totalRaiting)
        Text(
            text = "($formattedNumber)",
            color = Color.Gray,
            fontSize = 12.sp
        )

    }
}

@Composable
fun StarsRow(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier
    ) {
        for (i in 0..4) {
            Image(
                painter = painterResource(id = R.drawable.fullstar),
                contentDescription = null,
                Modifier.size(15.dp)
            )
        }
    }
}

@Composable
fun MapButtons(
    modifier: Modifier = Modifier,
) {
    val listOfButtons = listOf(
        ButtonInfo(
            name = R.string.directions,
            iconRes = R.drawable.direccionflecha,
            isPrimary = true
        ),
        ButtonInfo(
            name = R.string.tickets,
            iconRes = R.drawable.boleto
        ),
        ButtonInfo(
            name = R.string.call,
            iconRes = R.drawable.ringphone
        ),
        ButtonInfo(
            name = R.string.website,
            iconRes = R.drawable.sitioweb
        ),
        ButtonInfo(
            name = R.string.like,
            iconRes = R.drawable.fullstar
        )

    )
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(listOfButtons) { buttonInfo ->
            IndividualMapButton(
                onButtonPressed = {},
                buttonInfo = buttonInfo
            )
        }

    }
}

@Composable
fun IndividualMapButton(
    modifier: Modifier = Modifier,
    onButtonPressed: () -> Unit,
    buttonInfo: ButtonInfo
) {
    Button(
        onClick = onButtonPressed,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (buttonInfo.isPrimary) appColor else Color(0xFFF1F1F1),
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
        modifier = Modifier.wrapContentWidth()
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = buttonInfo.iconRes),
                contentDescription = null,
                tint = if (buttonInfo.isPrimary) Color.White else appColor,
                modifier = Modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.width(0.dp))
            Text(
                text = stringResource(id = buttonInfo.name),
                color = if (buttonInfo.isPrimary) Color.White else appColor
            )
        }
    }
}

@Composable
fun PlaceSchedule(
    modifier: Modifier = Modifier,
    isClosed: Boolean,
    opens: String,
    closes: String

) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isClosed) {
            Text(text = "Closed", color = Color.Red, fontSize = 12.sp)
            Text(text = "Opens $opens a.m. Mon", fontSize = 12.sp)
        } else {
            Text(text = "Open", color = Color.Green, fontSize = 12.sp)
            Text(text = "Closes $closes p.m.", fontSize = 12.sp)
        }

    }

}

@Composable
fun ImagesGrid(
    modifier: Modifier = Modifier,
    listOfImagesResources: List<Int>
) {
    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalItemSpacing = 4.dp,
        modifier = modifier
            .height(400.dp)
            .padding(8.dp)
    ) {
        items(listOfImagesResources) { photoId ->
            Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))){
                Image(
                    painter = painterResource(id = photoId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier


                )
            }
        }
    }
}



@Preview
@Composable
private fun Prev2() {
    Ui_Day11Theme {
        MainScreen()
    }
}


data class ButtonInfo(
    @StringRes val name: Int,
    @DrawableRes val iconRes: Int,
    val isPrimary: Boolean = false
)