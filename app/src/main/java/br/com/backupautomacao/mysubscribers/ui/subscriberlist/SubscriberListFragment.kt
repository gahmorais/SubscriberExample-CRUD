package br.com.backupautomacao.mysubscribers.ui.subscriberlist

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import br.com.backupautomacao.mysubscribers.MainActivityDirections
import br.com.backupautomacao.mysubscribers.R
import br.com.backupautomacao.mysubscribers.data.db.AppDatabase
import br.com.backupautomacao.mysubscribers.databinding.SubscriberFragmentBinding
import br.com.backupautomacao.mysubscribers.databinding.SubscriberListFragmentBinding
import br.com.backupautomacao.mysubscribers.repository.DatabaseDatasource
import br.com.backupautomacao.mysubscribers.repository.SubscriberRepository

class SubscriberListFragment : Fragment() {
  private lateinit var binding: SubscriberListFragmentBinding
  private val viewModel: SubscriberListViewModel by activityViewModels {
    val subscriberDao = AppDatabase.getInstance(requireContext()).subscriberDao
    val repository = DatabaseDatasource(subscriberDao)
    SubscriberListViewModelFactory(repository)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding = SubscriberListFragmentBinding.inflate(layoutInflater)
    super.onViewCreated(binding.root, savedInstanceState)
    observeViewModelEvents()
//    configureViewListeners()
  }

  private fun observeViewModelEvents() {
    viewModel.allSubscriberEvent.observe(viewLifecycleOwner) { allSubscribers ->

    }
  }
}