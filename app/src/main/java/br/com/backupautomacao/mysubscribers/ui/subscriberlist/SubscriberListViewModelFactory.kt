package br.com.backupautomacao.mysubscribers.ui.subscriberlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.backupautomacao.mysubscribers.repository.SubscriberRepository
import br.com.backupautomacao.mysubscribers.ui.subscriber.SubscriberViewModel
import java.lang.IllegalArgumentException

class SubscriberListViewModelFactory(private val repository: SubscriberRepository) :
  ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(SubscriberListViewModel::class.java)) {
      return SubscriberListViewModel(repository) as T
    }

    throw IllegalArgumentException("ViewModel não reconhecido")
  }
}