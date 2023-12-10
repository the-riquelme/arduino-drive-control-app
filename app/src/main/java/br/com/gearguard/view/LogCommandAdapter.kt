package br.com.gearguard.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import br.com.gearguard.databinding.LogItemBinding
import br.com.gearguard.model.LogCommandEntity

class LogCommandAdapter(val logsCommand: MutableList<LogCommandEntity>?): RecyclerView.Adapter<LogCommandHold>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogCommandHold {
        val item = LogItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return LogCommandHold(item)
    }

    override fun getItemCount(): Int {
        return logsCommand?.size ?: 0
    }

    override fun onBindViewHolder(holder: LogCommandHold, position: Int) {
        holder.bind(logsCommand!![position])
    }
}