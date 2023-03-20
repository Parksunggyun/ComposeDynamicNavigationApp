package sung.gyun.composedynamicnavigationapp.ui

import sung.gyun.composedynamicnavigationapp.data.Email
import sung.gyun.composedynamicnavigationapp.data.MailboxType
import sung.gyun.composedynamicnavigationapp.data.local.LocalEmailsDataProvider

data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    val currentMailbox: MailboxType = MailboxType.Inbox,
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    val isShowingHomepage: Boolean = true
) {
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}