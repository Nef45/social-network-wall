package mainObjects.post.additionalObjects

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Int,
    val canClose: Boolean,
    val canOpen: Boolean
) {
}