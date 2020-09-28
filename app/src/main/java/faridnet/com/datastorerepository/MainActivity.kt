package faridnet.com.datastorerepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import faridnet.com.datastorerepository.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var mainViewModel: MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.readFromDataStore.observe(this, { myName ->

            name_txt.text = myName

        })

        btn.setOnClickListener {
            val myName = name_et.text.toString()
            mainViewModel.saveToDataStore(myName)
        }

    }
}