package dilmurodhamdamov.uz.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dilmurodhamdamov.uz.R
import dilmurodhamdamov.uz.databinding.ActivityMainBinding
import dilmurodhamdamov.uz.model.PhotoModel
import dilmurodhamdamov.uz.view.PhotoAdapter
import dilmurodhamdamov.uz.view.PhotoAdapterListener
import kotlinx.coroutines.GlobalScope

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.error.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        viewModel.progress.observe(this){
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.photoListData.observe(this){

            binding.recycler.adapter = PhotoAdapter(it, object:PhotoAdapterListener{
                override fun onClicked(item: PhotoModel) {
                    Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
            })
        }

        viewModel.getPhotoList()

    }
}