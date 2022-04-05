package mainObjects.wallService

import exceptions.CommentNotFoundException
import exceptions.PostAlreadyExistsException
import exceptions.PostNotFoundException
import exceptions.UnknownReportReasonException
import mainObjects.comment.Comment
import mainObjects.comment.additionalObjects.Report
import mainObjects.post.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    fun add(post: Post): Post {
        val newPost: Post
        if (posts.isEmpty()) {
            newPost = post.copy(id = 1)
            posts += newPost
            return posts.last()
        }
        for (postInArray in posts) {
            if (post.id == postInArray.id) {
                throw PostAlreadyExistsException()
            } else {
                newPost = post.copy(id = posts.last().id + 1)
                posts += newPost
                break
            }
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postInArray) in posts.withIndex()) {
            if (post.id == postInArray.id) {
                posts[index] = post.copy(
                    ownerId = postInArray.ownerId,
                    date = postInArray.date
                )
                return true
            }
        }
        throw PostNotFoundException()
    }

    fun createComment(comment: Comment) {
        val newComment: Comment
        if (posts.isNotEmpty()) {
            for (post in posts) {
                if (comment.postId == post.id) {
                    if (comments.isNotEmpty()) {
                        newComment = comment.copy(id = comments.last().id + 1)
                        comments += newComment
                        return
                    } else {
                        newComment = comment.copy(id = 1)
                        comments += newComment
                        return
                    }
                }
            }
        }
        throw PostNotFoundException()
    }

    fun reportComment(report: Report) {
        if (comments.isNotEmpty()) {
            for (comment in comments) {
                if (report.commentId == comment.id) {
                    if (report.reason !in 0..8) {
                        throw UnknownReportReasonException()
                    }
                    reports += report
                    return
                }
            }
        }
        throw CommentNotFoundException()
    }


    fun getPosts(): Array<Post> {
        return posts
    }

    fun getComments(): Array<Comment> {
        return comments
    }

    fun getReports(): Array<Report> {
        return reports
    }

    fun reset() {
        posts = emptyArray()
        comments = emptyArray()
        reports = emptyArray()
    }
}