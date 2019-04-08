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
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.scene.BundleConstants
import bicca.lucas.agronutriapp.scene.info_form.OnPlantItemClickListener
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormOneViewModel
import bicca.lucas.agronutriapp.utils.KeyboardUtils
import bicca.lucas.agronutriapp.view.PlantAdapter

class InfoFormOneFragment : Fragment(), OnPlantItemClickListener {

    // region --- ATTRIBUTES ---
    private lateinit var binding: InfoFormOneFragmentBinding
    lateinit var viewModel: InfoFormOneViewModel
    lateinit var adapter: PlantAdapter
    // endregion

    // region --- LIFECYCLE ---
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_one_fragment, container, false)
        binding.context = context
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoFormOneViewModel::class.java)
        savedInstanceState?.getParcelable<InfoForm>(BundleConstants.INFO_FORM_ONE)?.let {
            viewModel.setValues(it)
        }
        binding.viewModel = viewModel
        initPlantAdapter()
        initOnFocusChange()
        initLiveData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(BundleConstants.INFO_FORM_ONE, viewModel.getValues())
    }

    override fun onResume() {
        super.onResume()
        viewModel.showPlantOptions.value = false
        viewModel.showInputTypeOptions.value = false
    }
    // endregion

    // region --- LOAD ADAPTER ---
    private fun initPlantAdapter() {
        adapter = PlantAdapter(context!!, this, R.layout.item_plant, viewModel.getPlants())
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
                if (!result) KeyboardUtils.hideKeyboard(context!!, binding.root)
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
        binding.infoFormOneFragmentActPlant.setOnFocusChangeListener { v, hasFocus ->
            viewModel.showPlantOptions.value = hasFocus
        }
    }

    private fun initInputTypeOnFocusChange() {
        binding.infoFormOneFragmentTieInputType.setOnFocusChangeListener { v, hasFocus ->
            viewModel.showInputTypeOptions.value = hasFocus
        }
    }

    override fun onPlantClick(plantEnum: PlantEnum) {
        viewModel.updatePlantSelected(plantEnum)
        adapter.plantSelected = plantEnum
        binding.infoFormOneFragmentActPlant.dismissDropDown()
        binding.infoFormOneFragmentRoot.requestFocus()
    }
    // endregion

    companion object {
        fun newInstance() = InfoFormOneFragment()
    }
}
