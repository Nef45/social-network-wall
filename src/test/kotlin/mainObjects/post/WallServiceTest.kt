package mainObjects.post

import exceptions.CommentNotFoundException
import exceptions.PostAlreadyExistsException
import exceptions.PostNotFoundException
import exceptions.UnknownReportReasonException
import mainObjects.comment.Comment
import mainObjects.comment.additionalObjects.Report
import mainObjects.comment.additionalObjects.Thread
import mainObjects.post.additionalObjects.*
import mainObjects.wallService.WallService
import org.junit.After
import org.junit.Test
import org.junit.Assert.*


class WallServiceTest {

    @After
    fun resetWallService() {
        WallService.reset()
    }

    @Test
    fun wallService_add_returnedIdIsNotNull() {

        val post1 = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val expectedResult = 1

        WallService.add(post1)
        val actualResult = WallService.getPosts().last().id

        assertEquals(expectedResult, actualResult)
    }

    @Test(expected = PostAlreadyExistsException::class)
        fun wallService_add_throws_PostAlreadyExistsException() {
        val post1 = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )

        WallService.add(post1)
        WallService.add(post1.copy(id = 1))
        }


    @Test
    fun wallService_update_returnTrue_when_PostExists() {
        val post1 = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val post2 = Post(
            id = 1,
            ownerId = 1000003,
            fromId = 1000004,
            createdBy = 1000003,
            date = 11102020,
            text = "Текст2",
            replyOwnerId = 1000004,
            replyPostId = 2000004,
            friendsOnly = true,
            comments = Comments(3, true, true, false, false),
            copyright = Copyright(3000002, "thatslink.com", "the source", "post"),
            likes = Likes(35, true, true, true),
            reposts = Reposts(1, false),
            views = Views(125),
            postType = "post",
            attachments = null,
            signerId = 3000004,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            donut = Donut(false, 30, "placeholder", false, "duration"),
            postponedId = 9000004
        )
        WallService.add(post1)

        val actualResult = WallService.update(post2)

        assertTrue(actualResult)
    }

    @Test(expected = PostNotFoundException::class)
    fun wallService_update_throws_PostNotFoundException() {
        val post1 = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val post2 = Post(
            id = 2000002,
            ownerId = 1000003,
            fromId = 1000004,
            createdBy = 1000003,
            date = 11102020,
            text = "Текст2",
            replyOwnerId = 1000004,
            replyPostId = 2000004,
            friendsOnly = true,
            comments = Comments(3, true, true, false, false),
            copyright = Copyright(3000002, "thatslink.com", "the source", "post"),
            likes = Likes(35, true, true, true),
            reposts = Reposts(1, false),
            views = Views(125),
            postType = "post",
            attachments = null,
            signerId = 3000004,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            donut = Donut(false, 30, "placeholder", false, "duration"),
            postponedId = 9000004
        )

        WallService.add(post1)
        WallService.update(post2)
    }

    @Test
    fun wallService_createComment_Succeeded(){
        val post = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val comment = Comment(
        id = 2000001,
        postId = 1,
        fromId = 1000005,
        date = 10102029,
        text = "",
        donut = mainObjects.comment.additionalObjects.Donut(false, "---"),
        replyToUser = 1000015,
        replyToComment = 2000010,
        attachment = null,
        thread = Thread(11, true, true, true)
        )
        val expectedResult = Comment(
            id = 1,
            postId = 1,
            fromId = 1000005,
            date = 10102029,
            text = "",
            donut = mainObjects.comment.additionalObjects.Donut(false, "---"),
            replyToUser = 1000015,
            replyToComment = 2000010,
            attachment = null,
            thread = Thread(11, true, true, true)
        )

        WallService.add(post)
        WallService.createComment(comment)
        val actualResult = WallService.getComments().last()

        assertEquals(expectedResult, actualResult)
    }

    @Test (expected = PostNotFoundException::class)
    fun wallService_createComment_Failed(){
        val post = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val comment = Comment(
            id = 1,
            postId = 200001,
            fromId = 1000005,
            date = 10102029,
            text = "",
            donut = mainObjects.comment.additionalObjects.Donut(false, "---"),
            replyToUser = 1000015,
            replyToComment = 2000010,
            attachment = null,
            thread = Thread(11, true, true, true)
        )

        WallService.add(post)
        WallService.createComment(comment)
    }

    @Test
    fun wallService_reportComment_Succeeded(){
        val post = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val comment = Comment(
            id = 2000001,
            postId = 1,
            fromId = 1000005,
            date = 10102029,
            text = "",
            donut = mainObjects.comment.additionalObjects.Donut(false, "---"),
            replyToUser = 1000015,
            replyToComment = 2000010,
            attachment = null,
            thread = Thread(11, true, true, true)
        )
        val report = Report(3000004, 1, 1)

        WallService.add(post)
        WallService.createComment(comment)
        WallService.reportComment(report)
        val actualResult = WallService.getReports().last()

        assertEquals(report, actualResult)
    }

    @Test (expected = CommentNotFoundException::class)
    fun wallService_reportComment_throws_CommentNotFoundException(){
        val post = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val comment = Comment(
            id = 2000001,
            postId = 1,
            fromId = 1000005,
            date = 10102029,
            text = "",
            donut = mainObjects.comment.additionalObjects.Donut(false, "---"),
            replyToUser = 1000015,
            replyToComment = 2000010,
            attachment = null,
            thread = Thread(11, true, true, true)
        )
        val report = Report(3000004, 2000002, 1)

        WallService.add(post)
        WallService.createComment(comment)
        WallService.reportComment(report)
    }

    @Test (expected = UnknownReportReasonException::class)
    fun wallService_reportComment_throws_UnknownReportReasonException(){
        val post = Post(
            id = 2000001,
            ownerId = 1000002,
            fromId = 1000002,
            createdBy = 1000002,
            date = 10102020,
            text = "Текст",
            replyOwnerId = 1000003,
            replyPostId = 2000003,
            friendsOnly = true,
            comments = Comments(5, true, true, false, false),
            copyright = Copyright(3000001, "thatslink.com", "the source", "post"),
            likes = Likes(355, false, true, true),
            reposts = Reposts(2, false),
            views = Views(12544),
            postType = "post",
            attachments = null,
            signerId = 3000003,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            donut = Donut(false, 365, "placeholder", false, "duration"),
            postponedId = 9000003
        )
        val comment = Comment(
            id = 2000001,
            postId = 1,
            fromId = 1000005,
            date = 10102029,
            text = "",
            donut = mainObjects.comment.additionalObjects.Donut(false, "---"),
            replyToUser = 1000015,
            replyToComment = 2000010,
            attachment = null,
            thread = Thread(11, true, true, true)
        )
        val report = Report(3000004, 1, 15)

        WallService.add(post)
        WallService.createComment(comment)
        WallService.reportComment(report)
    }
}