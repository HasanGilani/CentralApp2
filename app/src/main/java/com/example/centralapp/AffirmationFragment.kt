package com.example.centralapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class AffirmationFragment : Fragment() {

    private lateinit var dailyAffirmation: TextView
    private lateinit var moodSpinner: Spinner
    private lateinit var saveMoodButton: Button
    private lateinit var moodListView: ListView
    private lateinit var moodList: ArrayList<String>
    private lateinit var moodAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_affirmation, container, false)

        dailyAffirmation = view.findViewById(R.id.dailyAffirmation)
        moodSpinner = view.findViewById(R.id.moodSpinner)
        saveMoodButton = view.findViewById(R.id.saveMoodButton)
        moodListView = view.findViewById(R.id.moodListView)

        // Set up Spinner with mood options
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.moods_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        moodSpinner.adapter = adapter

        // Initialize mood list and adapter
        moodList = ArrayList()
        moodAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, moodList)
        moodListView.adapter = moodAdapter

        // Set Spinner item selected listener
        moodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle no item selected
            }
        }

        // Set Button click listener
        saveMoodButton.setOnClickListener {
            val selectedMood = moodSpinner.selectedItem.toString()
            moodList.add(selectedMood)
            moodAdapter.notifyDataSetChanged()
        }

        return view
    }

    companion object {
        fun newInstance(): AffirmationFragment {
            return AffirmationFragment()
        }
    }
}