package bicca.lucas.agronutriapp.scene.info_form.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.InfoFormFourFragmentBinding
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.scene.BundleConstants
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormFourViewModel
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

class InfoFormFourFragment : Fragment() {

    // region --- ATTRIBUTES ---
    companion object {
        fun newInstance() = InfoFormFourFragment()
    }

    lateinit var viewModel: InfoFormFourViewModel
    private lateinit var binding: InfoFormFourFragmentBinding
    // endregion

    // region --- LIFECYCLE ---
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_four_fragment, container, false)
        setupWatchers()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoFormFourViewModel::class.java)
        savedInstanceState?.getParcelable<InfoForm>(BundleConstants.INFO_FORM_FOUR)?.let {
            viewModel.setValues(it)
        }
        binding.viewModel = viewModel
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(BundleConstants.INFO_FORM_FOUR, viewModel.getValues())
    }
    // endregion

    // region --- LISTENERS ---
    private fun setupWatchers() {
        binding.infoFormFourFragmentTieMo.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieClay.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieKMol.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieTexture.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTiePMehlich.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieCtc.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieS.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieKMg.addTextChangedListener(ValorMonetarioWatcher())
    }
    // endregion

}
