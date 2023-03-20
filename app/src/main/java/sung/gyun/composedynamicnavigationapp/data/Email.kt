package sung.gyun.composedynamicnavigationapp.data

data class Email(
    val id: Int,
    val sender: Account,
    val recipients: List<Account> = emptyList(),
    val subject: String = "",
    val body: String = "",
    val mailbox: MailboxType = MailboxType.Inbox,
    val createdAt: String,
)