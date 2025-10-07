package ie.setu.mobileappdevassignment.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ie.setu.mobileappdevassignment.controllers.CollectionsController
import ie.setu.mobileappdevassignment.controllers.DiscoverController
import ie.setu.mobileappdevassignment.databinding.ActivityListBinding
import ie.setu.mobileappdevassignment.databinding.ListViewBinding
import ie.setu.mobileappdevassignment.utilities.Utils

class DiscoverCollectionFragment: Fragment() {
    private var _binding: ListViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var controller: DiscoverController
    private lateinit var collectionsController: CollectionsController
    private lateinit var utils: Utils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        utils = Utils(requireContext())
        controller = DiscoverController(requireContext())
        collectionsController = CollectionsController(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListViewBinding.inflate(inflater, container, false)
        val collections = controller.getAllPublicCollections()
        Log.d("collectionsList", collections.toString())
        collectionsController.addCollectionView(requireContext(), binding.rootContainer, collections)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}