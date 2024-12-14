package com.example.myprofilecompose.ui.contact.viewModel

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprofilecompose.R
import com.example.myprofilecompose.ui.contact.state.ContactState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val _contactState = MutableStateFlow<ContactState?>(null)
    val contactState: StateFlow<ContactState?> = _contactState

    fun sendEmail(context: Context) {
        viewModelScope.launch {
            _contactState.value = ContactState.Loading
            try {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:jeannette.smm87@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.email_consult_my_app))
                    putExtra(Intent.EXTRA_TEXT, context.getString(R.string.email_message_contact_me))
                }
                context.startActivity(
                    Intent.createChooser(emailIntent, context.getString(R.string.email_chosser_title))
                )
                _contactState.value = ContactState.Success
            } catch (e: Exception) {
                _contactState.value = ContactState.Error(e.localizedMessage ?: "Error desconocido")
            }
        }
    }

    fun resetState() {
        _contactState.value = null
    }


}