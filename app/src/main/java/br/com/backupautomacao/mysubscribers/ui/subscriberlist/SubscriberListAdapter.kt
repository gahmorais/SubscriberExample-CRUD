package br.com.backupautomacao.mysubscribers.ui.subscriberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import br.com.backupautomacao.mysubscribers.data.db.entity.SubscriberEntity
import br.com.backupautomacao.mysubscribers.databinding.SubscriberItemBinding
import br.com.backupautomacao.mysubscribers.databinding.SubscriberListFragmentBinding
import br.com.backupautomacao.mysubscribers.repository.SubscriberRepository

class SubscriberListAdapter(
  private val subscribers: List<SubscriberEntity>,
  private val onSubscriberClickListener: (subscriber: SubscriberEntity) -> Unit
) : RecyclerView.Adapter<SubscriberListAdapter.SubscriberListViewHolder>() {

  private lateinit var binding: SubscriberItemBinding

  inner class SubscriberListViewHolder(
    itemView: View,
    private val onSubscriberClickListener: (subscriber: SubscriberEntity) -> Unit
  ) : RecyclerView.ViewHolder(itemView) {
    fun bind(subscriber: SubscriberEntity) {
      binding.apply {
        tvName.text = subscriber.name
        tvEmail.text = subscriber.email
        root.setOnClickListener {
          onSubscriberClickListener.invoke(subscriber)
        }
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
    binding = SubscriberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return SubscriberListViewHolder(binding.root, onSubscriberClickListener)
  }

  override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
    holder.bind(subscribers[position])
  }

  override fun getItemCount() = subscribers.size
}