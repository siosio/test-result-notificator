package siosio

import com.intellij.execution.testframework.*
import com.intellij.execution.testframework.TestStatusListener
import com.intellij.notification.*

class SushiStatusListener : TestStatusListener() {
    override fun testSuiteFinished(root: AbstractTestProxy?) {
        root?.let {
            val balloonGroup = NotificationGroup.balloonGroup("test sushi notification")
            val notification = if (it.isPassed) {
                balloonGroup.createNotification("Test Passed",
                        "\uD83C\uDF63".repeat(20),
                        NotificationType.INFORMATION, null)
            } else {
                balloonGroup.createNotification("Test Failed",
                        "\uD83D\uDC1B".repeat(20),
                        NotificationType.ERROR, null)
            }
            Notifications.Bus.notify(notification)
        }
    }
    
}
