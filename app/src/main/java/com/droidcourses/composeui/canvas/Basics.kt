import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.truncate

@Composable
fun BasicRect(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val w = 500f
        val h = 200f
        drawRect(
            color = Color.White,
            size = Size(w,h),
            topLeft = Offset(center.x- w/2, center.y-h/2)
        )
    }
}

@Composable
fun BasicStrokeRect(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val w = 500f
        val h = 200f
        drawRect(
            color = Color.White,
            size = Size(w,h),
            topLeft = Offset(center.x- w/2, center.y-h/2),
            style = Stroke(width = 10f)
        )
    }
}


@Composable
fun BasicCircle(modifier: Modifier = Modifier) {
    Canvas(
        modifier
            .fillMaxSize()
            .background(Color.Black)) {
        drawCircle(
           color = Color.Red,
            radius = 100f,
            center = Offset(200f,200f),
            style = Stroke(width = 10f)
        )
    }
}


@Composable
fun BasicRadialCircle(modifier: Modifier = Modifier) {
    Canvas(
        modifier
            .fillMaxSize()
            .background(Color.Black)) {
        drawCircle(
//            color = Color.Red,
            radius = 200f,
            brush = Brush.radialGradient(
                colors = listOf(Color.Green,Color.Yellow,Color.Red),
                radius = 200f
            )
        )
        drawCircle(
            color = Color.Red,
            radius = 10f,
        )
    }
}

@Composable
fun DrawPieChart(modifier: Modifier = Modifier) {
    val colors = listOf(Color.Red, Color.Yellow, Color.Green)
    val points = listOf(25f, 35f, 40f)
    val padding = 100f
    var startAngle = 270f
    val total = points.sum()
    val proportions = points.map {
         it * 100 / total
    }
    val sweepAnglePercentage = proportions.map {
        it * 360 / 100
    }
    Canvas(modifier = modifier
        .fillMaxSize()
        .background(Color.White)) {
        sweepAnglePercentage.forEachIndexed { i, angle ->
            drawArc(
                color = colors[i],
                useCenter = false,
                startAngle = startAngle,
                sweepAngle = angle,
                size = Size(width = size.width/2, size.width/2),
                topLeft = Offset(padding/2, padding/2),
                style = Stroke(width = 20f)
            )
            startAngle += angle
        }
    }
}

@Composable
fun DrawLine1(modifier: Modifier = Modifier) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        drawLine(
            color = Color.Blue,
            start = Offset(0.dp.toPx(), h/2),
            end = Offset(w,h/2),
            strokeWidth = 20.dp.toPx()
        )
    }
}


@Composable
fun DrawLine2(modifier: Modifier = Modifier) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        drawLine(
            color = Color.Blue,
            start = Offset(0f,0f),
            end = Offset(w,h),
            strokeWidth = 20.dp.toPx()
        )
    }
}

@Composable
fun DrawMultipleLines(modifier: Modifier = Modifier) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        drawLine(
            color = Color.Blue,
            start = Offset(w/2,0f),
            end = Offset(w/2,h),
            strokeWidth = 5f
        )
        drawLine(
            color = Color.Blue,
            start = Offset(0f,h/2f),
            end = Offset(w,h/2),
            strokeWidth = 5f
        )

    }
}

@Composable
fun CarCanvas(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = modifier.fillMaxWidth()
                .padding(20.dp)
                .height(400.dp)
                .background(Color.White)
        ) {
            val width = size.width
            val height = size.height
            val mainColor = Color.Red
            drawLine(
                color = Color.Red,
                start = Offset(x = 0f, y = height / 4),
                end = Offset(x = width / 5, y = height / 4),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Blue,
                start = Offset(x = width / 3, y = 0f),
                end = Offset(x = width / 5, y = height / 4),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Green,
                start = Offset(x = width / 3, y = 0f),
                end = Offset(x = width - 300, y = 0f),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Magenta,
                start = Offset(x = width - 300, y = 0f),
                end = Offset(x = width - 200, y = height / 4),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Green,
                start = Offset(x = width - 200, y = height / 4),
                end = Offset(x = width, y = height / 4),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Blue,
                start = Offset(x = width, y = height / 4),
                end = Offset(x = width, y = height / 2),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Black,
                start = Offset(x = width, y = height / 2),
                end = Offset(x = width - 200, y = height / 2),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Red,
                start = Offset(x = 0f, y = height / 4),
                end = Offset(x = 0f, y = height / 2),
                strokeWidth = 5f
            )
            drawArc(
                color = Color.Red,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(x = width / 5, y = height / 2.45f),
                style = Stroke(width = 5f),
                size = Size(200f, 200f)
            )
            drawLine(
                color = Color.Red,
                start = Offset(x = (width / 5) + 200, y = height / 2),
                end = Offset(x = (width / 5) + 380, y = height / 2),
                strokeWidth = 5f
            )
            drawLine(
                color = Color.Red,
                start = Offset(x = 0f, y = height / 2),
                end = Offset(x = width / 5, y = height / 2),
                strokeWidth = 5f
            )
            drawArc(
                color = Color.Red,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(x = width - 400, y = height / 2.45f),
                style = Stroke(width = 5f),
                size = Size(200f, 200f)
            )

            // tires
            drawCircle(
                color = Color.Red,
                radius = 75f,
                center = Offset(x = (width / 5) + 100, y = height / 2)
            )
            drawCircle(
                color = Color.Red,
                radius = 75f,
                center = Offset(x = (width / 5) + 480, y = height / 2)
            )
            // road
            drawLine(
                color = Color.Red,
                start = Offset(x = 0f, y = height / 1.7f),
                end = Offset(x = width, y = height / 1.7f),
                strokeWidth = 5f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 20f), 25f)
            )
        }

        }

}

