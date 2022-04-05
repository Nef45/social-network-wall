package mainObjects.start

import mainObjects.post.Post
import mainObjects.wallService.WallService
import mainObjects.post.additionalObjects.*
import mainObjects.post.additionalObjects.attachments.*

fun main() {

    val photoAttachment = PhotoAttachment(photo = Photo(11,11,11,11))
    val videoAttachment = VideoAttachment(video = Video(22,22,22,22))
    val audioAttachment = AudioAttachment(audio = Audio(33,33))
    val docAttachment = DocAttachment(doc = Doc(44, 44))
    val linkAttachment = LinkAttachment(link = Link("www.123.ru"))

    var arrayOfAttachments = emptyArray<Attachment>()
    arrayOfAttachments += photoAttachment
    arrayOfAttachments += videoAttachment
    arrayOfAttachments += audioAttachment
    arrayOfAttachments += docAttachment
    arrayOfAttachments += linkAttachment


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
        attachments = arrayOfAttachments,
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
        attachments = arrayOfAttachments,
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

    println(WallService.add(post1))
    WallService.update(post2)
}

