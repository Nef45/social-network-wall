package mainObjects.post.additionalObjects.attachments

import mainObjects.post.additionalObjects.Doc

data class DocAttachment(
    override val attachmentType: String = "doc",
    val doc: Doc
): Attachment {
}