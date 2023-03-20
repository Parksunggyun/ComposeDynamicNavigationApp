package sung.gyun.composedynamicnavigationapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import sung.gyun.composedynamicnavigationapp.data.Email
import sung.gyun.composedynamicnavigationapp.data.MailboxType
import sung.gyun.composedynamicnavigationapp.data.local.LocalEmailsDataProvider

class ReplyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ReplyUiState())
    val uiState get() = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val mailboxes: Map<MailboxType, List<Email>> =
            LocalEmailsDataProvider.allEmails.groupBy { it.mailbox }
        _uiState.value =
            ReplyUiState(
                mailboxes = mailboxes,
                currentSelectedEmail = mailboxes[MailboxType.Inbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail
            )
    }

    fun updateDetailsScreenStates(email: Email) {
        _uiState.update {
            it.copy(
                currentSelectedEmail =  email,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreensStates() {
        _uiState.update {
            it.copy(
                currentSelectedEmail = it.mailboxes[it.currentMailbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail,
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentMailbox(mailboxType: MailboxType) {
        _uiState.update {
            it.copy(
                currentMailbox = mailboxType
            )
        }
    }
}