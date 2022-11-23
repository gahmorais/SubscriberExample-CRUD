package br.com.backupautomacao.mysubscribers.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.com.backupautomacao.mysubscribers.data.db.AppDatabase
import br.com.backupautomacao.mysubscribers.databinding.SubscriberListFragmentBinding
import br.com.backupautomacao.mysubscribers.repository.DatabaseDatasource

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
      setHasOptionsMenu(allSubscribers.size > 1)
      val subscriberListAdapter = SubscriberListAdapter(allSubscribers) { subscribers ->
        SubscriberListFragmentDirections.actionSubscriberListFragmentToSubscriberFragment(
          subscribers
        )
      }
    }
  }

}