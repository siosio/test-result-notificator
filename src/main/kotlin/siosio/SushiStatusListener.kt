package siosio

import com.intellij.execution.testframework.*
import com.intellij.notification.*
import com.intellij.openapi.project.*

class SushiStatusListener : TestStatusListener() {
    
    companion object {
        val balloonGroup = NotificationGroup("test sushi notification", NotificationDisplayType.BALLOON, false)
    }

    override fun testSuiteFinished(root: AbstractTestProxy?, project: Project) {
        root?.let {
            val notification = if (it.isPassed) {
                balloonGroup.createNotification("Test Passed",
                        "\uD83C\uDF63".repeat(20),
                        NotificationType.INFORMATION, null)
            } else {
                balloonGroup.createNotification("Test Failed",
                        "\uD83D\uDC1B".repeat(20),
                        NotificationType.ERROR, null)
            }
            Notifications.Bus.notify(notification, project)
        }
    }

    override fun testSuiteFinished(root: AbstractTestProxy?) {
    }
    
}
