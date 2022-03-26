package mainObjects.post

import mainObjects.post.additionalObjects.*
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
        val expectedResult = 2000001

        val (id) = WallService.add(post1)
        val actualResult = id

        assertEquals(expectedResult, actualResult)
        assertTrue(actualResult != 0)
    }

    @Test
    fun wallService_update_returnTrue_when_IdExists() {
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
            id = 2000001,
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

    @Test
    fun wallService_update_returnFalse_when_IdDoesntExist() {
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

        assertFalse(actualResult)
    }
}