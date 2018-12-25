package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.InfoFormOneFragmentBinding
import bicca.lucas.agronutriapp.logic.PlantEnum
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormOneViewModel
import bicca.lucas.agronutriapp.view.PlantAdapter
import java.util.ArrayList

class InfoFormOneFragment : Fragment() {

    private lateinit var binding: InfoFormOneFragmentBinding
    lateinit var viewModel: InfoFormOneViewModel

    // region --- LIFECYCLE ---
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_one_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(InfoFormOneViewModel::class.java)
        binding.viewModel = viewModel
        binding.context = context
        initPlantAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnFocusChange()
        initLiveData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.showPlantOptions.value = false
        viewModel.showInputTypeOptions.value = false
    }
    // endregion

    // region --- LOAD ADAPTER ---
    private fun initPlantAdapter() {
        val adapter = PlantAdapter(context!!, R.layout.item_plant, viewModel.getPlants())
        binding.infoFormOneFragmentActPlant.threshold = 3
        binding.infoFormOneFragmentActPlant.setAdapter(adapter)
    }
    // endregion

    // region --- LIVEDATA ---
    private fun initLiveData() {
        initShowPlantLiveData()
        initShowInputTypeLiveData()
    }

    private fun initShowPlantLiveData() {
        val plantObserver = Observer<Boolean> { result ->
            if (result != null) {
                //TODO setVisibility

            }
        }
        viewModel.showPlantOptions.observe(this, plantObserver)
    }

    private fun initShowInputTypeLiveData() {
        val inputTypeObserver = Observer<Boolean> { result ->
            if (result != null) {
                binding.infoFormOneFragmentCvInputType.visibility = if (result) View.VISIBLE else View.GONE
                if (!result) binding.infoFormOneFragmentTieInputType.clearFocus()
            }
        }
        viewModel.showInputTypeOptions.observe(this, inputTypeObserver)
    }
    // endregion

    // region --- LISTENER ---
    private fun initOnFocusChange() {
        iniPlantOnFocusChange()
        initInputTypeOnFocusChange()
    }

    private fun iniPlantOnFocusChange() {
        /*binding.infoFormOneFragmentTiePlant.setOnFocusChangeListener { v, hasFocus ->
            viewModel.showPlantOptions.value = hasFocus
        }*/
    }

    private fun initInputTypeOnFocusChange() {
        binding.infoFormOneFragmentTieInputType.setOnFocusChangeListener { v, hasFocus ->
            viewModel.showInputTypeOptions.value = hasFocus
        }
    }
    // endregion

    companion object {
        fun newInstance() = InfoFormOneFragment()
    }
}
