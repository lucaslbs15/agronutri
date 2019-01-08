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
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormFourViewModel
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

class InfoFormFourFragment : Fragment() {

    // region --- ATTRIBUTES ---
    companion object {
        fun newInstance() = InfoFormFourFragment()
    }

    private lateinit var viewModel: InfoFormFourViewModel
    private lateinit var binding: InfoFormFourFragmentBinding
    // endregion

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(InfoFormFourViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form_four_fragment, container, false)
        setupWatchers()
        return binding.root
    }

    // region --- LISTENERS ---
    private fun setupWatchers() {
        binding.infoFormFourFragmentTieMo.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieClay.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieKMol.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieTexture.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTiePMehlich.addTextChangedListener(ValorMonetarioWatcher())
        binding.infoFormFourFragmentTieCtc.addTextChangedListener(ValorMonetarioWatcher())
    }
    // endregion

}
