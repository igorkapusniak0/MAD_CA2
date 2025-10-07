package ie.setu.mobileappdevassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ie.setu.mobileappdevassignment.controllers.DiscoverController
import ie.setu.mobileappdevassignment.controllers.SetsController
import ie.setu.mobileappdevassignment.databinding.ActivityListBinding
import ie.setu.mobileappdevassignment.databinding.ListViewBinding
import ie.setu.mobileappdevassignment.utilities.Utils

class DiscoverSetFragment: Fragment() {
    private var _binding: ListViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var controller: DiscoverController
    private lateinit var setsController: SetsController
    private lateinit var utils: Utils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        utils = Utils(requireContext())
        controller = DiscoverController(requireContext())
        setsController = SetsController(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListViewBinding.inflate(inflater, container, false)
        val sets = controller.getAllPublicSets()
        setsController.addSetView(requireContext(), binding.rootContainer, sets)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}