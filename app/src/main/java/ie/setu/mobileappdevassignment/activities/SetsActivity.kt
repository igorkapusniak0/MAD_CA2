package ie.setu.mobileappdevassignment.activities

import android.os.Bundle
import android.widget.LinearLayout
import ie.setu.mobileappdevassignment.R
import ie.setu.mobileappdevassignment.controllers.SetsController
import ie.setu.mobileappdevassignment.databinding.ActivityCollectionsBinding


class SetsActivity: NavActivity() {
    private lateinit var binding: ActivityCollectionsBinding
    private lateinit var controller: SetsController
    private lateinit var rootController: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCollectionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller = SetsController(this)

        rootController = findViewById(R.id.rootContainer)
        controller.addSetView(this, rootController)
    }

}