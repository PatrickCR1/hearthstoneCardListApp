package com.example.hearthstonelist.ui.viewmodel


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hearthstonelist.R
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.repository.CardRepository
import kotlinx.coroutines.launch

class CardListViewModel(private val repository: CardRepository, private val context: Context) :
    ViewModel() {

    // Live Data
    private val _cards = MutableLiveData<List<CardModel?>>()
    val cards: LiveData<List<CardModel?>> = _cards

    private val _clickCard = MutableLiveData<CardModel>()
    val clickCard: LiveData<CardModel> = _clickCard

    // Listener
    val listener = object : APIListener<List<CardModel?>> {
        override fun onSuccess(result: List<CardModel?>) {
            _cards.value = result
        }

        override fun onFailure(message: String?) {
            if (message == null) {
                showToast(context.getString(R.string.ERROR_UNEXPECTED))
            }
        }
    }

    private fun showToast(string: String) {
        Toast.makeText(
            context,
            string,
            Toast.LENGTH_SHORT
        ).show()
    }

    // Get Lists
    fun list() {
            if (isConnectionAvailable()){
                viewModelScope.launch {
                    repository.listAll(listener)
                }
            } else {
                showToast(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            }
    }

    fun listClass(hsClass: String) {
        if (isConnectionAvailable()){
            viewModelScope.launch {
                repository.listClass(hsClass, listener)
            }
        } else {
            showToast(context.getString(R.string.ERROR_INTERNET_CONNECTION))
        }
    }

    fun navigate(card: CardModel) {
        _clickCard.value = card
    }

    // Check Internet
    fun isConnectionAvailable(): Boolean {
        var result = false

        // Connection Manager
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Check SDK Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNet = cm.activeNetwork ?: return false
            val netWorkCapabilities = cm.getNetworkCapabilities(activeNet) ?: return false
            result = when {
                netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            if (cm.activeNetworkInfo != null) {
                result = when (cm.activeNetworkInfo!!.type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return result
    }
}
