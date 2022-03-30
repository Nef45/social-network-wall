package mainObjects.post.additionalObjects.attachments

import mainObjects.post.additionalObjects.Video

data class VideoAttachment(
    override val attachmentType: String = "video",
    val video: Video
): Attachment {
}