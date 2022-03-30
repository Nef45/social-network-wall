package mainObjects.post.additionalObjects.attachments

import mainObjects.post.additionalObjects.Photo

data class PhotoAttachment(
    override val attachmentType: String = "photo",
    val photo: Photo
): Attachment {
}