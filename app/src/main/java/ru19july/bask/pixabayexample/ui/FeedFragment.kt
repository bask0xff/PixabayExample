package ru19july.bask.pixabayexampl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru19july.bask.pixabayexample.databinding.FragmentFeedBinding

@AndroidEntryPoint
class FeedFragment : Fragment() {

    val viewModel: FeedViewModel by viewModels()
    var binding: FragmentFeedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        this.binding  = binding

        val adapter = HitsAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.response.observe(viewLifecycleOwner, { response ->
            adapter.setData(response.hits)
        })

        binding.editQuery.addTextChangedListener { editable ->
            viewModel.search(editable.toString())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance(title: String): FeedFragment {
            val args = Bundle().apply { putString("title", title) }
            return FeedFragment().apply { arguments = args }
        }
    }
}