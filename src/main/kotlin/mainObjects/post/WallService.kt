package mainObjects.post

object WallService {
    private var posts = emptyArray<Post>()
    private var wallPostId: Int = 0

    fun add(post: Post): Post {
        val (id) = post
        wallPostId = id
        val newPost = post.copy(id = wallPostId)
        posts += newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postInArray) in posts.withIndex()) {
            if (post.id == postInArray.id) {
                posts[index] = post.copy(
                    id = post.id,
                    ownerId = postInArray.ownerId,
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    date = postInArray.date,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    donut = post.donut,
                    postponedId = post.postponedId
                )
            } else return false
        }
        return true
    }

    fun showLast(){
        println(posts.last())
    }

}