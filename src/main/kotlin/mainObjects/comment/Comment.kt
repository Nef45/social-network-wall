package mainObjects.comment

import mainObjects.comment.additionalObjects.Donut
import mainObjects.comment.additionalObjects.Thread
import mainObjects.post.additionalObjects.attachments.Attachment

data class Comment(
    val id: Int,
    val postId:Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut,
    val replyToUser: Int?,
    val replyToComment: Int?,
    val attachment: Array<Attachment>?,
    val thread: Thread
) {
}