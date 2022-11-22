package br.com.backupautomacao.mysubscribers.ui.subscriberlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.backupautomacao.mysubscribers.data.db.entity.SubscriberEntity
import br.com.backupautomacao.mysubscribers.repository.SubscriberRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.coroutineContext

class SubscriberListViewModel(private val repository: SubscriberRepository) : ViewModel() {
  private val _allSubscriverEvent = MutableLiveData<List<SubscriberEntity>>()
  val allSubscriberEvent: LiveData<List<SubscriberEntity>> = _allSubscriverEvent

  private val _deleteAllSubscriberEvent = MutableLiveData<Unit>()
  val deleteAllSubscriberEvent = _deleteAllSubscriberEvent

  fun getSubscribers() = viewModelScope.launch {
    try {
      repository.deleteAllSubscriber()
      _deleteAllSubscriberEvent.postValue(Unit)
    } catch (e: Exception) {
      Log.e("SubscriberListViewModel", "getSubscribers: ${e.message}", e)
    }

  }

}