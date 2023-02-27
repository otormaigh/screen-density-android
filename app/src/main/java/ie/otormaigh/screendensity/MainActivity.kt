package ie.otormaigh.screendensity

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ie.otormaigh.screendensity.ui.theme.ScreendensityandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreendensityandroidTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Label(Build.MANUFACTURER)
                        Label(Build.MODEL)
                        Label("Android ${Build.VERSION.RELEASE} (${Build.VERSION.SDK_INT})")
                        Label("")
                        Label(screenDensity())
                    }
                }
            }
        }
    }

    private fun screenDensity(): String {
        val density = resources.displayMetrics.densityDpi
        return when {
            density >= DisplayMetrics.DENSITY_XXXHIGH || density >= DisplayMetrics.DENSITY_560 -> "xxxhdpi"
            density >= DisplayMetrics.DENSITY_XXHIGH || density >= DisplayMetrics.DENSITY_360 -> "xxhdpi"
            density >= DisplayMetrics.DENSITY_XHIGH || density >= DisplayMetrics.DENSITY_260 -> "xhdpi"
            density >= DisplayMetrics.DENSITY_HIGH || density >= DisplayMetrics.DENSITY_180 -> "hdpi"
            density >= DisplayMetrics.DENSITY_MEDIUM || density >= DisplayMetrics.DENSITY_140 -> "mdpi"
            else -> "Unknown"
        }
    }
}

@Composable
fun Label(name: String) {
    Text(
        text = name,
        fontSize = 42.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .wrapContentHeight()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreendensityandroidTheme {
        Label("Android")
    }
}