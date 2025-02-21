package com.example.businesscard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                    BusinessCardScreen()
            }
        }
    }
}

@Composable
fun NameTitleSection(
    modifier: Modifier = Modifier
) {
    // Ví dụ sử dụng painterResource để lấy ảnh từ drawable
    // Bạn cần thêm một ảnh/logo vào thư mục res/drawable, ví dụ: ic_android_logo.xml
    val imagePainter = painterResource(id = R.drawable.img)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ảnh hoặc biểu tượng
        Image(
            painter = imagePainter,
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
        )

        // Tên
        Text(
            text = "Lê Đặng Văn Thi",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Chức danh
        Text(
            text = "AI engineer",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ContactInfoSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
//            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Mỗi dòng thông tin liên hệ sẽ gồm Icon + Text
        ContactRow(
            icon = Icons.Filled.Phone,
            contactText = "+84 914448156",
            contentDescription = "Biểu tượng điện thoại"
        )
        ContactRow(
            icon = Icons.Filled.LocationOn,
            contactText = "Blue House, Sơn Trà, Đà Nẵng",
            contentDescription = "Biểu tượng địa chỉ"
        )
        ContactRow(
            icon = Icons.Filled.Email,
            contactText = "DangThi4705@gmail.com",
            contentDescription = "Biểu tượng email"
        )
    }
}

/**
 * Mỗi dòng liên hệ gồm biểu tượng (Icon) và nội dung liên hệ (Text).
 */
@Composable
fun ContactRow(
    icon: ImageVector,
    contactText: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
//            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(36.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = contactText,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardScreen() {
    // Có thể dùng Surface để bao bọc và đặt màu nền cho toàn màn hình
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0x828181)
    ) {
        // Dùng Column để xếp chồng các phần theo chiều dọc
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Phần hiển thị tên, chức danh, ảnh
            NameTitleSection()

            // Tạo khoảng trống giữa 2 phần
            Spacer(modifier = Modifier.height(50.dp))

            // Phần hiển thị thông tin liên hệ
            ContactInfoSection()
        }
    }
}
