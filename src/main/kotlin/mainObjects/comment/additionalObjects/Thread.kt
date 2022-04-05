package mainObjects.comment.additionalObjects

import mainObjects.comment.Comment

data class Thread(
    val count: Int,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
) {
}

