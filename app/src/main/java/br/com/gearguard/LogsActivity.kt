package br.com.gearguard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import br.com.gearguard.controller.LogCommandController
import br.com.gearguard.databinding.ActivityLogsBinding
import br.com.gearguard.viewmodel.LogsCommandsViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gearguard.view.LogCommandAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class LogsActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityLogsBinding
    lateinit var logCommandController: LogCommandController
    lateinit var adapter: LogCommandAdapter
    lateinit var viewModel: LogsCommandsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logCommandController = LogCommandController(baseContext)
        viewModel = ViewModelProvider(this)[LogsCommandsViewModel::class.java]

        registerEvent()
        configureRecycleView()
    }

    private fun registerEvent() {
        binding.btnBack.setOnClickListener(this)
    }

    override fun onClick(button: View) {
        when (button.id) {
            binding.btnBack.id -> executeMenu()
        }
    }

    private fun executeMenu() {
        val menuActivity = Intent(baseContext, MenuActivity::class.java)
        startActivity(menuActivity)
    }

    private fun configureRecycleView() {
        viewModel.loadLogsCommand(logCommandController.getAllLogs())
        adapter = LogCommandAdapter(viewModel.getLogsCommand())

        binding.logsList.layoutManager = LinearLayoutManager(baseContext)
        binding.logsList.adapter = adapter
    }

}