package mainObjects.comment.additionalObjects

data class Report(
    val ownerId: Int,
    val commentId: Int,
    val reason: Int,
) {
}

