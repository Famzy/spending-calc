package to.mpanaka

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import to.mpanaka.plugins.*
import java.io.FileInputStream
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions



fun main() {
    embeddedServer(Netty, port = 8085, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
//    install(ContentNegotiation) {
//        jackson { }
//    }
    // Initialize Firebase Admin SDK
    val serviceAccount = FileInputStream("")
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()


        FirebaseApp.initializeApp(options)


    configureRouting()
}
