package ie.setu.mobileappdevassignment.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import ie.setu.mobileappdevassignment.R

abstract class ListActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected lateinit var rootContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflateBinding()
        setContentView(binding.root)

        rootContainer = findViewById(R.id.rootContainer)

        setupContent()
    }

    protected abstract fun inflateBinding(): VB
    protected abstract fun setupContent()
}
