// Matching on case classes: Case classes are especially useful for pattern matching.

// Define two case classes as below:
// abstract class Notification
// case class Email(sender: String, title: String, body: String) extends Notification
// case class SMS(caller: String, message: String) extends Notification

abstract class Notification

case class SMS(mobile:String, msg: String) extends Notification

case class Email(emailAddr: String, subject: String, body: String) extends Notification

// Define a function showNotification which takes as a parameter the abstract type Notification
// and matches on the type of Notification (i.e. it figures out whether it's an Email or SMS).
// In the case it's an Email(email, title, _) return the
// string: s"You got an email from $email with title: $title
// In the case it's an SMS return the String:
// s"You got an SMS from $number! Message: $message.

object temp{

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(emailAddr, subject, _) =>
        s"You got an email from $emailAddr with subject: $subject"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
    }
  }

  // Test by creating an SMS instance and a Email instance.

  def main(args:Array[String]): Unit = {
    val someSms = SMS("12345", "Are you there?")
    val someEmail = Email("jayanth@nmit.ac.in", "Big Data Course Syllabus",
      "Intro to Big Data, NOSQL Databases, Spark RDDs, SQL, Streaming")

    println(showNotification(someSms))

    println(showNotification(someEmail))
  }
}
