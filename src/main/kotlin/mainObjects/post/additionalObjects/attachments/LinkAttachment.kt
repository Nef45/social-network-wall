package mainObjects.post.additionalObjects.attachments

import mainObjects.post.additionalObjects.Link

data class LinkAttachment(
    override val attachmentType: String = "link",
    val link: Link
): Attachment {
}