package bicca.lucas.agronutriapp.scene.info_form

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.databinding.ActivityInfoFormBinding
import bicca.lucas.agronutriapp.scene.info_form.fragment.InfoFormFourFragment
import bicca.lucas.agronutriapp.scene.info_form.fragment.InfoFormOneFragment
import bicca.lucas.agronutriapp.scene.info_form.fragment.InfoFormThreeFragment
import bicca.lucas.agronutriapp.scene.info_form.fragment.InfoFormTwoFragment
import bicca.lucas.agronutriapp.scene.info_form.viewmodel.InfoFormViewModel
import bicca.lucas.agronutriapp.view.CustomPagerAdapter

class InfoFormActivity : AppCompatActivity() {

    // region --- ATTRIBUTES ---
    private lateinit var binding: ActivityInfoFormBinding
    private lateinit var viewModel: InfoFormViewModel
    private lateinit var infoFormOneFragment: InfoFormOneFragment
    private lateinit var infoFormTwoFragment: InfoFormTwoFragment
    private lateinit var infoFormThreeFragment: InfoFormThreeFragment
    private lateinit var infoFormFourFragment: InfoFormFourFragment
    private val handler: Handler = Handler()
    private val goToResult = object: Runnable {
        override fun run() {
            navigateToResult()
        }
    }
    // endregion

    // region --- LIFECYCLE ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info_form)
        viewModel = ViewModelProviders.of(this).get(InfoFormViewModel::class.java)
        binding.viewModel = viewModel

        infoFormOneFragment = InfoFormOneFragment.newInstance()
        infoFormTwoFragment = InfoFormTwoFragment.newInstance()
        infoFormThreeFragment = InfoFormThreeFragment.newInstance()
        infoFormFourFragment = InfoFormFourFragment.newInstance()

        val fragments = arrayOf(
                infoFormOneFragment, infoFormTwoFragment,
                infoFormThreeFragment, infoFormFourFragment
        )
        viewModel.totalSteps = fragments.size
        val adpter = CustomPagerAdapter(supportFragmentManager, fragments)
        binding.activityInfoFormPager.adapter = adpter
        binding.activityInfoFormIndicator.setViewPager(binding.activityInfoFormPager)
        binding.activityInfoFormIndicator.stepCount = fragments.size

        initLiveData()
        initPagerListener()
    }

    override fun onResume() {
        super.onResume()
        viewModel.currentStep.value = 0
    }

    override fun onBackPressed() {
        viewModel.currentStep.value?.let {
            if (it == 0) finish()
            else viewModel.onPreviousClick()
        }
    }
    // endregion

    // region --- LIVE DATA ---
    private fun initLiveData() {
        initCurrentStepLiveData()
        initLastStepLiveData()
        initGoToNextScreen()
    }

    private fun initCurrentStepLiveData() {
        val stepObserver = Observer<Int> { result ->
            if (result != null) {
                binding.activityInfoFormPager.currentItem = result
                binding.activityInfoFormIndicator.currentStep = result
            }
        }
        viewModel.currentStep.observe(this, stepObserver)
    }

    private fun initLastStepLiveData() {
        val lastStepObserver = Observer<Boolean> { result ->
            if (result != null && result) {
                prepareTonavigateToResult()
            }
        }
        viewModel.lastStep.observe(this, lastStepObserver)
    }

    private fun initGoToNextScreen() {
        val goToNextScreen = Observer<Boolean> { result ->
            if (result != null && result) {
                when (viewModel.currentStep.value) {
                    0 -> viewModel.shouldShowErrors = infoFormOneFragment.viewModel.shouldShowErrors()
                    1 -> viewModel.shouldShowErrors = infoFormTwoFragment.viewModel.shouldShowErros()
                    2 -> viewModel.shouldShowErrors = infoFormThreeFragment.viewModel.shouldShowErrors()
                }

                viewModel.goToNextScreen()
            }
        }
        viewModel.shouldValidateToGoToNextScreen.observe(this, goToNextScreen)
    }
    // endregion

    // region --- LISTENER ---
    private fun initPagerListener() {
        binding.activityInfoFormPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                viewModel.currentStep.value = position
            }
        })
    }
    // endregion

    // region --- NAVIGATION ---
    private fun prepareTonavigateToResult() {
        viewModel.currentStep.value = viewModel.currentStep.value?.plus(1)
        handler.postDelayed(goToResult, 1000)
    }

    private fun navigateToResult() {
        Toast.makeText(this@InfoFormActivity, "Exibir Resultado", Toast.LENGTH_SHORT).show()
    }
    // endregion

}
