package to.mpanaka.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/send-notification") {
            val token = ""
            // Implement logic to send push notification using Firebase Admin SDK
            // Use the FirebaseMessaging.getInstance().send() method
            // call.respond(200, "Notification sent successfully")

            try {
                // Send push notification using Firebase Admin SDK
                val message = Message.builder()
                    .setToken(token)
                    .setNotification(
                        Notification.builder()
                            .setTitle("Vistacks Notifications")
                            .setBody("New Chackin")
                            .build() 
                    )
                    // .putData("data", "Eric") // Add custom data key-value pairs here
                    // .putData("value", "Lekwa")
                    .build()

                  val resonse =  FirebaseMessaging.getInstance().send(message)

                call.respond("$resonse")
            } catch (e: Exception) {
                call.respond("Failed to send notification: ${e.localizedMessage}")
            }
        }
    }
}
