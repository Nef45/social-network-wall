package mainObjects.post.additionalObjects.attachments

import mainObjects.post.additionalObjects.Audio

data class AudioAttachment(
    override val attachmentType: String = "audio",
    val audio: Audio
): Attachment {
}